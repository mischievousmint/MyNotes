package com.example.mynotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<NotesModel> notesModelList;

    public NotesAdapter(List<NotesModel> userModelList) {
        this.notesModelList = userModelList;
    }

    public void loadData(List<NotesModel> news){
        this.notesModelList = news;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = notesModelList.get(position).getTitle();
        String subtitle = notesModelList.get(position).getSubtitle();
        holder.title.setText(title);
        holder.subtitle.setText(subtitle);
    }

    @Override
    public int getItemCount() {
        return notesModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView subtitle;
        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tvTitle);
            subtitle=v.findViewById(R.id.tvSubtitle);
        }
    }

}
