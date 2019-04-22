package com.zyq.tools;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zyq.annotation.Desc;
import com.zyq.vo.FixedVo;

public class AnnotationTool {

    /**
     * 获取打了Desc注解的字典属性列表
     * @param t 类
     * @return 字典属性列表
     */
    public static <T> List<FixedVo> getFixedVoList(Class<T> cls) {
        try {
            Field[] fields = cls.getDeclaredFields();
            List<FixedVo> fixedVoList = new LinkedList<FixedVo>();
            for (Field field : fields) {
                Desc desc = field.getAnnotation(Desc.class);
                if (desc != null) {
                    FixedVo vo = new FixedVo();
                    vo.setKey(field.getInt(cls));
                    vo.setValue(desc.value());
                    vo.setRemark(desc.remark());
                    fixedVoList.add(vo);
                }
            }
            return fixedVoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * 获取某个属性值的Desc注解
     * @param cls 类
     * @param key 属性值
     * @return 注解
     */
    public static <T> Desc getDesc(Class<T> cls, int key) {
         Field[] fields = cls.getDeclaredFields();
         for (Field field : fields) {
             int i = 0;
             try {
                 i = field.getInt(cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == key) {
                return field.getAnnotation(Desc.class);
            }
        }
        return null;
    }

    /**
     * 获取某个属性值的Desc注解的Value值
     * @param cls 类
     * @param key 属性值
     * @return 注解
     */
    public static <T> String getValue(Class<T> cls, int key) {
        Desc desc = AnnotationTool.getDesc(cls, key);
        if (desc != null) {
            return desc.value();
        }
        return null;
    }
}
