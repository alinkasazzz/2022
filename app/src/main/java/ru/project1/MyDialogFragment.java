package ru.project1;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import ru.project1.list.MyDialogFragmentBuilder;

public class MyDialogFragment extends AppCompatDialogFragment implements MyDialogFragmentBuilder {

    private final String title;
    private View.OnClickListener onPositiveClick, onNegativeClick;

    public MyDialogFragment(String title) {
        this.title = title;
    }

    @Override
    public MyDialogFragment setPositiveClick(View.OnClickListener listener) {
        this.onPositiveClick = listener;
        return this;
    }

    @Override
    public MyDialogFragment setNegativeClick(View.OnClickListener listener) {
        this.onNegativeClick = listener;
        return this;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View view = requireActivity().getLayoutInflater().inflate(R.layout.fragment_add, null);
        view.findViewById(R.id.button_ok).setOnClickListener(onPositiveClick);
        view.findViewById(R.id.button_cancel).setOnClickListener(onNegativeClick);
        return builder.setTitle(title).setView(view).create();
    }
}
