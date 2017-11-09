package com.xcrash.crashreporter.bean;

import com.xcrash.crashreporter.anno.MessageAnnotation;
import com.xcrash.crashreporter.utils.DeliverConst;

@MessageAnnotation(isEncode = true, name = "dragon_qos", requestUrl = "http://msg.71.am/qos")
public class RnJsErrorStatistics {
    public final String crashtp = "3";
    public String crplg;
    public String crplgv;
    public String crpo;
    public String crshid;
    private String inited;
    public String othdt;
    public String pchv;
    public String po;
    public final String f2130t = "61109";
    public final String tt = "1";

    public RnJsErrorStatistics(String crshid, String po, String crpo, String crplg, String othdt, String crplgv, String pchv) {
        this.crshid = crshid;
        this.po = po;
        this.crpo = crpo;
        this.crplg = crplg;
        this.othdt = othdt;
        this.crplgv = crplgv;
        this.pchv = pchv;
        if ("0".equals(crpo)) {
            this.inited = DeliverConst.inited;
        } else {
            this.inited = "1";
        }
    }
}
