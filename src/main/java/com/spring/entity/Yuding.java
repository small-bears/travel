package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "yuding")
public class Yuding implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "lvyouxianluid")
    private Integer lvyouxianluid;
    @Column(name = "xianlubianhao")
    private String xianlubianhao;
    @Column(name = "xianlumingcheng")
    private String xianlumingcheng;
    @Column(name = "chufadi")
    private String chufadi;
    @Column(name = "tujingdi")
    private String tujingdi;
    @Column(name = "zhongdian")
    private String zhongdian;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "dingdanhao")
    private String dingdanhao;
    @Column(name = "yudingshijian")
    private String yudingshijian;
    @Column(name = "yudingrenxingming")
    private String yudingrenxingming;
    @Column(name = "lianxifangshi")
    private String lianxifangshi;
    @Column(name = "zhuangtai")
    private String zhuangtai;
    @Column(name = "beizhu")
    private String beizhu;
    @Column(name = "yudingren")
    private String yudingren;
    @Column(name = "addtime")
    private String addtime;
    private String iszf;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getLvyouxianluid() {
        return lvyouxianluid;
    }
    public void setLvyouxianluid(Integer lvyouxianluid) {
        this.lvyouxianluid = lvyouxianluid == null ? 0 : lvyouxianluid;
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

    public String getDingdanhao() {
        return dingdanhao;
    }
    public void setDingdanhao(String dingdanhao) {
        this.dingdanhao = dingdanhao == null ? "" : dingdanhao.trim();
    }

    public String getYudingshijian() {
        return yudingshijian;
    }
    public void setYudingshijian(String yudingshijian) {
        this.yudingshijian = yudingshijian == null ? "" : yudingshijian.trim();
    }

    public String getYudingrenxingming() {
        return yudingrenxingming;
    }
    public void setYudingrenxingming(String yudingrenxingming) {
        this.yudingrenxingming = yudingrenxingming == null ? "" : yudingrenxingming.trim();
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? "" : zhuangtai.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? "" : beizhu.trim();
    }

    public String getYudingren() {
        return yudingren;
    }
    public void setYudingren(String yudingren) {
        this.yudingren = yudingren == null ? "" : yudingren.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }
    public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? "" : iszf.trim();
    }

}
