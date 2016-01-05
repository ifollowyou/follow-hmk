package org.ifollowyou.util.excel.read;


public class Player {
    // 序号
    private String xh;
    // 参赛号码
    private String cshm;
    // 芯片号码
    private String xphm;
    // 报名项目
    private String bmxm;
    // 团体名称
    private String ttmc;
    // 缴费状态
    private String jfzt;
    // 姓名
    private String xm;
    // 手机号
    private String sjh;
    // 性别
    private String xb;
    // 证件类型
    private String zjlx;
    // 证件号码
    private String zjhm;
    // 紧急联系人
    private String jjlx;
    // 紧急联系电话
    private String jjlxhm;
    // 报名方式
    private String bmfs;
    // 号段
    private String hd;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = String.format("%04d", Integer.parseInt(xh));
    }

    public String getCshm() {
        return cshm;
    }

    public void setCshm(String cshm) {
        this.cshm = cshm;
    }

    public String getXphm() {
        return xphm;
    }

    public void setXphm(String xphm) {
        this.xphm = xphm;
    }

    public String getBmxm() {
        return bmxm;
    }

    public void setBmxm(String bmxm) {
        this.bmxm = bmxm;
    }

    public String getTtmc() {
        return ttmc;
    }

    public void setTtmc(String ttmc) {
        this.ttmc = ttmc;
    }

    public String getJfzt() {
        return jfzt;
    }

    public void setJfzt(String jfzt) {
        this.jfzt = jfzt;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getJjlxhm() {
        return jjlxhm;
    }

    public void setJjlxhm(String jjlxhm) {
        this.jjlxhm = jjlxhm;
    }

    public String getBmfs() {
        return bmfs;
    }

    public void setBmfs(String bmfs) {
        this.bmfs = bmfs;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Player{" +
                "xh='" + xh + '\'' +
                ", cshm='" + cshm + '\'' +
                ", xphm='" + xphm + '\'' +
                ", bmxm='" + bmxm + '\'' +
                ", ttmc='" + ttmc + '\'' +
                ", jfzt='" + jfzt + '\'' +
                ", xm='" + xm + '\'' +
                ", sjh='" + sjh + '\'' +
                ", xb='" + xb + '\'' +
                ", zjlx='" + zjlx + '\'' +
                ", zjhm='" + zjhm + '\'' +
                ", jjlx='" + jjlx + '\'' +
                ", jjlxhm='" + jjlxhm + '\'' +
                ", bmfs='" + bmfs + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}
