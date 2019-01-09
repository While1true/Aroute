package com.test.aroute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.widget.Scrolling.MixScroll.ElasticProcess;
import com.widget.Scrolling.MixScroll.MixScrolling;

import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MixScrolling mixScrolling = findViewById(R.id.mixScroll);
        mixScrolling.setScrollProcess(new ElasticProcess());
    }

    @OnClick({R.id.jump, R.id.jump2,R.id.jump3,R.id.jump4,R.id.jump5,R.id.jump6,R.id.jump7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jump:
                ARouter.getInstance().build("/test/testactivity").navigation();
                break;
            case R.id.jump2:
                ARouter.getInstance().build("/test/testactivity2").withString("params","Hello World").navigation();
                break;
            case R.id.jump3:
                ARouter.getInstance().build("/test/testactivity3").withObject("params",new TestBean("我是自定义实体类")).navigation();
                break;
            case R.id.jump4:
                ARouter.getInstance().build("/test/testactivity4").navigation();
                break;
            case R.id.jump5:
                ARouter.getInstance().build("/test/testactivity1000").navigation();
                break;
            case R.id.jump6:
                JumpMainActivity jumpMainActivity= (JumpMainActivity) ARouter.getInstance().build("/service/main").navigation();
                jumpMainActivity.jump("/test/testactivity5");
                System.out.println(jumpMainActivity.hashCode());
                break;
            case R.id.jump7:
                ARouter.getInstance().build("/100000").navigation();
                break;
        }
    }
}
