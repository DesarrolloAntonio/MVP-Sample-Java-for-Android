package com.desarrollodroide.mvpsamplejavaforandroid.mvp;

public interface MainActivityPresenter {
    void attachView(MainActivityView view);
    void getData();
}
