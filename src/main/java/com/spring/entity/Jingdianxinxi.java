package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "jingdianxinxi")
public class Jingdianxinxi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jingdianbianhao")
    private String jingdianbianhao;
    @Column(name = "jingdianmingcheng")
    private String jingdianmingcheng;
    @Column(name = "suoshudiqu")
    private String suoshudiqu;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "kaifangshijian")
    private String kaifangshijian;
    @Column(name = "fujinmeishi")
    private String fujinmeishi;
    @Column(name = "dizhi")
    private String dizhi;
    @Column(name = "piaojia")
    private Double piaojia;
    @Column(name = "liulanliang")
    private Integer liulanliang;
    @Column(name = "miaoshu")
    private String miaoshu;
    @Column(name = "addtime")
    private String addtime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getJingdianbianhao() {
        return jingdianbianhao;
    }
    public void setJingdianbianhao(String jingdianbianhao) {
        this.jingdianbianhao = jingdianbianhao == null ? "" : jingdianbianhao.trim();
    }

    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }
    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng == null ? "" : jingdianmingcheng.trim();
    }

    public String getSuoshudiqu() {
        return suoshudiqu;
    }
    public void setSuoshudiqu(String suoshudiqu) {
        this.suoshudiqu = suoshudiqu == null ? "" : suoshudiqu.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public String getKaifangshijian() {
        return kaifangshijian;
    }
    public void setKaifangshijian(String kaifangshijian) {
        this.kaifangshijian = kaifangshijian == null ? "" : kaifangshijian.trim();
    }

    public String getFujinmeishi() {
        return fujinmeishi;
    }
    public void setFujinmeishi(String fujinmeishi) {
        this.fujinmeishi = fujinmeishi == null ? "" : fujinmeishi.trim();
    }

    public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? "" : dizhi.trim();
    }

    public Double getPiaojia() {
        return piaojia;
    }
    public void setPiaojia(Double piaojia) {
        this.piaojia = piaojia == null ? 0.0f : piaojia;
    }

    public Integer getLiulanliang() {
        return liulanliang;
    }
    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang == null ? 0 : liulanliang;
    }

    public String getMiaoshu() {
        return miaoshu;
    }
    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu == null ? "" : miaoshu.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

}
