package ru.project1.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.project1.R;

/**
 * Author: v.menshov
 * Date: 27,апрель,2022
 * Task:
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<String> names;
    private LayoutInflater inflater;

    public NotesAdapter(Context context, List<String> names) {
        this.inflater = LayoutInflater.from(context);
        this.names = names;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String note = names.get(position);
        holder.textView.setText(note);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

   class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.nameNote);

        }
    }

}