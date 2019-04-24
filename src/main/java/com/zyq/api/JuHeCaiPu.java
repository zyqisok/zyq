package com.zyq.api;

import java.util.HashMap;
import java.util.Map;

import com.zyq.tools.HttpClientTool;

/**
 *  聚合：菜谱大全
    参考链接：https://www.juhe.cn/docs/api/id/46
    错误码 - 错误描述 - 旧版本错误码
    204601  菜谱名称不能为空
    204602  查询不到相关信息
    204603  菜谱名过长
    204604  错误的标签ID
    204605  查询不到数据
    204606  错误的菜谱ID
    10001   错误的请求KEY    101
    10002   该KEY无请求权限   102
    10003   KEY过期   103
    10004   错误的OPENID   104
    10005   应用未审核超时，请提交认证   105
    10007   未知的请求源  107
    10008   被禁止的IP  108
    10009   被禁止的KEY 109
    10011   当前IP请求超过限制  111
    10012   请求超过次数限制    112
    10013   测试KEY超过请求限制 113
    10014   系统内部异常(调用充值类业务时，请务必联系客服或通过订单查询接口检测订单，避免造成损失)    114
    10020   接口维护    120
    10021   接口停用    121
 * @author zyq
 * @date 2019-04-24
 */
public class JuHeCaiPu {

    public static final String APP_KEY = "57d4a473c0665a550a83b712966d7bfe";

    public static void getCaiList(){
        String url = "http://apis.juhe.cn/cook/query.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("menu", "红烧肉");
        params.put("key", APP_KEY);
        params.put("dtype", "json");
        params.put("pn", "");
        params.put("rn", "");
        String resp = HttpClientTool.post(url, params);
        System.out.println(resp);
    }

    public static void main(String[] args) {
        getCaiList();
    }
}
