package com.gala.video.albumlist.utils;

import android.content.Context;
import com.gala.video.app.player.ui.widget.ThreeDimensionalParams;

public class C0384a {
    public static int m873a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + ThreeDimensionalParams.TEXT_SCALE_FOR_3D);
    }
}
