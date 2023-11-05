package com.example.myapplication.Transfer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.notifications.NotificationsFragment;

import java.util.List;

public class CustomeAdapter_history extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    history_list HistoryList;
    NotificationsFragment nf;
    List<Model> modelList;
    TextView mTransc_status;

    public CustomeAdapter_history(history_list historyList, List<Model> modelList) {
        this.HistoryList = historyList;
        this.modelList = modelList;
    }
    public CustomeAdapter_history(NotificationsFragment notif,List<Model>modelList){
        this.nf = notif;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transfer_history_list, parent, false);

        mTransc_status = itemView.findViewById(R.id.transaction_status);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName1.setText(modelList.get(position).getName1());
        holder.mName2.setText(modelList.get(position).getName2());
        holder.mBalance.setText(modelList.get(position).getBalance());
        holder.mDate.setText(modelList.get(position).getDate());
        holder.mTransc_status.setText(modelList.get(position).getTransaction_status());

        if(modelList.get(position).getTransaction_status().equals("Failed")){
            holder.mTransc_status.setTextColor(Color.parseColor("#f40404"));
        }else{
            holder.mTransc_status.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {

        return modelList.size();
    }

}
