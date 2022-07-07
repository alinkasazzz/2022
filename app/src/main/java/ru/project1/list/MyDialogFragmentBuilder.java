package ru.project1.list;

import android.view.View;

import ru.project1.MyDialogFragment;

/**
 * Author: v.menshov
 * Date: 07,июль,2022
 * Task:
 */
public interface MyDialogFragmentBuilder {

    MyDialogFragment setPositiveClick(View.OnClickListener listener);
    MyDialogFragment setNegativeClick(View.OnClickListener listener);
}
