package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "liuyanban")
public class Liuyanban implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "xingming")
    private String xingming;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;
    @Column(name = "liuyanneirong")
    private String liuyanneirong;
    @Column(name = "liuyanren")
    private String liuyanren;
    @Column(name = "huifuneirong")
    private String huifuneirong;
    @Column(name = "addtime")
    private String addtime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getLiuyanneirong() {
        return liuyanneirong;
    }
    public void setLiuyanneirong(String liuyanneirong) {
        this.liuyanneirong = liuyanneirong == null ? "" : liuyanneirong.trim();
    }

    public String getLiuyanren() {
        return liuyanren;
    }
    public void setLiuyanren(String liuyanren) {
        this.liuyanren = liuyanren == null ? "" : liuyanren.trim();
    }

    public String getHuifuneirong() {
        return huifuneirong;
    }
    public void setHuifuneirong(String huifuneirong) {
        this.huifuneirong = huifuneirong == null ? "" : huifuneirong.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

}
