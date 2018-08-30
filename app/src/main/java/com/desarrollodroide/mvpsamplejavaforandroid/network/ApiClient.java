package com.desarrollodroide.mvpsamplejavaforandroid.network;

import android.os.Handler;
import com.desarrollodroide.mvpsamplejavaforandroid.model.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ApiClient {

    public interface DataLoadListener {
        void onSuccessResponse(List<Data> data);
        void onErrorResponse();
    }
    public static void getDataFromServer(final DataLoadListener listener){
        final Handler handler = new Handler();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        List <Data> dummyData = new ArrayList<>();
                        for (int i = 0; i < 100; i++){
                            dummyData.add(new Data("This is a title " + i, "This is a subtitle"));
                        }
                        listener.onSuccessResponse(dummyData);
                        // If server gives an error, use listener.onErrorResponse();
                    }
                });
            }
        }, 2000);
    }
}
