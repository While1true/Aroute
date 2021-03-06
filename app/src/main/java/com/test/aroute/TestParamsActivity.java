package com.test.aroute;

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
@Route(path = "/test/testactivity2")
public class TestParamsActivity extends AppCompatActivity {
    @BindView(R.id.text)
    AppCompatTextView text;
    @Autowired
    String params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        text.setText("来自传递的参数："+params);
    }
}
