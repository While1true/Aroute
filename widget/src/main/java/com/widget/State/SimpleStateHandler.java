package com.widget.State;

import android.view.animation.Interpolator;

import com.widget.Adpater.Base.Holder;
import com.widget.State.Interface.IStateHandlerInterface;
import com.widget.State.Interface.IStateListener;
import com.widget.State.Interface.StateEnum;


/**
 * Created by ck on 2017/9/9.
 */

public class SimpleStateHandler implements IStateHandlerInterface<String> {
    private IStateListener listener;
    private SLoading sLoading;

    public SimpleStateHandler setStateClickListener(IStateListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    public IStateListener getStateClickListener() {
        return listener;
    }

    @Override
    public void BindEmptyHolder(Holder holder, String s) {
    }

    @Override
    public void BindErrorHolder(Holder holder, String s) {
    }

    @Override
    public void BindLoadingHolder(Holder holder, String s) {
    }

    @Override
    public void BindNomoreHolder(final Holder holder, String s) {

    }


    public class DecelerateAccelerateInterpolator implements Interpolator {
        public DecelerateAccelerateInterpolator() {
        }

        public float getInterpolation(float t) {
            float x = 2.0f * t - 1.0f;
            return 0.5f * (x * x * x + 1.0f);
        }
    }

    /**
     * 销毁时调用
     */
    public void destory() {
    }

    /**
     * 切换状态时调用，关闭一些动画
     */
    @Override
    public void switchState(StateEnum state) {
    }
}
