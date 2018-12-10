package com.example.tantan.healthchecker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tantan.healthchecker.ulti.AppUtils;

import java.util.List;

public class RecordListAdapter extends RecyclerView.Adapter<RecordListAdapter.CustomViewHolder> {
    private List<Record> records;
    public RecordListAdapter(List<Record> records) {
        this.records = records;
    };

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_list_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Record record = getItem(position);

        holder.itemBMI.setText(Double.toString(record.getBMI()));
        holder.itemTime.setText(AppUtils.getFormattedDateString(record.getSavedAt()));


    }
    @Override
    public int getItemCount() {
        return records.size();
    }

    public Record getItem(int position) {
        return records.get(position);
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView  itemTime, itemBMI;
        public CustomViewHolder(View itemView) {
            super(itemView);

            itemBMI = itemView.findViewById(R.id.item_BMI);
            itemTime = itemView.findViewById(R.id.item_desc);
        }
    }
}
