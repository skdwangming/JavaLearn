package fastjson;

import java.util.Date;

/**
 * 旅店住宿，接口文档未给出具体参数，待实现
 */
public class LkzsBean implements Comparable<LkzsBean> {
    private String bz;//					备注
    private Date csrq;//				出生日期
    private String cyzjdm;//				常用证件代码
    //private String	czbs;//				操作标识
    //private String	czdw_gajgjgdm;//		操作单位_公安机关机构代码
    private String czdw_gajgmc;//			操作单位_公安机关名称
    //private String	czr_gmsfhm;//			操作人_公民身份号码
    //private String	czr_lxdh;//			操作人_联系电话
    //private String	czr_xm;//				操作人_姓名
    //private String	czsj;//				操作时间
    //private String	djdw_gajgjgdm;//		登记单位_公安机关机构代码
    //private String	djdw_gajgmc;//			登记单位_公安机关名称
    //private String	djr_gmsfhm;//			登记人_公民身份号码
    //private String	djr_lxdh;//			登记人_联系电话
    //private String	djr_xm;//				登记人_姓名
    //private String	djsj;//				登记时间
    //private String	gjhdqdm;//				国家和地区代码
    //private String	gl_xxzjbh;//			关联主键编号
    private String gmsfhm;//				公民身份号码
    private String hjd_dzmc;//			户籍地_地址名称
    private String hjd_xzqhdm;//			户籍地区划
    private String ld_mc;//				旅店名称
    private String ld_xz;//				旅店详址
    private String ld_xzqh;//				旅店行政区划
    private String lgbm;//				旅馆编码
    private String mzdm;//				民族代码
    private String rzfh;//				入住房号
    private Date rzsj;//				入住时间
    private Date sc_xxrksj;//			首次_信息入库时间
    //private Date	tfsj;//				退房时间
    private String xbdm;//				性别代码
    private String xm;//					姓名
    //private String	xmhypy;//				姓名汉语拼音
    //private String	xxly_xzqhdm;//			信息来源_行政区划代码
    private Date xxrksj;//				信息入库时间
    private String xxzjbh;//				信息主键编号
    private String zjhm;//				证件号码

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getCyzjdm() {
        return cyzjdm;
    }

    public void setCyzjdm(String cyzjdm) {
        this.cyzjdm = cyzjdm;
    }

    public String getCzdw_gajgmc() {
        return czdw_gajgmc;
    }

    public void setCzdw_gajgmc(String czdwGajgmc) {
        czdw_gajgmc = czdwGajgmc;
    }

    public String getGmsfhm() {
        return gmsfhm;
    }

    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
    }

    public String getHjd_dzmc() {
        return hjd_dzmc;
    }

    public void setHjd_dzmc(String hjdDzmc) {
        hjd_dzmc = hjdDzmc;
    }

    public String getHjd_xzqhdm() {
        return hjd_xzqhdm;
    }

    public void setHjd_xzqhdm(String hjdXzqhdm) {
        hjd_xzqhdm = hjdXzqhdm;
    }

    public String getLd_mc() {
        return ld_mc;
    }

    public void setLd_mc(String ldMc) {
        ld_mc = ldMc;
    }

    public String getLd_xz() {
        return ld_xz;
    }

    public void setLd_xz(String ldXz) {
        ld_xz = ldXz;
    }

    public String getLd_xzqh() {
        return ld_xzqh;
    }

    public void setLd_xzqh(String ldXzqh) {
        ld_xzqh = ldXzqh;
    }

    public String getLgbm() {
        return lgbm;
    }

    public void setLgbm(String lgbm) {
        this.lgbm = lgbm;
    }

    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm;
    }

    public String getRzfh() {
        return rzfh;
    }

    public void setRzfh(String rzfh) {
        this.rzfh = rzfh;
    }

    public Date getRzsj() {
        return rzsj;
    }

    public void setRzsj(Date rzsj) {
        this.rzsj = rzsj;
    }

    public Date getSc_xxrksj() {
        return sc_xxrksj;
    }

    public void setSc_xxrksj(Date scXxrksj) {
        sc_xxrksj = scXxrksj;
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Date getXxrksj() {
        return xxrksj;
    }

    public void setXxrksj(Date xxrksj) {
        this.xxrksj = xxrksj;
    }

    public String getXxzjbh() {
        return xxzjbh;
    }

    public void setXxzjbh(String xxzjbh) {
        this.xxzjbh = xxzjbh;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    @Override
    public int compareTo(LkzsBean o) {
        if (this.getRzsj().getTime() > o.getRzsj().getTime()) {
            return -1;
        }
        if (this.getRzsj().getTime() == o.getRzsj().getTime()) {
            return 0;
        }
        return 1;
    }
}
