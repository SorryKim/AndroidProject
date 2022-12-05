package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView2;
        RatingBar ratingBar;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            ratingBar = view.findViewById(R.id.ratingBar);
            textView2 = view.findViewById(R.id.textView2);
            ratingBar.setOnClickListener(this);
            textView2.setOnClickListener(this);
            checkBox = view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }

        public void setData(int index) {
            Memo memo = arrayList.get(index);
            ratingBar.setRating(memo.getScore());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());
        }

        @Override
        public void onClick(View view) {
            int index = super.getAdapterPosition();
            MemoListActivity activity = (MemoListActivity)ratingBar.getContext();
            activity.onMemoClicked(index);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = super.getAdapterPosition();
            Memo memo = arrayList.get(index);
            memo.setChecked(isChecked);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Memo> arrayList;

    public MemoAdapter(Context context, ArrayList<Memo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }
}