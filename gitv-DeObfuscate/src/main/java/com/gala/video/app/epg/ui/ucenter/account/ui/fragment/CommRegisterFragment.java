package com.gala.video.app.epg.ui.ucenter.account.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.gala.video.app.epg.C0508R;
import com.gala.video.app.epg.ui.albumlist.widget.CursorTextView;
import com.gala.video.app.epg.ui.ucenter.account.presenter.CommRegisterPresenter;
import com.gala.video.app.epg.ui.ucenter.account.ui.IRegisterView;
import com.gala.video.app.epg.widget.GALAKeyboard;
import com.gala.video.app.epg.widget.IKeyboardListener;
import com.gala.video.lib.framework.core.utils.StringUtils;
import com.gala.video.lib.share.common.widget.ProgressBarNewItem;
import com.gala.video.lib.share.ifimpl.ucenter.account.utils.LoginConstant;
import com.gala.video.lib.share.ifmanager.bussnessIF.ucenter.account.bean.UserInfoBean;
import com.gala.video.lib.share.utils.AnimationUtil;

public class CommRegisterFragment extends BaseLoginFragment implements OnClickListener, OnFocusChangeListener, IRegisterView {
    private CursorTextView mAccountCursor;
    private View mAccountErrorView;
    private TextView mAccountTab;
    private View mAccountView;
    private TextView mChangeTab;
    private View mChangeTabView;
    private GALAKeyboard mGALAKeyboard;
    private int mIntentFlag;
    private View mMainView;
    private Button mMessageButton;
    private CursorTextView mMessageCursor;
    private View mMessageErrorView;
    private TextView mMessageTab;
    private View mMessageView;
    private CursorTextView mPasswordCursor;
    private View mPasswordErrorView;
    private TextView mPasswordTab;
    private View mPasswordView;
    private ProgressBarNewItem mProgressBar;
    private Button mRegisterButton;
    private CommRegisterPresenter mRegisterPresenter;
    private CursorTextView mVerifyCursor;
    private View mVerifyErrorView;
    private ImageView mVerifyImage;
    private TextView mVerifyTab;
    private View mVerifyView;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.mLoginEvent != null) {
            this.mRegisterPresenter = new CommRegisterPresenter(this);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mIntentFlag = bundle.getInt(LoginConstant.LOGIN_SUCC_TO, -1);
        }
    }

    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mMainView = inflater.inflate(C0508R.layout.epg_fragment_comm_register, null);
        findViewById();
        initCommUIData();
        initFocusForward();
        registerListener();
        if (this.mRegisterPresenter != null) {
            this.mRegisterPresenter.setPingback_s1(this.mS1);
            this.mRegisterPresenter.initGALAKeyboard();
            this.mRegisterPresenter.initAccountCursor();
            this.mRegisterPresenter.loadVerifyCode();
            this.mRegisterPresenter.sendDisplayPingback("account", "tvsignup", this.mS1);
        }
        return this.mMainView;
    }

    private void registerListener() {
        this.mChangeTabView.setOnFocusChangeListener(this);
        this.mAccountView.setOnFocusChangeListener(this);
        this.mPasswordView.setOnFocusChangeListener(this);
        this.mVerifyView.setOnFocusChangeListener(this);
        this.mMessageView.setOnFocusChangeListener(this);
        this.mVerifyImage.setOnFocusChangeListener(this);
        this.mMessageButton.setOnFocusChangeListener(this);
        this.mRegisterButton.setOnFocusChangeListener(this);
        this.mChangeTabView.setOnClickListener(this);
        this.mAccountView.setOnClickListener(this);
        this.mPasswordView.setOnClickListener(this);
        this.mVerifyView.setOnClickListener(this);
        this.mMessageView.setOnClickListener(this);
        this.mRegisterButton.setOnClickListener(this);
        this.mVerifyImage.setOnClickListener(this);
        this.mMessageButton.setOnClickListener(this);
    }

    private void initFocusForward() {
        this.mAccountView.setNextFocusLeftId(this.mAccountView.getId());
        this.mAccountView.setNextFocusRightId(this.mChangeTabView.getId());
        this.mAccountView.setNextFocusUpId(this.mAccountView.getId());
        this.mAccountView.setNextFocusDownId(this.mPasswordView.getId());
        this.mPasswordView.setNextFocusLeftId(this.mPasswordView.getId());
        this.mPasswordView.setNextFocusRightId(this.mChangeTabView.getId());
        this.mPasswordView.setNextFocusUpId(this.mAccountView.getId());
        this.mPasswordView.setNextFocusDownId(this.mVerifyView.getId());
        this.mVerifyView.setNextFocusLeftId(this.mVerifyView.getId());
        this.mVerifyView.setNextFocusRightId(this.mVerifyImage.getId());
        this.mVerifyView.setNextFocusUpId(this.mPasswordView.getId());
        this.mVerifyView.setNextFocusDownId(this.mMessageView.getId());
        this.mVerifyImage.setNextFocusUpId(this.mPasswordView.getId());
        this.mVerifyImage.setNextFocusLeftId(this.mVerifyView.getId());
        this.mVerifyImage.setNextFocusRightId(this.mChangeTabView.getId());
        this.mVerifyImage.setNextFocusDownId(this.mMessageView.getId());
        this.mMessageView.setNextFocusLeftId(this.mMessageView.getId());
        this.mMessageView.setNextFocusRightId(this.mMessageButton.getId());
        this.mMessageView.setNextFocusUpId(this.mVerifyView.getId());
        this.mMessageView.setNextFocusDownId(this.mRegisterButton.getId());
        this.mMessageButton.setNextFocusUpId(this.mVerifyView.getId());
        this.mMessageButton.setNextFocusLeftId(this.mMessageView.getId());
        this.mMessageButton.setNextFocusRightId(this.mChangeTabView.getId());
        this.mMessageButton.setNextFocusDownId(this.mRegisterButton.getId());
        this.mChangeTabView.setNextFocusDownId(this.mChangeTabView.getId());
        this.mChangeTabView.setNextFocusRightId(this.mChangeTabView.getId());
        this.mChangeTabView.setNextFocusUpId(this.mChangeTabView.getId());
    }

    private void initCommUIData() {
        ((TextView) this.mChangeTabView.findViewById(C0508R.id.epg_text_change_tab)).setText(getStr(C0508R.string.LoginTip));
        this.mAccountTab.setText(getStr(C0508R.string.Account));
        this.mPasswordTab.setText(getStr(C0508R.string.Password));
        this.mVerifyTab.setText(getStr(C0508R.string.Verifycode));
        this.mMessageTab.setText(getStr(C0508R.string.IdentifyingCode));
        this.mAccountCursor.setHint(getStr(C0508R.string.InputAccountHint2));
        this.mPasswordCursor.setHint(getStr(C0508R.string.InputPasswordHint1));
        this.mVerifyCursor.setHint(getStr(C0508R.string.InputVerifycodeHint1));
        this.mMessageCursor.setHint(getStr(C0508R.string.InputMessagecodeHint1));
        this.mAccountCursor.setHintTextColor(getColor(C0508R.color.hot_search));
        this.mPasswordCursor.setHintTextColor(getColor(C0508R.color.hot_search));
        this.mVerifyCursor.setHintTextColor(getColor(C0508R.color.hot_search));
        this.mMessageCursor.setHintTextColor(getColor(C0508R.color.hot_search));
        this.mAccountErrorView.setVisibility(4);
        this.mPasswordErrorView.setVisibility(4);
        this.mVerifyErrorView.setVisibility(4);
        this.mMessageErrorView.setVisibility(4);
        this.mAccountCursor.setTransformationMethod(null);
        this.mVerifyCursor.setTransformationMethod(null);
        this.mMessageCursor.setTransformationMethod(null);
    }

    private void findViewById() {
        this.mChangeTabView = this.mMainView.findViewById(C0508R.id.epg_view_change_tab_regist);
        this.mAccountView = this.mMainView.findViewById(C0508R.id.epg_input_username_regist);
        this.mPasswordView = this.mMainView.findViewById(C0508R.id.epg_input_password_regist);
        this.mVerifyView = this.mMainView.findViewById(C0508R.id.epg_input_verification_code_regist);
        this.mMessageView = this.mMainView.findViewById(C0508R.id.epg_input_message_code);
        this.mAccountErrorView = this.mMainView.findViewById(C0508R.id.epg_error_account_regist);
        this.mPasswordErrorView = this.mMainView.findViewById(C0508R.id.epg_error_password_regist);
        this.mVerifyErrorView = this.mMainView.findViewById(C0508R.id.epg_error_verifycode_regist);
        this.mMessageErrorView = this.mMainView.findViewById(C0508R.id.epg_error_message);
        this.mRegisterButton = (Button) this.mMainView.findViewById(C0508R.id.epg_btn_regist);
        this.mMessageButton = (Button) this.mMainView.findViewById(C0508R.id.epg_btn_message);
        this.mVerifyImage = (ImageView) this.mMainView.findViewById(C0508R.id.epg_image_verify_regist);
        this.mGALAKeyboard = (GALAKeyboard) this.mMainView.findViewById(C0508R.id.epg_keyboard_comm_register);
        this.mAccountTab = (TextView) this.mAccountView.findViewById(C0508R.id.epg_inputbox_tab);
        this.mPasswordTab = (TextView) this.mPasswordView.findViewById(C0508R.id.epg_inputbox_tab);
        this.mVerifyTab = (TextView) this.mVerifyView.findViewById(C0508R.id.epg_inputbox_tab);
        this.mChangeTab = (TextView) this.mChangeTabView.findViewById(C0508R.id.epg_text_change_tab);
        this.mMessageTab = (TextView) this.mMessageView.findViewById(C0508R.id.epg_inputbox_tab);
        this.mAccountCursor = (CursorTextView) this.mAccountView.findViewById(C0508R.id.epg_inputbox_cursor);
        this.mVerifyCursor = (CursorTextView) this.mVerifyView.findViewById(C0508R.id.epg_inputbox_cursor);
        this.mPasswordCursor = (CursorTextView) this.mPasswordView.findViewById(C0508R.id.epg_inputbox_cursor);
        this.mMessageCursor = (CursorTextView) this.mMessageView.findViewById(C0508R.id.epg_inputbox_cursor);
        this.mProgressBar = (ProgressBarNewItem) this.mMainView.findViewById(C0508R.id.epg_verify_pro_regist);
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    public void onClick(View v) {
        if (this.mLoginEvent != null && this.mRegisterPresenter != null) {
            int vId = v.getId();
            if (vId == C0508R.id.epg_view_change_tab_regist) {
                setBack(false);
                getFragmentManager().popBackStack();
            } else if (vId == C0508R.id.epg_input_username_regist) {
                this.mRegisterPresenter.switchInputAccount();
            } else if (vId == C0508R.id.epg_input_password_regist) {
                this.mRegisterPresenter.switchInputPassword();
            } else if (vId == C0508R.id.epg_input_verification_code_regist) {
                this.mRegisterPresenter.switchInputVerifyCode();
            } else if (vId == C0508R.id.epg_input_message_code) {
                this.mRegisterPresenter.switchInputMessageCode();
            } else if (vId == C0508R.id.epg_btn_regist) {
                this.mRegisterPresenter.callRegisterRequest();
            } else if (vId == C0508R.id.epg_image_verify_regist) {
                this.mRegisterPresenter.loadVerifyCode();
            } else if (vId == C0508R.id.epg_btn_message) {
                this.mRegisterPresenter.sendMessage();
            }
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        int vid = v.getId();
        if (vid == C0508R.id.epg_input_username_regist || vid == C0508R.id.epg_input_password_regist || vid == C0508R.id.epg_input_verification_code_regist || vid == C0508R.id.epg_input_message_code || vid == C0508R.id.epg_image_verify_regist || vid == C0508R.id.epg_btn_regist || vid == C0508R.id.epg_btn_message || vid == C0508R.id.epg_view_change_tab_regist) {
            if (vid == C0508R.id.epg_input_username_regist || vid == C0508R.id.epg_input_password_regist || vid == C0508R.id.epg_input_verification_code_regist || vid == C0508R.id.epg_input_message_code) {
                setHintColor(vid, hasFocus ? C0508R.color.gala_write : C0508R.color.hot_search);
            }
            if (v.getId() == C0508R.id.epg_view_change_tab_regist) {
                this.mChangeTab.setTextColor(getColor(hasFocus ? C0508R.color.item_name_focus : C0508R.color.change_tab_color_normal));
            }
            viewBringToFront(v, vid);
            AnimationUtil.zoomAnimation(v, hasFocus, 1.02f, 200);
        }
    }

    private void viewBringToFront(View v, int vid) {
        if (vid == C0508R.id.epg_input_verification_code_regist || vid == C0508R.id.epg_input_message_code || vid == C0508R.id.epg_image_verify_regist) {
            v.bringToFront();
        }
    }

    public void startAccountCursor(long time) {
        this.mAccountCursor.startCursor(time);
    }

    public void startPasswordCursor(long time) {
        this.mPasswordCursor.startCursor(time);
    }

    public void startVerifyCursor(long time) {
        this.mVerifyCursor.startCursor(time);
    }

    public void startMessageCursor(long time) {
        this.mMessageCursor.startCursor(time);
    }

    public void stopAccountCursor() {
        this.mAccountCursor.stopCursor();
    }

    public void stopPasswordCursor() {
        this.mPasswordCursor.stopCursor();
    }

    public void stopVerifyCursor() {
        this.mVerifyCursor.stopCursor();
    }

    public void stopMessageCursor() {
        this.mMessageCursor.stopCursor();
    }

    public void setAccount(String str) {
        this.mAccountCursor.setText(str);
    }

    public void setPassword(String str) {
        this.mPasswordCursor.setText(str);
    }

    public void setVerifyCode(String str) {
        this.mVerifyCursor.setText(str);
    }

    public void setMessageCode(String str) {
        this.mMessageCursor.setText(str);
    }

    public String getAccount() {
        return this.mAccountCursor.getText().toString();
    }

    public String getPassword() {
        return this.mPasswordCursor.getText().toString();
    }

    public String getVerifyCode() {
        return this.mVerifyCursor.getText().toString();
    }

    public String getMessageCode() {
        return this.mMessageCursor.getText().toString();
    }

    public void updateTextBuffer(String text) {
        this.mGALAKeyboard.updateTextBuffer(text);
    }

    public void registerKeyboardListener(IKeyboardListener listener) {
        this.mGALAKeyboard.setKeyListener(listener);
    }

    public void changeConfirmTextAndDrawable(int stringId, int resId) {
        this.mGALAKeyboard.setConfirmTextAndDrawable(stringId, resId);
    }

    public void initKeyboardLayout(int stringId, int resId) {
        this.mGALAKeyboard.initKeyLayout(stringId, resId);
    }

    public void showAccountErrorTipUI(boolean showIcon, String res) {
        int i = 4;
        if (this.mAccountErrorView != null && this.mAccountErrorView.getVisibility() == 4) {
            ImageView tipIcon = (ImageView) this.mAccountErrorView.findViewById(C0508R.id.epg_error_tip_icon);
            TextView tipText = (TextView) this.mAccountErrorView.findViewById(C0508R.id.epg_error_tip_text);
            if (showIcon) {
                i = 0;
            }
            tipIcon.setVisibility(i);
            tipText.setText(res);
            this.mAccountErrorView.setVisibility(0);
        }
    }

    public void showPasswordErrorTipUI(boolean showIcon, String res) {
        int i = 4;
        if (this.mPasswordErrorView != null && this.mPasswordErrorView.getVisibility() == 4) {
            ImageView tipIcon = (ImageView) this.mPasswordErrorView.findViewById(C0508R.id.epg_error_tip_icon);
            TextView tipText = (TextView) this.mPasswordErrorView.findViewById(C0508R.id.epg_error_tip_text);
            if (showIcon) {
                i = 0;
            }
            tipIcon.setVisibility(i);
            tipText.setText(res);
            this.mPasswordErrorView.setVisibility(0);
        }
    }

    public void showVerifycodeErrorTipUI(boolean showIcon, String res) {
        int i = 4;
        if (this.mVerifyErrorView != null && this.mVerifyErrorView.getVisibility() == 4) {
            ImageView tipIcon = (ImageView) this.mVerifyErrorView.findViewById(C0508R.id.epg_error_tip_icon);
            TextView tipText = (TextView) this.mVerifyErrorView.findViewById(C0508R.id.epg_error_tip_text);
            if (showIcon) {
                i = 0;
            }
            tipIcon.setVisibility(i);
            tipText.setText(res);
            this.mVerifyErrorView.setVisibility(0);
        }
    }

    public void showMessagecodeErrorTipUI(boolean showIcon, int resId) {
        int i = 4;
        if (this.mMessageErrorView != null && this.mMessageErrorView.getVisibility() == 4) {
            ImageView tipIcon = (ImageView) this.mMessageErrorView.findViewById(C0508R.id.epg_error_tip_icon);
            TextView tipText = (TextView) this.mMessageErrorView.findViewById(C0508R.id.epg_error_tip_text);
            if (showIcon) {
                i = 0;
            }
            tipIcon.setVisibility(i);
            tipText.setText(getStr(resId));
            this.mMessageErrorView.setVisibility(0);
        }
    }

    public void hideAccountErrorTipUI() {
        if (this.mAccountErrorView != null && this.mAccountErrorView.getVisibility() == 0) {
            this.mAccountErrorView.setVisibility(4);
        }
    }

    public void hidePasswordErrorTipUI() {
        if (this.mPasswordErrorView != null && this.mPasswordErrorView.getVisibility() == 0) {
            this.mPasswordErrorView.setVisibility(4);
        }
    }

    public void hideVerifycodeErrorTipUI() {
        if (this.mVerifyErrorView != null && this.mVerifyErrorView.getVisibility() == 0) {
            this.mVerifyErrorView.setVisibility(4);
        }
    }

    public void hideMessagecodeErrorTipUI() {
        if (this.mMessageErrorView != null && this.mMessageErrorView.getVisibility() == 0) {
            this.mMessageErrorView.setVisibility(4);
        }
    }

    public void switchToMyCenterPage(UserInfoBean bean) {
        gotoMyCenter(bean, this.mIntentFlag);
    }

    public void showProgressBar() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(0);
        }
    }

    public void hideProgressBar() {
        if (this.mProgressBar != null && this.mProgressBar.getVisibility() == 0) {
            this.mProgressBar.setVisibility(4);
        }
    }

    public void setVerifyBitmap(Bitmap bitmap) {
        if (this.mVerifyImage != null) {
            this.mVerifyImage.setImageBitmap(bitmap);
        }
    }

    public void setMessageBtnTxt(String text) {
        if (this.mMessageButton != null) {
            this.mMessageButton.setText(text);
        }
    }

    public void showVerifyCodeUI() {
    }

    public void hideVerifyCodeUI() {
    }

    public boolean isVerifyVisible() {
        return true;
    }

    private void setHintColor(int resId, int colorId) {
        if (resId == C0508R.id.epg_input_username_regist) {
            if (!StringUtils.isEmpty(this.mAccountCursor.getHint().toString())) {
                this.mAccountCursor.setHintTextColor(getColor(colorId));
            }
        } else if (resId == C0508R.id.epg_input_password_regist) {
            if (!StringUtils.isEmpty(this.mPasswordCursor.getHint().toString())) {
                this.mPasswordCursor.setHintTextColor(getColor(colorId));
            }
        } else if (resId == C0508R.id.epg_input_verification_code_regist) {
            if (!StringUtils.isEmpty(this.mVerifyCursor.getHint().toString())) {
                this.mVerifyCursor.setHintTextColor(getColor(colorId));
            }
        } else if (resId == C0508R.id.epg_input_message_code && !StringUtils.isEmpty(this.mMessageCursor.getHint().toString())) {
            this.mMessageCursor.setHintTextColor(getColor(colorId));
        }
    }
}
