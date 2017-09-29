package com.khenix.taxse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.khenix.taxse.FilingProgressActivity;
import com.khenix.taxse.R;

import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by kestrella on 9/29/17.
 */

public class PayerTypeAFragment extends Fragment {
  @OnItemSelected(R.id.spinner_payer_type_a)
  void spinnerListener(AdapterView<?> parent, View view, int position, long id) {
    String selectedItem = parent.getItemAtPosition(position).toString();
    ((FilingProgressActivity) getActivity()).setEmploymentType(selectedItem);

  }


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.payer_type_a_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }
}
