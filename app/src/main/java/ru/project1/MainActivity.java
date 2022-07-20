package ru.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.project1.list.NotesAdapter;

public class MainActivity extends AppCompatActivity {

    NotesAdapter adapter;
    private Button buttonAdd;
    private Button buttonDelete;
    private MyDialogFragment dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.button_add);
        buttonDelete = findViewById(R.id.button_detele);
        setButtonAddClickListener();
        setButtonDeleteClickListener();

        ArrayList<String> notes = new ArrayList<>();
        notes.add("Планы");
        notes.add("Дела");
        notes.add("Задачи");
        notes.add("Цели");

        RecyclerView recyclerView = findViewById(R.id.rv_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter(this, notes);
        recyclerView.setAdapter(adapter);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void setButtonAddClickListener() {
        buttonAdd.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            dialog = new MyDialogFragment("Добавить запись")
                    .setPositiveClick(v -> {
                        adapter.addToNotes(String.valueOf(dialog.editText.getText()));
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    })
                    .setNegativeClick(v -> dialog.dismiss());
            dialog.show(manager, "myDialog");
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setButtonDeleteClickListener() {
        buttonDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            dialog = new MyDialogFragment("Удалить запись")
                    .setPositiveClick(v -> {
                        adapter.deleteNote(String.valueOf(dialog.editText.getText()));
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    })
                    .setNegativeClick(v -> dialog.dismiss());
            dialog.show(manager, "myDialog");
        });
    }
}