package com.zyq.tools.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zyq.annotation.Desc;
import com.zyq.consts.UserStatus;
import com.zyq.tools.AnnotationTool;
import com.zyq.vo.FixedVo;

/**
 * 注解工具类测试代码
 * @author zyq
 * @date 2019-04-22
 */
public class AnnotationToolTest {

    @Test
    public void getFixedVoListTest(){
        List<FixedVo> voList = AnnotationTool.getFixedVoList(UserStatus.class);
        for (FixedVo vo : voList) {
            System.out.println(vo.toString());
        }
    }

    @Test
    public void getDescTest(){
        Desc desc = AnnotationTool.getDesc(UserStatus.class, UserStatus.ABNORMAL);
        Assert.assertTrue(desc != null);
        System.out.println(desc.value());
        System.out.println(desc.remark());
    }

    @Test
    public void getValueTest(){
        String s = AnnotationTool.getValue(UserStatus.class, UserStatus.NORMAL);
        Assert.assertTrue(s.equals("正常"));
    }
}
