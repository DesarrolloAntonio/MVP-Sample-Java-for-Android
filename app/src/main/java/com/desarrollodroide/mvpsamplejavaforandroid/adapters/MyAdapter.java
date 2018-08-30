package com.desarrollodroide.mvpsamplejavaforandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.desarrollodroide.mvpsamplejavaforandroid.R;
import com.desarrollodroide.mvpsamplejavaforandroid.model.Data;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Data> mDataset;

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvSubtitle;
        ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvSubtitle = v.findViewById(R.id.tv_subTitle);
        }
    }

    public MyAdapter (List<Data> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(mDataset.get(position).getTitle());
        holder.tvSubtitle.setText(mDataset.get(position).getSubTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
