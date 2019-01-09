package com.widget.State.Interface;


import android.support.annotation.LayoutRes;

import com.widget.State.SimpleStateHandler;

/**
 * Created by ck on 2017/9/9.
 */

public class Recorder {
    private int Loadingres = -1;
    private int emptyres = -1;
    private int errorres = -1;
    private int nomore = -1;
    private Class<? extends IStateHandlerInterface> clazz;

    private Recorder() {
    }

    public Class<? extends IStateHandlerInterface> getClazz() {
        return clazz;
    }

    private void setClazz(Class<? extends IStateHandlerInterface> clazz) {
        this.clazz = clazz;
    }

    public int getNomore() {
        return nomore;
    }

    private void setNomore(int nomore) {
        this.nomore = nomore;
    }

    private void setLoadingres(int loadingres) {
        Loadingres = loadingres;
    }

    private void setEmptyres(int emptyres) {
        this.emptyres = emptyres;
    }

    private void setErrorres(int errorres) {
        this.errorres = errorres;
    }

    public int getLoadingres() {
        return Loadingres;
    }

    public int getEmptyres() {
        return emptyres;
    }


    public int getErrorres() {
        return errorres;
    }

    @Override
    public String toString() {
        return "Recorder{" +
                "Loadingres=" + Loadingres +
                ", emptyres=" + emptyres +
                ", contentres=" +
                ", errorres=" + errorres +
                '}';
    }
    public static class Builder {
        private int Loadingres = -1;
        private int emptyres = -1;
        private int errorres = -1;
        private int nomore = -1;
        private Class<? extends IStateHandlerInterface> clazz=SimpleStateHandler.class;


         public Builder setNomoreRes(@LayoutRes int res) {
            this.nomore = res;
             return this;
        }

        public Builder setLoadingRes(@LayoutRes int res) {
            this.Loadingres = res;
            return this;
        }

        public Builder setEmptyRes(@LayoutRes int res) {
            this.emptyres = res;
            return this;
        }

        public Builder setErrorRes(@LayoutRes int res) {
            this.errorres = res;
            return this;
        }

        public Builder setStateHandlerClazz(Class<? extends IStateHandlerInterface> clazz) {
            this.clazz = clazz;
            return this;
        }

        public Recorder build() {
            Recorder recorder = new Recorder();
            recorder.setLoadingres(Loadingres);
            recorder.setEmptyres(emptyres);
            recorder.setErrorres(errorres);
            recorder.setNomore(nomore);
            recorder.setClazz(clazz);
            return recorder;
        }

    }
}
