package com.khenix.taxse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.khenix.taxse.R;
import com.khenix.taxse.adapter.MonthPickerAdapter;
import com.khenix.taxse.util.DataInitializer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kestrella on 9/29/17.
 */

public class FilingCalendarFragment extends Fragment {
  @BindView(R.id.grid_months)
  GridView gridMonths;

  MonthPickerAdapter monthPickerAdapter;

  List<String> months = new ArrayList<>();
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_filing_calendar, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    months = DataInitializer.fetchMonths();
    monthPickerAdapter = new MonthPickerAdapter(getActivity(), months);
    gridMonths.setAdapter(monthPickerAdapter);
  }
}
