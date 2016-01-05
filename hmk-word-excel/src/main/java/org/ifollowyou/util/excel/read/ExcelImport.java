package org.ifollowyou.util.excel.read;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 将excel数据装换成数据模型
 *
 * @author
 */
public class ExcelImport {
    private static final int HEADER = 0;


    private static final int START = 1;


    private XSSFWorkbook book;
    /**
     * key:excel对应标题 ,value:对象属性
     */
    private Map<String, String> associations;
    /**
     * 装换失败的数据信息，记录行数
     */
    private StringBuffer error = new StringBuffer(0);


    private Map<Integer, String> header;
    /**
     * 默认的日期格式
     */
    private String date_format = "yyyy-MM-dd";


    private SimpleDateFormat format;


    /**
     * 初始化工作簿
     *
     * @param file
     */
    public void init(File file) {
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            book = new XSSFWorkbook(in);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public ExcelImport(Map<String, String> associations) {
        this.associations = associations;
        format = new SimpleDateFormat(date_format);


    }


    public ExcelImport(Map<String, String> associations, String date_format) {
        this.associations = associations;
        this.date_format = date_format;
        format = new SimpleDateFormat(date_format);
    }


    /**
     * @return true 存在错误，false 不存在错误
     */
    public boolean hasError() {
        return error.capacity() > 0;
    }


    public StringBuffer getError() {
        return error;
    }


    /**
     * 获取第一行标题栏数据
     *
     * @param sheet
     * @return map key：标题栏列下标（0开始） value 标题栏值
     */
    private void loadHeader(XSSFSheet sheet) {
        this.header = new HashMap<Integer, String>();
        XSSFRow row = sheet.getRow(HEADER);
        int columns = row.getLastCellNum();
        for (int i = 0; i < columns; i++) {
            System.out.println("加载标题栏:" + row.getCell(i).getStringCellValue());
            String value = row.getCell(i).getStringCellValue();
            if (null == value) {
                throw new RuntimeException("标题栏不能为空！");
            }
            header.put(i, value);
        }

        System.out.println("<<<<<<<<<<<<标题栏加载完毕>>>>>>>>>>>");
    }


    /**
     * @param clazz
     * @param required 是否每个属性都是必须的
     * @return
     */
    public <T> List<T> bindToModels(Class clazz, boolean required)
            throws Exception {
// 获取第一页
        XSSFSheet sheet = this.book.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();// 获取行数


        if (rowNum < 1) {
            return new ArrayList<T>();
        }
// 加载标题栏数据
        this.loadHeader(sheet);
        List<T> result = new ArrayList<T>();


        for (int i = START; i <= rowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            int cellNum = row.getLastCellNum();
            T instance = (T) clazz.newInstance();


            for (int columns = 0; columns < cellNum; columns++) {
                XSSFCell cell = row.getCell(columns);
// 判断单元格的数据类型
                String value = loadCellType(cell);


// 获取单元格的值
                if (null == value) {
// 如果为必填的则将错误信息记录
                    if (required) {
                        this.error.append(
                                "第" + (i + 1) + "行，" + header.get(columns)
                                        + "字段，数据为空，跳过！").append("\n");
                        System.out.println("第" + (i + 1) + "行，" + header.get(columns) + "字段，数据为空，跳过！");
                        continue;
                    }
                } else {
                    String key = header.get(columns);
                    if(key == null) continue;
// 加载实际值
                    this.loadValue(clazz, instance, this.associations.get(key),
                            value);
                }
            }
            result.add(instance);
        }
        System.out.println("<<<<<装换完成" + (this.hasError() ? "有错误信息" : "") + "，共有对象:"
                + result.size() + "个" + ">>>>>>");
        return result;
    }


    private String loadCellType(XSSFCell cell) {
        String value = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
// 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    value = this.formateDate(cell.getDateCellValue());
                } else {
                    value = String.valueOf((long) cell.getNumericCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                System.out.println("不支持函数！");
                break;
        }


        return value;
    }


    /**
     * 注入属性值
     *
     * @param instance
     * @param pro      属性对象
     * @param value    属性值
     */
    @SuppressWarnings("unchecked")
    private <T> void loadValue(Class clazz, T instance, String pro, String value)
            throws SecurityException, NoSuchMethodException, Exception {
        String getMethod = this.initGetMethod(pro);
        Class type = clazz.getDeclaredMethod(getMethod, null).getReturnType();


        Method method = clazz.getMethod(this.initSetMethod(pro), type);


        if (type == String.class) {
            method.invoke(instance, value);
        } else if (type == int.class || type == Integer.class) {
            method.invoke(instance, Integer.parseInt(value));


        } else if (type == long.class || type == Long.class) {
            method.invoke(instance, Long.parseLong(value));


        } else if (type == float.class || type == Float.class) {
            method.invoke(instance, Float.parseFloat(value));


        } else if (type == double.class || type == Double.class) {
            method.invoke(instance, Double.parseDouble(value));


        } else if (type == Date.class) {
            method.invoke(instance, this.parseDate(value));
        }


    }


    private Date parseDate(String value) throws ParseException {
        return format.parse(value);
    }


    private String formateDate(Date date) {
        return format.format(date);
    }


    public String initSetMethod(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }


    public String initGetMethod(String field) {
        String result = "";

        try {
            result = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public String getDate_format() {
        return date_format;
    }


    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }


}