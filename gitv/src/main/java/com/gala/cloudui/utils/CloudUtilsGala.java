package com.gala.cloudui.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import com.gala.sdk.player.constants.PlayerIntentConfig;
import com.gala.video.lib.share.common.configs.WebConstants;
import java.util.HashMap;

public class CloudUtilsGala {
    private static Context a;
    private static Typeface f270a;
    private static String f271a = PlayerIntentConfig.URI_AUTH;
    private static final HashMap<String, Integer> f272a = new HashMap(24);
    private static final HashMap<String, Drawable> b = new HashMap(60);
    private static final HashMap<String, ColorDrawable> c = new HashMap(12);
    private static final HashMap<String, ColorStateList> d = new HashMap(6);

    public static Drawable getDrawable(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        if (json.startsWith("#")) {
            return getColorDrawableFromResidStr(json);
        }
        if (json.startsWith(WebConstants.WEB_SITE_BASE_HTTP)) {
            return null;
        }
        return getDrawableFromResidStr(json);
    }

    public static int getColor(String json) {
        if (!TextUtils.isEmpty(json) && json.startsWith("#")) {
            return getColorFromResidStr(json);
        }
        return 0;
    }

    public static Drawable getCurStateDrawable(Drawable drawable, int[] currentState) {
        if (drawable == null) {
            return null;
        }
        Drawable stateDrawable;
        try {
            stateDrawable = getStateDrawable(drawable, StateListDrawable.class.getMethod("getStateDrawableIndex", new Class[]{int[].class}).invoke((StateListDrawable) drawable, new Object[]{currentState}));
        } catch (Exception e) {
            stateDrawable = null;
        }
        return stateDrawable;
    }

    public static Drawable getStateDrawable(Drawable drawable, Object index) {
        if (drawable == null) {
            return null;
        }
        try {
            return (Drawable) StateListDrawable.class.getMethod("getStateDrawable", new Class[]{Integer.TYPE}).invoke((StateListDrawable) drawable, new Object[]{index});
        } catch (Exception e) {
            return null;
        }
    }

    public static Rect calcNinePatchBorders(Drawable d, Rect r) {
        if (d == null) {
            r.set(0, 0, 0, 0);
        } else {
            d.getPadding(r);
        }
        return r;
    }

    public static ColorStateList getColorStateListFromResidStr(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        ColorStateList colorStateList = (ColorStateList) d.get(jsonStr);
        if (colorStateList != null) {
            return colorStateList;
        }
        Resources resource = getResource();
        try {
            colorStateList = resource.getColorStateList(resource.getIdentifier(jsonStr, "color", f271a));
            try {
                d.put(jsonStr, colorStateList);
                return colorStateList;
            } catch (Exception e) {
                Log.e("CloudUtilsGala", "getColorStateListFromResidStr error ,jsonStr=" + jsonStr);
                return colorStateList;
            }
        } catch (Exception e2) {
            colorStateList = null;
            Log.e("CloudUtilsGala", "getColorStateListFromResidStr error ,jsonStr=" + jsonStr);
            return colorStateList;
        }
    }

    public static Drawable getDrawableFromResidStr(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        Drawable drawable = (Drawable) b.get(jsonStr);
        if (drawable != null) {
            return drawable;
        }
        Resources resource = getResource();
        try {
            drawable = resource.getDrawable(resource.getIdentifier(jsonStr, "drawable", f271a));
            try {
                b.put(jsonStr, drawable);
                return drawable;
            } catch (Exception e) {
                Log.e("CloudUtilsGala", "getDrawableFromResidStr error ,jsonStr=" + jsonStr);
                return drawable;
            }
        } catch (Exception e2) {
            drawable = null;
            Log.e("CloudUtilsGala", "getDrawableFromResidStr error ,jsonStr=" + jsonStr);
            return drawable;
        }
    }

    public static int getColorFromResidStr(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return 0;
        }
        Integer num = (Integer) f272a.get(jsonStr);
        if (num != null) {
            return num.intValue();
        }
        int parseColor = Color.parseColor(jsonStr);
        f272a.put(jsonStr, Integer.valueOf(parseColor));
        return parseColor;
    }

    public static Drawable getColorDrawableFromResidStr(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        Drawable drawable = (Drawable) c.get(jsonStr);
        if (drawable != null) {
            return drawable;
        }
        drawable = new ColorDrawable(getColorFromResidStr(jsonStr));
        c.put(jsonStr, drawable);
        return drawable;
    }

    public static boolean isArrayEmpty(Object[] t) {
        return t == null || t.length == 0;
    }

    public static int getArraySize(Object[] t) {
        if (t == null) {
            return 0;
        }
        return t.length;
    }

    public static final TruncateAt getTruncateAt(int truncateAt) {
        if (truncateAt == 0) {
            return TruncateAt.END;
        }
        if (truncateAt == 3) {
            return TruncateAt.START;
        }
        if (truncateAt == 2) {
            return TruncateAt.MIDDLE;
        }
        return TruncateAt.MARQUEE;
    }

    public static Context getAppContext() {
        return a;
    }

    public static Resources getResource() {
        return getAppContext().getResources();
    }

    public static String getPackageName() {
        return f271a;
    }

    public static void setPackageName(String packageName) {
        f271a = packageName;
    }

    public static Context getContext() {
        return a;
    }

    public static void setPackageContext(Context packageContext) {
        a = packageContext;
    }

    public static Typeface getTypeface() {
        return f270a;
    }

    public static void setTypeface(Typeface typeface) {
        f270a = typeface;
    }

    public static void clearMapCache() {
        d.clear();
        b.clear();
        c.clear();
        f272a.clear();
    }
}
