package com.desarrollodroide.mvpsamplejavaforandroid.mvp;

import com.desarrollodroide.mvpsamplejavaforandroid.model.Data;
import com.desarrollodroide.mvpsamplejavaforandroid.network.ApiClient;
import java.util.List;

public class MainActivityImpl implements MainActivityPresenter {

    private MainActivityView mainActivityView;

    @Override
    public void attachView(MainActivityView view) {
        mainActivityView = view;
    }

    @Override
    public void getData() {
        mainActivityView.showProgress();
        ApiClient.getDataFromServer(new ApiClient.DataLoadListener() {
            @Override
            public void onSuccessResponse(List<Data> data) {
                mainActivityView.hideProgress();
                mainActivityView.dataLoadedSuccess(data);
            }

            @Override
            public void onErrorResponse() {
                mainActivityView.hideProgress();
                mainActivityView.dataLoadedError();
            }
        });
    }
}
