package ru.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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

    private void setButtonAddClickListener() {
        buttonAdd.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            dialog = new MyDialogFragment("Добавить запись")
                    .setPositiveClick(v -> Log.d("TEST", "Запись добавлена"))
                    .setNegativeClick(v -> dialog.dismiss());
            dialog.show(manager, "myDialog");
        });
    }

    private void setButtonDeleteClickListener() {
        buttonDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            dialog = new MyDialogFragment("Удалить запись")
                    .setPositiveClick(v -> Log.d("TEST", "Запись удалена"))
                    .setNegativeClick(v -> dialog.dismiss());
            dialog.show(manager, "myDialog");
        });
    }


}