package com.gala.video.app.epg.ui.imsg.mvpl.wrapper;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.gala.video.app.epg.R;
import com.gala.video.lib.share.utils.ResourceUtil;

public class ErrorViewWrapper {
    private View mErrorLayout;
    private View mRootView;

    public ErrorViewWrapper(View rootView) {
        this.mRootView = rootView;
        initViews();
    }

    private void initViews() {
        this.mErrorLayout = ((ViewStub) this.mRootView.findViewById(R.id.epg_msg_error_layout_viewstub_id)).inflate().findViewById(R.id.epg_concern_wechat_error_layout);
        TextView textView = (TextView) this.mErrorLayout.findViewById(R.id.epg_concern_wechat_error_tv);
        textView.setText(ResourceUtil.getStr(R.string.msg_error_text));
        textView.setTextColor(ResourceUtil.getColor(R.color.albumview_yellow_color));
        ((ImageView) this.mErrorLayout.findViewById(R.id.epg_concern_wechat_error_iv)).setImageDrawable(ResourceUtil.getDrawable(R.drawable.epg_no_album_text_warn));
    }

    public void setVisibility(int visible) {
        this.mErrorLayout.setVisibility(visible);
    }
}
