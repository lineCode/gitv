package com.gala.tvapi.vrs.p032b;

import com.gala.tvapi.C0212a;
import com.gala.tvapi.p008b.C0213b;
import com.gala.tvapi.p008b.C0214a;
import com.gala.tvapi.p008b.C0218c;
import com.gala.tvapi.tools.TVApiTool;
import com.gala.tvapi.tv2.TVApiBase;
import java.util.List;

public final class C0359d extends C0212a {
    private String f1223a = null;

    public C0359d(String str) {
        this.f1223a = str;
    }

    public final String build(String... params) {
        String str = this.f1223a;
        if (params == null || params.length < 6) {
            return TVApiTool.parseLicenceUrl(str);
        }
        String str2;
        C0213b a = C0218c.m605a(TVApiBase.getTVApiProperty().getPlatform());
        String str3 = "2391461978";
        String str4 = "04022001010000000000";
        if (a != null) {
            str = a.mo832d();
            str3 = a.mo830b();
            str4 = a.mo831c();
            str2 = str;
            str = str3;
            str3 = str4;
        } else {
            str2 = str;
            str = str3;
            str3 = str4;
        }
        String[] strArr = new String[(params.length + 4)];
        strArr[0] = C0212a.m572a(params[0]);
        strArr[1] = C0212a.m572a(params[1]);
        long currentTimeMillis = System.currentTimeMillis();
        strArr[2] = C0212a.m572a(String.valueOf(currentTimeMillis));
        strArr[3] = C0212a.m572a(String.valueOf(((((int) (currentTimeMillis % 1000)) * ((int) (((double) currentTimeMillis) / Math.pow(10.0d, (double) (String.valueOf(currentTimeMillis).length() - 2))))) + 100) + Integer.valueOf(params[2]).intValue()));
        strArr[4] = C0212a.m572a(params[3]);
        str = strArr[0] + "_afbe8fd3d73448c9_" + strArr[1] + "_" + strArr[2] + "_" + strArr[3] + "_" + str;
        strArr[5] = str3;
        strArr[6] = C0212a.m572a(C0214a.m580a(str));
        strArr[7] = C0212a.m572a(params[4]);
        strArr[8] = C0212a.m572a(params[5].equals("") ? TVApiBase.getTVApiProperty().getPassportDeviceId() : params[5]);
        return String.format(TVApiTool.parseLicenceUrl(str2), (Object[]) strArr);
    }

    public final List<String> header() {
        return null;
    }
}
