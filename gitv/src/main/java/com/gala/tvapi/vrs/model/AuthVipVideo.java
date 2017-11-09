package com.gala.tvapi.vrs.model;

public class AuthVipVideo extends Model {
    private static final long serialVersionUID = 1;
    public String chl_u = null;
    public String cid = null;
    public String cu = null;
    public String prv = null;
    public String pt = null;
    public String t = null;
    public String u = null;
    public String u_type = null;
    public String v = null;
    public String v_level = null;
    public String v_type = null;

    public boolean canPreview() {
        if (this.prv == null || !this.prv.equals("1")) {
            return false;
        }
        return true;
    }
}
