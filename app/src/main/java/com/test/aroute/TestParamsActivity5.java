package com.test.aroute;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Route(path = "/test/testactivity6")
public class TestParamsActivity5 extends AppCompatActivity {
    @BindView(R.id.text)
    AppCompatTextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        ButterKnife.bind(this);
        text.setText("来自重写路径跳转");
    }
}
