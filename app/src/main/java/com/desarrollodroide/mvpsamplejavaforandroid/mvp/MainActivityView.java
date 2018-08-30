package com.desarrollodroide.mvpsamplejavaforandroid.mvp;

import com.desarrollodroide.mvpsamplejavaforandroid.model.Data;
import java.util.List;

public interface MainActivityView {
     void dataLoadedSuccess(List<Data> data);
     void dataLoadedError();
     void showProgress();
     void hideProgress();
}
