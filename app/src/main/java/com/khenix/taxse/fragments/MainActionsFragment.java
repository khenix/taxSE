package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khenix.taxse.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActionsFragment extends Fragment {


  public MainActionsFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main_actions, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }

  @OnClick(R.id.btn_prov_list)
  void openProvList() {
    ProvisionsFragment provisionsFragment = new ProvisionsFragment();
    getFragmentManager().beginTransaction()
        .replace(R.id.layout_content, provisionsFragment, "ProvisionsFragment").commit();

  }
}
