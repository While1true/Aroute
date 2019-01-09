package com.widget.State;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.widget.Adpater.Base.Holder;
import com.widget.State.Interface.IShowStateInterface;
import com.widget.State.Interface.IStateHandlerInterface;
import com.widget.State.Interface.IStateListener;
import com.widget.State.Interface.Recorder;
import com.widget.State.Interface.StateEnum;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by ck on 2017/7/29.
 */

public class StateLayout extends FrameLayout implements IShowStateInterface {
    //全局id记录者
    protected static Recorder globalrecorder;
    //状态onindBView
    protected IStateHandlerInterface stateHandler;

    private StateEnum showstate = StateEnum.TYPE_ITEM;
    private int showtime = 6000;

    private Map<StateEnum, View> views = new LinkedHashMap<>(4);
    private Map<StateEnum, Integer> viewids = new LinkedHashMap<>(4);

    public StateLayout(@NonNull Context context) {
        this(context, null);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 0) {
            if (views.get(StateEnum.TYPE_ITEM) == null) {
                views.put(StateEnum.TYPE_ITEM, getChildAt(0));
            }
        }
    }

    public void setShowtime(int time) {
        showtime = time;
    }

    private void init() {
        Recorder recorder = globalrecorder;
        if (globalrecorder == null)
            recorder = new Recorder.Builder().build();
        viewids.put(StateEnum.SHOW_EMPTY, recorder.getEmptyres());
        viewids.put(StateEnum.SHOW_NOMORE, recorder.getNomore());
        viewids.put(StateEnum.SHOW_LOADING, recorder.getLoadingres());
        viewids.put(StateEnum.SHOW_ERROR, recorder.getErrorres());

        try {
            stateHandler = recorder.getClazz().newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public StateLayout setStateHandler(IStateHandlerInterface stateHandler) {
        this.stateHandler = stateHandler;
        return this;
    }

    /**
     * 设置状态布局的监听
     *
     * @param listener
     * @return
     */
    public StateLayout setStateListener(IStateListener listener) {
        stateHandler.setStateClickListener(listener);
        return this;
    }

    /**
     * 全局初始化状态 layout id
     *
     * @param globalRecordera
     */
    public static void init(Recorder globalRecordera) {
        globalrecorder = globalRecordera;
    }

    public StateLayout setContent(View view) {
        views.put(StateEnum.TYPE_ITEM, view);
        addView(view);
        return this;
    }

    public StateEnum getShowstate() {
        return showstate;
    }

    public void setShowstate(StateEnum showstate) {
        this.showstate = showstate;
    }


    public static int dp2px(Context context, float dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public StateLayout setContent(@LayoutRes int contentres) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View contentView = inflater.inflate(contentres, this, false);
        views.put(StateEnum.TYPE_ITEM, contentView);
        addView(contentView);
        return this;
    }

    @Override
    public void showState(StateEnum showstate, Object o) {
        if (this.showstate != showstate) {
            if(this.showstate!=StateEnum.TYPE_ITEM) {
                removeView(views.get(this.showstate));
                views.remove(this.showstate);
            }
            if(showstate!=StateEnum.TYPE_ITEM) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                int resource = viewids.get(showstate);
                View showView =resource==-1?new View(getContext()):inflater.inflate(resource, this, false);
                views.put(showstate, showView);
                addView(showView);
            }
            this.showstate = showstate;
            View view = views.get(StateEnum.TYPE_ITEM);
            if (showstate == StateEnum.TYPE_ITEM) {
                if (view != null) {
                    view.setVisibility(VISIBLE);
                }
            } else {
                if (showstate != StateEnum.SHOW_NOMORE) {
                    if (view != null) {
                        view.setVisibility(INVISIBLE);
                    }
                }
            }
            stateHandler.switchState(showstate);
        }

        switch (showstate) {
            case SHOW_NOMORE:
                stateHandler.BindNomoreHolder(Holder.createViewHolder(views.get(showstate)), o);
            case SHOW_LOADING:
                stateHandler.BindLoadingHolder(Holder.createViewHolder(views.get(showstate)), o);
                break;
            case SHOW_EMPTY:
                stateHandler.BindEmptyHolder(Holder.createViewHolder(views.get(showstate)), o);
                break;
            case SHOW_ERROR:
                stateHandler.BindErrorHolder(Holder.createViewHolder(views.get(showstate)), o);
                break;
        }
    }

    @Override
    public void showEmpty() {
        showState(StateEnum.SHOW_EMPTY, null);
    }

    @Override
    public void ShowError() {
        showState(StateEnum.SHOW_ERROR, null);
    }

    @Override
    public void showItem() {
        showState(StateEnum.TYPE_ITEM, null);
    }

    @Override
    public void showLoading() {
        showState(StateEnum.SHOW_LOADING, null);
    }


    @Deprecated
    @Override
    public void showNomore() {
        throw new UnsupportedOperationException("不支持");
    }

    public void setLayoutId(StateEnum showstate, int layoutid) {
        viewids.put(showstate, layoutid);
    }

}

