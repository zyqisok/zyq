package com.zyq.tools.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.zyq.tools.HttpClientTool;


/**
 * HttpClient工具类测试代码
 * @author zyq
 * @date 2019-04-22
 */
public class HttpClientToolTest {

    @Test
    public void getTest() {
        String resp = HttpClientTool.get("https://www.qidian.com/news/detail/653703452");
        System.out.println(resp);
    }

    @Test
    public void post() {
        String url = "https://www.w3cschool.cn/checklogin";
        Map<String, String> params = new HashMap<String, String>();
        params.put("refer", "");
        params.put("username", "18380379959");
        params.put("password", "********"); // 密码略
        params.put("remember", "1");
        String resp = HttpClientTool.post(url, params);
        System.out.println(resp);
    }

    @Test
    public void postFileTest() throws IOException {
        String url = "http://localhost/upload";
        File file = new File("a.jpg");
        if (!file.exists()) {
            file.createNewFile();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("file", file);
        params.put("fileName", file.getName());
        String resp = HttpClientTool.postFile(url, params);
        System.out.println(resp);
    }

    @Test
    public void getFileTest() {
        HttpClientTool.getFile("http://www.w3cschool.cn/attachments/image/20170302/1488437701888550.png", "b.jpg");
    }
}
