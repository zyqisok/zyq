package com.zyq.consts;

import com.zyq.annotation.Desc;
import com.zyq.beans.Node;

/**
 * 节点类型 
 * @see {@link Node}
 * @author ZhangYuanqiang
 * @date 2019-04-28
 */
public class NodeType {

    @Desc(value = "文件夹")
    public static int FOLDER = 1;

    @Desc(value = "文件")
    public static int FILE = 2;

}
