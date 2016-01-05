package org.ifollowyou.util.excel.read;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerImportTest {

    @Test
    public void importToObject() {
        bindFileToObject();
    }

    @Test
    public void exportToWord() {
        List<Player> players = bindFileToObject();
        List<PlayerWrapper> wrappers = new ArrayList<PlayerWrapper>();
        for (int i = 0; i < players.size(); i = i + 2) {
            PlayerWrapper wrapper = new PlayerWrapper();
            wrapper.setPlayerA(players.get(i));
            wrapper.setPlayerB(players.get(i + 1));

            wrappers.add(wrapper);
        }

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("wrappers", wrappers);

        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");

        configuration.setClassForTemplateLoading(this.getClass(), "/");
        Template t = null;
        try {
            t = configuration.getTemplate("players2.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出文档路径及名称
        File outFile = new File("players.xml");
        Writer out = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
            //这个地方对流的编码不可或缺
            out = new BufferedWriter(oWriter);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out);
            out.close();
            fos.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List bindFileToObject() {
        Map<String, String> associations = new HashMap<String, String>();
        associations.put("序号", "xh");
        associations.put("参赛号码", "cshm");
        associations.put("芯片号码", "xphm");
        associations.put("报名项目", "bmxm");
        associations.put("团体名称", "ttmc");
        associations.put("缴费状态", "jfzt");
        associations.put("手机号", "sjh");
        associations.put("姓名", "xm");
        associations.put("性别", "xb");
        associations.put("证件类型", "zjlx");
        associations.put("证件号码", "zjhm");
        associations.put("紧急联系人", "jjlx");
        associations.put("紧急联系电话", "jjlxhm");
        associations.put("报名方式", "bmfs");
        associations.put("号段", "hd");

        ExcelImport excelImport = new ExcelImport(associations);
        List<Player> list = null;
        try {
            File pwd = new File(".");
            File xls = new File(pwd, "src/main/resources/player.xlsx");
            if (xls.exists()) {
                excelImport.init(xls);
                list = excelImport.bindToModels(Player.class, true);

                System.out.println(list.size());
                System.out.println(list);
            } else {
                System.out.println("=====Not found file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list.size() % 2 != 0) {
            list.add(new Player());
        }

        return list;
    }
}
