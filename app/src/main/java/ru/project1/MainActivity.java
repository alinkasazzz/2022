package ru.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ru.project1.list.NotesAdapter;

public class MainActivity extends AppCompatActivity {

    NotesAdapter adapter;
   private Button buttonAdd;
   private Button buttonDelete;

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

    // TODO: 08.07.2022
    //  Найти способ заставить это работать через абстрактые методы. Ошибка:
    //  Fragment null must be a public static class to be  properly recreated from instance state.
    private void setButtonAddClickListener() {
        buttonAdd.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            new MyDialogFragment("Добавить запись") {
                @Override void onPositiveClick() { Log.d("TEST", "Запись добавлена"); }
                @Override void onNegativeClick() { dismiss(); }
            }.show(manager, "myDialog");
        });
    }

    private void setButtonDeleteClickListener() {
        buttonDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            new MyDialogFragment("Удалить запись") {
                @Override void onPositiveClick() { Log.d("TEST", "Запись удалена"); }
                @Override void onNegativeClick() { dismiss(); }
            }.show(manager, "myDialog");
        });
    }


}