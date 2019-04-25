package com.zyq.beans;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zyq.tools.Tool;

/**
 * 聚合菜谱
 * @author zyq
 * @date 2019-04-25
 */
@Entity
@Table(name = "juhe_cai")
public class JuHeCai extends BaseBean {

    String juheId;

    String title;

    String tags;

    Clob imtro;

    Clob ingredients;

    Clob burden;

    /**
     * type：Json
     * eg：["http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/t/1/505_678976.jpg"]
     */
    Clob albums; 

    /**
     * type：Json
     * eg：[{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/6/505_55602b6cec1d0b27.jpg","step":"1.首先用喷枪给肉皮烧黑"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/6/505_61850dfdaaee31c4.jpg","step":"2.然后给肉泡在冷水里一会儿，再拿出来用刀给黑的东西刮掉清洗干净"}]
     */
    Clob steps;

    public String getJuheId() {
        return juheId;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }

    public String getImtro() {
        return Tool.getString(imtro);
    }

    public String getIngredients() {
        return Tool.getString(ingredients);
    }

    public String getBurden() {
        return Tool.getString(burden);
    }

    public String getAlbums() {
        return Tool.getString(albums);
    }

    public String getSteps() {
        return Tool.getString(steps);
    }

    public void setJuheId(String juheId) {
        this.juheId = juheId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setImtro(String imtro) {
        this.imtro = Tool.getClob(imtro);
    }

    public void setIngredients(String ingredients) {
        this.ingredients = Tool.getClob(ingredients);
    }

    public void setBurden(String burden) {
        this.burden = Tool.getClob(burden);
    }

    public void setAlbums(String albums) {
        this.albums = Tool.getClob(albums);
    }

    public void setSteps(String steps) {
        this.steps = Tool.getClob(steps);
    }

}
