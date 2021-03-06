package com.gala.video.app.epg.ui.netdiagnose.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.gala.video.app.epg.R;

public class NetDiagnoseOvalView extends View {
    private static final int CHANGE_SIGNAL = 100;
    private float bigRadio;
    private int interval;
    private Runnable mAnotationRunnable = new Runnable() {
        public void run() {
            NetDiagnoseOvalView.this.selectedIndex = NetDiagnoseOvalView.this.selectedIndex + 1;
            NetDiagnoseOvalView.this.selectedIndex = NetDiagnoseOvalView.this.selectedIndex % NetDiagnoseOvalView.this.ovalSize;
            NetDiagnoseOvalView.this.invalidate();
            NetDiagnoseOvalView.this.mHandler.postDelayed(NetDiagnoseOvalView.this.mAnotationRunnable, 100);
        }
    };
    private Context mContext;
    private Handler mHandler;
    private int ovalSize = 8;
    private float radio;
    private int selectedIndex = 0;
    private float x;
    private float y;

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public NetDiagnoseOvalView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.mContext = context;
        this.radio = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.dimen_3dp);
        this.bigRadio = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.dimen_5dp);
        this.interval = this.mContext.getResources().getDimensionPixelSize(R.dimen.dimen_9dp);
    }

    public NetDiagnoseOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NetDiagnoseOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        float tempx = this.x + this.bigRadio;
        for (int i = 0; i < this.ovalSize; i++) {
            if (this.selectedIndex == i) {
                canvas.drawCircle(tempx, this.y + this.bigRadio, this.bigRadio, paint);
                tempx = (this.bigRadio + tempx) + ((float) this.interval);
            } else {
                canvas.drawCircle(tempx, this.y + this.bigRadio, this.radio, paint);
                tempx = (this.radio + tempx) + ((float) this.interval);
            }
        }
    }

    public void startAnotation() {
        this.mHandler.postDelayed(this.mAnotationRunnable, 100);
    }

    public void stopAnotation() {
        this.mHandler.removeCallbacks(this.mAnotationRunnable);
    }
}
