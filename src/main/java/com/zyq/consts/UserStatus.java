package com.zyq.consts;

import com.zyq.annotation.Desc;

/**
 * 用户状态
 * @author zyq
 * @date 2019-04-22
 */
public class UserStatus {

    @Desc(value = "正常")
    public static int NORMAL = 1;

    @Desc(value = "非正常", remark="该状态用户不能登录")
    public static int ABNORMAL = 2;

}
