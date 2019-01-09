package com.test.aroute;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Route(path = "/test/404")
public class Activity404 extends AppCompatActivity {
    @BindView(R.id.text)
    AppCompatTextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        ButterKnife.bind(this);
        text.setText("404\n"+getIntent().getData());
    }
}
