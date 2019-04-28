package com.zyq.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zyq.beans.JuHeCai;
import com.zyq.tools.HttpClientTool;
import com.zyq.tools.Tool;
import com.zyq.vo.RespJuHeCai;

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
public class JuHeCaiPuApi {

    public static final Logger logger = LoggerFactory.getLogger(JuHeCaiPuApi.class);

    // public static final String APP_KEY = "57d4a473c0665a550a83b712966d7bfe"; // 我（已使用完）
    // public static final String APP_KEY = "44fe067a9f93c85a55b0d0afda2e3f4f"; // 婵（15229346987）
    public static final String APP_KEY = "97a0571c18f2803bb6e675f357c7c38a"; // 吻刀（18631185797）

    /**
     * 搜索菜谱列表
     * @param cai 菜名（不能为空）
     * @param index 列表起始下标
     * @param size 列表个数（最大30）
     */
    public static RespJuHeCai getCaiList(String cai, int index, int size) {
        if (Tool.isEmpty(cai)) return new RespJuHeCai();
        if (index < 0) index = 0;
        if (size > 30) size = 30;
        String url = "http://apis.juhe.cn/cook/query.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("menu", cai);
        params.put("key", APP_KEY);
        params.put("dtype", "json");
        params.put("pn", String.valueOf(index));
        params.put("rn", String.valueOf(size));
        String resp = HttpClientTool.post(url, params);
        if (Tool.isEmpty(resp)) return new RespJuHeCai();
        JSONObject respObj = JSONObject.fromObject(resp);
        int errorCode = respObj.getInt("error_code");
        if (errorCode != 0) {
            logger.error("[JuHeCaiPu.getCaiList] error_code : " + errorCode);
            return new RespJuHeCai();
        }
        JSONObject result = respObj.getJSONObject("result");
        JSONArray data = result.getJSONArray("data");
        List<JuHeCai> caiList = new ArrayList<JuHeCai>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject obj = data.getJSONObject(i);
            try {
                JuHeCai juHeCai = new JuHeCai();
                juHeCai.setJuheId(obj.getString("id"));
                juHeCai.setTitle(obj.getString("title"));
                juHeCai.setTags(obj.getString("tags"));
                juHeCai.setImtro(obj.getString("imtro"));
                juHeCai.setIngredients(obj.getString("imtro"));
                juHeCai.setBurden(obj.getString("burden"));
                juHeCai.setAlbums(obj.getJSONArray("albums").toString());
                juHeCai.setSteps(obj.getJSONArray("steps").toString());
                caiList.add(juHeCai);
            } catch (Exception e) {
                logger.equals("解析菜谱出错：" + obj.toString());
            }
        }
        RespJuHeCai respJuHeCai = new RespJuHeCai();
        respJuHeCai.setData(caiList);
        respJuHeCai.setPn(Tool.getInt(result.get("pn")));
        respJuHeCai.setRn(Tool.getInt(result.get("rn")));
        respJuHeCai.setTotalNum(Tool.getInt(result.get("totalNum")));
        return respJuHeCai;
    }

    public static void main(String[] args) {
        RespJuHeCai respJuHeCai = getCaiList("红烧肉", 0, 0);
        System.out.println(respJuHeCai.toString());
    }
}
