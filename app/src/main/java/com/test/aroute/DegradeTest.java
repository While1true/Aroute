package com.test.aroute;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Route(path = "/service/degrade")
public class DegradeTest implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        ARouter.getInstance().build("/test/404").with(postcard.getExtras()).navigation();
    }

    @Override
    public void init(Context context) {

    }
}
