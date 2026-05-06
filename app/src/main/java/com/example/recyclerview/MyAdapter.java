package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> itemList;

    public MyAdapter(List<ListItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem item = itemList.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewClicked.setVisibility(item.isClicked() ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            item.setClicked(true);
            notifyItemChanged(position);
            Toast.makeText(v.getContext(), item.getName() + " clicked", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void resetAll() {
        for (ListItem item : itemList) {
            item.setClicked(false);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewClicked;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewClicked = itemView.findViewById(R.id.textViewClicked);
        }
    }
}
