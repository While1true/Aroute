package com.test.aroute;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Interceptor(priority = 8, name = "测试用拦截器")
public class TestIntercept implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if(postcard.getPath().equals("/test/testactivity4")){
            postcard.withObject("params",new TestBean("被拦截了"));
        }
        callback.onContinue(postcard);

    }

    @Override
    public void init(Context context) {

    }
}
