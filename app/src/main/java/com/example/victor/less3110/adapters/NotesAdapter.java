package com.example.victor.less3110.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.victor.less3110.R;
import com.example.victor.less3110.model.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.victor.less3110.R.id.list_notes;
import static com.example.victor.less3110.R.id.notes_text_view;

/**
 * Created by Victor on 31.10.2016.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Note> mDataSource = null;

    public void setDataSource (List<Note> dataSource){
        this.mDataSource = dataSource;
        notifyDataSetChanged();
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notes_items, parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        Note note = mDataSource.get(position);
        holder.bindView(note);

    }

    @Override
    public int getItemCount() {
        if(mDataSource == null) return 0;
        return mDataSource.size();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.notes_text_view) protected TextView titleTextView;
        @BindView(R.id.notes_text_view_second) protected TextView secondaryTextView;
        @BindView(R.id.date_text_view) protected TextView timeTextView;

        public NotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //titleTextView = (TextView) itemView.findViewById(R.id.notes_text_view);
        }

        void bindView(Note note){
            titleTextView.setText(note.getTitle());
            secondaryTextView.setText(note.getText());
            timeTextView.setText(String.valueOf(note.getTime()));
        }

    }

}
