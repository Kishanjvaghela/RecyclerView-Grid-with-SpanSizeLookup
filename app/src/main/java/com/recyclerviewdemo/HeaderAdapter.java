package com.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisha_000 on 5/12/2016.
 */
public class HeaderAdapter extends RecyclerView.Adapter<TextViewHolder> {

    private final List<String> labels;

    public HeaderAdapter(int count) {
        this.labels = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            labels.add(String.valueOf(i));
        }
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = -1;
        switch (viewType) {
            case 0:
                layoutId = R.layout.item;
                break;
            case 1:
                layoutId = R.layout.item1;
                break;
            case 2:
                layoutId = R.layout.item2;
                break;
            case 3:
                layoutId = R.layout.item3;
                break;
            case 4:
                layoutId = R.layout.item4;
                break;
            case 5:
                layoutId = R.layout.item5;
                break;
            case 6:
                layoutId = R.layout.item6;
                break;
            default:
                layoutId = R.layout.item;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        final String label = labels.get(position);  // Subtract 1 for header
        holder.textView.setText(label);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        holder.textView.getContext(), label, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position % 7;
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }
}
