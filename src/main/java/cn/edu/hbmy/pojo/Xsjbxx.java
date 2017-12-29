package cn.edu.hbmy.pojo;

import java.io.Serializable;

public class Xsjbxx implements Serializable{
	private static final long serialVersionUID = 1L;

	private String xsjbxxXh;

    private String xsjbxxXm;

    private String xsjbxxXb;

    private String xsjbxxMm;

    private String xsjbxxZymc;

    private byte[] xsjbxxZp;

    public String getXsjbxxXh() {
        return xsjbxxXh;
    }

    public void setXsjbxxXh(String xsjbxxXh) {
        this.xsjbxxXh = xsjbxxXh == null ? null : xsjbxxXh.trim();
    }

    public String getXsjbxxXm() {
        return xsjbxxXm;
    }

    public void setXsjbxxXm(String xsjbxxXm) {
        this.xsjbxxXm = xsjbxxXm == null ? null : xsjbxxXm.trim();
    }

    public String getXsjbxxXb() {
        return xsjbxxXb;
    }

    public void setXsjbxxXb(String xsjbxxXb) {
        this.xsjbxxXb = xsjbxxXb == null ? null : xsjbxxXb.trim();
    }

    public String getXsjbxxMm() {
        return xsjbxxMm;
    }

    public void setXsjbxxMm(String xsjbxxMm) {
        this.xsjbxxMm = xsjbxxMm == null ? null : xsjbxxMm.trim();
    }

    public String getXsjbxxZymc() {
        return xsjbxxZymc;
    }

    public void setXsjbxxZymc(String xsjbxxZymc) {
        this.xsjbxxZymc = xsjbxxZymc == null ? null : xsjbxxZymc.trim();
    }

    public byte[] getXsjbxxZp() {
        return xsjbxxZp;
    }

    public void setXsjbxxZp(byte[] xsjbxxZp) {
        this.xsjbxxZp = xsjbxxZp;
    }
}