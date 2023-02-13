package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "lvyouxianlu")
public class Lvyouxianlu implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "xianlubianhao")
    private String xianlubianhao;
    @Column(name = "xianlumingcheng")
    private String xianlumingcheng;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "chufadi")
    private String chufadi;
    @Column(name = "tujingdi")
    private String tujingdi;
    @Column(name = "zhongdian")
    private String zhongdian;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "liulanliang")
    private Integer liulanliang;
    @Column(name = "xianlutese")
    private String xianlutese;
    @Column(name = "xianlujianjie")
    private String xianlujianjie;
    @Column(name = "addtime")
    private String addtime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getYudingCount()
    {
        return Query.make("yuding").where("lvyouxianluid" , id).count();
    }


    public String getXianlubianhao() {
        return xianlubianhao;
    }
    public void setXianlubianhao(String xianlubianhao) {
        this.xianlubianhao = xianlubianhao == null ? "" : xianlubianhao.trim();
    }

    public String getXianlumingcheng() {
        return xianlumingcheng;
    }
    public void setXianlumingcheng(String xianlumingcheng) {
        this.xianlumingcheng = xianlumingcheng == null ? "" : xianlumingcheng.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public String getChufadi() {
        return chufadi;
    }
    public void setChufadi(String chufadi) {
        this.chufadi = chufadi == null ? "" : chufadi.trim();
    }

    public String getTujingdi() {
        return tujingdi;
    }
    public void setTujingdi(String tujingdi) {
        this.tujingdi = tujingdi == null ? "" : tujingdi.trim();
    }

    public String getZhongdian() {
        return zhongdian;
    }
    public void setZhongdian(String zhongdian) {
        this.zhongdian = zhongdian == null ? "" : zhongdian.trim();
    }

    public Double getJiage() {
        return jiage;
    }
    public void setJiage(Double jiage) {
        this.jiage = jiage == null ? 0.0f : jiage;
    }

    public Integer getLiulanliang() {
        return liulanliang;
    }
    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang == null ? 0 : liulanliang;
    }

    public String getXianlutese() {
        return xianlutese;
    }
    public void setXianlutese(String xianlutese) {
        this.xianlutese = xianlutese == null ? "" : xianlutese.trim();
    }

    public String getXianlujianjie() {
        return xianlujianjie;
    }
    public void setXianlujianjie(String xianlujianjie) {
        this.xianlujianjie = xianlujianjie == null ? "" : xianlujianjie.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

}
