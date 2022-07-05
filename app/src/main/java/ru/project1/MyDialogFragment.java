package ru.project1;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class MyDialogFragment extends AppCompatDialogFragment {
    Button buttonAdd;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        try {
//            someEventListener = (onSomeEventListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
//        }
    } 
    final String LOG_TAG = "myLogs";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, null);

//        Button button = (Button) v.findViewById(R.id.button);
//        button.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                someEventListener.someEvent("Test text to Fragment1");
//            }
//        });

        return v;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_add, null))
                .setTitle("Добавить в список");
        Button buttonAdd = (Button) requireActivity().findViewById(R.id.button_ok);
        Button buttonDelete = (Button) requireActivity().findViewById(R.id.button_detele);
        buttonAdd.setOnClickListener(this::dialogAddClick);
        buttonDelete.setOnClickListener(this::dialogDeleteClick);
        return  builder.create();
    }

    private void dialogAddClick(View view) {
        TextView myTextView = (TextView) requireActivity().findViewById(R.id.myText);
        myTextView.getText();
    }

    private void dialogDeleteClick(View view) {

//        dialogInterface.cancel();
    }

}
