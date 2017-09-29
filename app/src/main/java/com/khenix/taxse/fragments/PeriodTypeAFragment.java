package com.khenix.taxse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Spinner;

import com.khenix.taxse.R;
import com.khenix.taxse.adapter.MonthPickerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kestrella on 9/29/17.
 */

public class PeriodTypeAFragment extends Fragment {
  @BindView(R.id.grid_months)
  GridView gridMonths;

  MonthPickerAdapter monthPickerAdapter;

  List<String> months = new ArrayList<>();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.period_type_a_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    initiliazeMonths();
    monthPickerAdapter = new MonthPickerAdapter(getActivity(), months);
    gridMonths.setAdapter(monthPickerAdapter);
  }

  void initiliazeMonths() {
    months.add("Jan");
    months.add("Feb");
    months.add("Mar");
    months.add("Apr");
    months.add("May");
    months.add("Jun");
    months.add("Jul");
    months.add("Aug");
    months.add("Sep");
    months.add("Oct");
    months.add("Nov");
    months.add("Dec");
  }
}
