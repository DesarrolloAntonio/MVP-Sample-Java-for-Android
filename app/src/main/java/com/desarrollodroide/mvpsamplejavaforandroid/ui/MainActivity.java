package com.desarrollodroide.mvpsamplejavaforandroid.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.desarrollodroide.mvpsamplejavaforandroid.R;
import com.desarrollodroide.mvpsamplejavaforandroid.adapters.MyAdapter;
import com.desarrollodroide.mvpsamplejavaforandroid.model.Data;
import com.desarrollodroide.mvpsamplejavaforandroid.mvp.MainActivityImpl;
import com.desarrollodroide.mvpsamplejavaforandroid.mvp.MainActivityView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = ProgressDialog.show(this, "","Please...wait", true);
        MainActivityImpl mPresenter = new MainActivityImpl();
        mPresenter.attachView(this);
        mPresenter.getData();
    }


    @Override
    public void dataLoadedSuccess(List<Data> data) {
        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdapter(data));
    }

    @Override
    public void dataLoadedError() {
        // Show error
    }

    @Override
    public void showProgress() { progress.show(); }

    @Override
    public void hideProgress() { progress.hide(); }
}
