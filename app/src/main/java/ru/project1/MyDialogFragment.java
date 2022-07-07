package ru.project1;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public abstract class MyDialogFragment extends AppCompatDialogFragment {

    private final String title;

    public MyDialogFragment(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View view = requireActivity().getLayoutInflater().inflate(R.layout.fragment_add, null);
        view.findViewById(R.id.button_ok).setOnClickListener(v -> onPositiveClick());
        view.findViewById(R.id.button_cancel).setOnClickListener(v -> onNegativeClick());
        return builder.setTitle(title).setView(view).create();
    }

    abstract void onPositiveClick();
    abstract void onNegativeClick();
}
