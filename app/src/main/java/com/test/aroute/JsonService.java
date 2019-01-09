package com.test.aroute;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * by ckckck 2019/1/8
 * <p>
 * life is short , bugs are too many!
 */
@Route(path = "/service/json")
public class JsonService implements SerializationService {


    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return null;
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return new Gson().fromJson(input,clazz);
    }

    @Override
    public void init(Context context) {

    }
}
