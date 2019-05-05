package com.zyq.beans;

/**
 * HttpSession 中存入的键
 *  为了方便取值时候的接收，命名规则说明：
 * （1）存入的值如果为String，则键不加后缀；
 * （2）如果存入的值为对象，则键加_OBJECT;
 * （3）如果为基本数据类型，则加对应包装类的后缀，如 XXX_INT, YYY_LONG, ZZZ_DOUBLE
 * @author 张远强
 * @date 2019-05-02
 */
public class SessionKey {

    /**
     * user对象
     */
    public static final String USER_OBJECT = "user_object";

}
