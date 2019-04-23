package com.zyq.tools.test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.zyq.beans.User;
import com.zyq.tools.ExcelTool;

/**
 * Excel工具类测试代码
 * @author zyq
 *
 */
public class ExcelToolTest {

    @Test
    public void exportTest() {
        String title = "abc";
        List<List<Object>> rowList = new ArrayList<List<Object>>();
        // 表头
        List<Object> head = new ArrayList<Object>();
        head.add("头像");
        head.add("姓名");
        head.add("年龄");
        head.add("备注");
        head.add("空间");
        rowList.add(head);
        // 表数据
        List<Object> row = new ArrayList<Object>();
        try {
            row.add(new URL("https://cdn-img.easyicon.net/png/11002/1100254.gif"));
        } catch (Exception e) {}
        row.add("孙悟空");
        row.add("18");
        row.add("唐僧大徒弟");
        row.add("https://www.baidu.com");
        rowList.add(row);
        List<Object> row2 = new ArrayList<Object>();
        try {
            row2.add(new URL("https://cdn-img.easyicon.net/png/5467/546720.gif"));
        } catch (Exception e) {}
        row2.add("猪八戒");
        row2.add("18");
        row2.add("唐僧儿徒弟");
        row2.add("https://www.tencent.com");
        rowList.add(row2);
        ExcelTool.export(title, rowList);
        System.out.println("Export finish ....");
    }

    @Test
    public void getBeanListTest() {
        // 测试该方法，请先测试上面导出方法，确保文件存在
        File file = new File("abc.xlsx");
        List<User> beanList = ExcelTool.getBeanList(User.class, file);
        for (User user : beanList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void getExcelDataTest() {
        // 测试该方法，请先测试上面导出方法，确保文件存在
        File file = new File("abc.xlsx");
        JSONArray array = ExcelTool.getExcelData(file);
        System.out.println(array);
    }

}
