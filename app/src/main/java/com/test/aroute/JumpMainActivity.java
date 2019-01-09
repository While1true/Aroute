package com.test.aroute;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Route(path = "/service/main",name = "测试服务")
public class JumpMainActivity implements JumpService {
    @Override
    public void jump(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    @Override
    public void init(Context context) {

    }
}
