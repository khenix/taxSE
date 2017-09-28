package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.SelectedProvisionsAdapter;
import com.khenix.taxse.schema.Provision;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kestrella on 9/28/17.
 */

public class ProvisionsFragment extends Fragment {
  private static final String TAG = ProvisionsFragment.class.getSimpleName();

  @BindView(R.id.lv_provisions)
  ListView lvProvisions;

  List<Provision> provisionList = new ArrayList<>();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.provisions_layout, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    //TODO: replace with selected list of provisions
    provisionList = App.getInstance().provision.list();

    SelectedProvisionsAdapter demoAdapter1 = new SelectedProvisionsAdapter(getActivity(), provisionList);
    lvProvisions.setAdapter(demoAdapter1);

  }

}
