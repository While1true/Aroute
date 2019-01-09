package com.widget.Scrolling.MixScroll.Base;

import android.view.View;

import com.widget.Scrolling.ScrollDirection;
import com.widget.Scrolling.Scrolling;


/**
 * by ckckck 2018/12/28
 * <p>
 * life is short , bugs are too many!
 */
public interface Refreshable {

    void onLayout(ScrollDirection direction, Scrolling parent, boolean changed, int left, int top, int right, int bottom);

    boolean isHeader();

    View getContentView();

    void onPull(float pull, boolean fling);

    void onStateChange(RefreshState state);

    int canPullSpace();

    int getRefreshSpace();
}
