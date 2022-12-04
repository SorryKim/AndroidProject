package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView reviewText;
        TextView scoreText;

        public ViewHolder(View view) {
            super(view);
            reviewText = view.findViewById(R.id.reviewText);
            scoreText = view.findViewById(R.id.reivewScore);
            view.setOnClickListener(this);
        }

        public void setData(int index) {
            Review review = arrayList.get(index);
            reviewText.setText(review.getReview());
            scoreText.setText(review.getRating());
        }

        @Override
        public void onClick(View view) {
            selectedIndex = super.getAdapterPosition();
            Review review = arrayList.get(selectedIndex);
            if (reviewClickListener != null)
                reviewClickListener.onReviewClicked(review);
        }


    }

    LayoutInflater layoutInflater;
    ArrayList<Review> arrayList;
    int checkCount = 0;
    int selectedIndex = 0;
    OnReviewClickListener reviewClickListener;
    OnCheckCountChangeListener checkCountChangeListener;

    public MyAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<>();
    }

    public void setOnReviewClickListener(OnReviewClickListener listener) {
        this.reviewClickListener = listener;
    }

    public void setOnCheckCountChangeListener(OnCheckCountChangeListener listener) {
        this.checkCountChangeListener = listener;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.review, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }

    public void add(Review review) {
        arrayList.add(review);
        notifyItemInserted(arrayList.size() - 1);
    }

    public void update(Review review) {
        arrayList.set(selectedIndex, review);
        notifyItemChanged(selectedIndex);
    }


}
