package com.widget.State.Interface;


/**
 * Created by ck on 2017/9/10.
 */

public interface IShowStateInterface<T> {

    void showState(StateEnum showstate, T t);

    void showEmpty();

    void ShowError();

    void showItem();

    void showLoading();

    void showNomore();
}
