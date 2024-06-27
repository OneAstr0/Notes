package com.app.notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.app.notes.NotesClickListener;
import com.app.notes.R;
import com.app.notes.model.Notes;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.textViewTitle.setText(list.get(position).getTitle());
        holder.textViewTitle.setSelected(true);

        holder.textViewNotes.setText(list.get(position).getNotes());

        holder.textViewDate.setText(list.get(position).getDate());
        holder.textViewDate.setSelected(true);

        if (list.get(position).isPinned()) {
            holder.imageViewPin.setImageResource(R.drawable.ic_pin);
        } else {
            holder.imageViewPin.setImageResource(0);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notesContainer;
    TextView textViewTitle, textViewNotes, textViewDate;
    ImageView imageViewPin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notesContainer = itemView.findViewById(R.id.notes_container);
        textViewTitle = itemView.findViewById(R.id.textView_title);
        textViewNotes = itemView.findViewById(R.id.textView_notes);
        textViewDate = itemView.findViewById(R.id.textView_date);
        imageViewPin = itemView.findViewById(R.id.imageView_pin);

    }
}