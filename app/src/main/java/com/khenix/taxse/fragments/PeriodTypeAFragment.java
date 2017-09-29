package com.khenix.taxse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.khenix.taxse.FilingProgressActivity;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.MonthPickerAdapter;
import com.khenix.taxse.util.DataInitializer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

/**
 * Created by kestrella on 9/29/17.
 */

public class PeriodTypeAFragment extends Fragment {
  @BindView(R.id.grid_months)
  GridView gridMonths;

  @BindView(R.id.layout_fiscal_selection)
  LinearLayout layout_fiscal_selection;

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
    months = DataInitializer.fetchMonths();
    monthPickerAdapter = new MonthPickerAdapter(getActivity(), months);
    gridMonths.setAdapter(monthPickerAdapter);
  }

  @OnItemSelected(R.id.spinner_period_type_a)
  void spinnerListener(AdapterView<?> parent, View view, int position, long id) {
    String selectedItem = parent.getItemAtPosition(position).toString();
    ((FilingProgressActivity) getActivity()).setPeriodType(selectedItem);

    if (selectedItem.equalsIgnoreCase("Calendar year")) {
      layout_fiscal_selection.setVisibility(View.GONE);

    } else {
      layout_fiscal_selection.setVisibility(View.VISIBLE);
    }

  }

  @OnItemClick(R.id.grid_months)
  void gridListener(AdapterView<?> parent, View view, int position, long id) {
    ((FilingProgressActivity) getActivity()).setBeginningMonth(position);
  }

}
