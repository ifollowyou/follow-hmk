package org.ifollowyou.util.excel.read;


import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelImportTest {

    @Test
    public void test() {
        Map<String, String> associations = new HashMap<String, String>();
        associations.put("姓名", "name");
        associations.put("年龄", "age");

        ExcelImport excelImport = new ExcelImport(associations);

        try {
            File pwd = new File(".");
            File xls = new File(pwd, "src/main/resources/xls2java.xlsx");
            if(xls.exists()) {
                excelImport.init(xls);
                List<Person> list = excelImport.bindToModels(Person.class, true);

                System.out.println(list.size());
                System.out.println(list);
            }
            else {
                System.out.println("=====Not found file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
