package com.khenix.taxse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khenix.taxse.R;

import butterknife.ButterKnife;

/**
 * Created by kestrella on 9/29/17.
 */

public class CalendarFormSelectionFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.calendar_forms_selection_layout, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }
}
