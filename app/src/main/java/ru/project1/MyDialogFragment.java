package ru.project1;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class MyDialogFragment extends AppCompatDialogFragment {


    final String LOG_TAG = "myLogs";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setTitle("Добавить в список");
        View view = inflater.inflate(R.layout.fragment_add, null);
        Button buttonOk =  view.findViewById(R.id.button_ok);
        Button buttonCansel =  view.findViewById(R.id.button_cancel);

        buttonOk.setOnClickListener(v -> Toast.makeText(getContext(),"omg",
                Toast.LENGTH_SHORT).show());
        buttonCansel.setOnClickListener(v -> this.dismiss());

        builder.setView(view);
        return  builder.create();
    }






}
