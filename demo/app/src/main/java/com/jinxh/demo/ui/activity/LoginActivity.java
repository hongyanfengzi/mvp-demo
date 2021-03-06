package com.jinxh.demo.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.jinxh.demo.R;
import com.jinxh.demo.base.MvpActivity;
import com.jinxh.demo.present.LoginPresent;
import com.jinxh.demo.model.PreferenceUtils;

import butterknife.Bind;

/**
 * Created by jinxh on 16/2/1.
 */
public class LoginActivity extends MvpActivity<LoginPresent> implements View.OnClickListener {
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.et_mobile)
    EditText mEtMobile;
    @Bind(R.id.et_password)
    EditText mEtPassword;
    @Bind(R.id.tv_register)
    View mTvRegister;

    @Override
    protected LoginPresent createPresenter() {
        return new LoginPresent();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        setOnClickListener(mBtnLogin, this);
        setOnClickListener(mTvRegister, this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        mEtMobile.setText(PreferenceUtils.getInstance(this).getStringParam(PreferenceUtils.LOGIN_NAME));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.login(mEtMobile.getText().toString(), mEtPassword.getText().toString());
                break;
            case R.id.tv_register:
                break;
        }
    }

    public void loginSuccess() {
        // TODO
        showMessage("登陆成功");
    }
}
