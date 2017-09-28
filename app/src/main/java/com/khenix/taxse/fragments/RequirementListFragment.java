package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.RequirementAdapter;
import com.khenix.taxse.schema.ProvisionRequirement;
import com.khenix.taxse.schema.SelectedProvision;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.khenix.taxse.util.Utils.parseGeneric;
import static com.khenix.taxse.util.Utils.parseGenericList;

/**
 * Created by kestrella on 9/29/17.
 */

public class RequirementListFragment extends Fragment {
  private static final String TAG = RequirementListFragment.class.getSimpleName();
  List<ProvisionRequirement> provisionRequirementList = new ArrayList<>();

  @BindView(R.id.lv_requirements)
  ListView lvRequirements;

  @BindView(R.id.tv_provision_name)
  TextView tvName;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.requirement_layout, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    Bundle bundle = getArguments();
    if (bundle != null) {
      if (bundle.getString("selectedProvision") != null) {
        SelectedProvision selectedProvision =
            parseGeneric(bundle.getString("selectedProvision"), SelectedProvision.class);
        setData(selectedProvision);

      }
    }


  }

  private void setData(SelectedProvision selectedProvision) {
    List<Long> requirementIDs = parseGenericList(selectedProvision.getRequirements(), Long[].class);
    for (Long id : requirementIDs) {
      provisionRequirementList.add(App.getInstance().provisionRequirement.get(id));
    }

    RequirementAdapter requirementAdapter = new RequirementAdapter(getActivity(), provisionRequirementList);
    lvRequirements.setAdapter(requirementAdapter);
    tvName.setText(selectedProvision.getTitle() + " (" + selectedProvision.getId() + ")");

  }

  @OnClick(R.id.btn_save_requirements)
  void saveRequirements() {
    for (ProvisionRequirement provisionRequirement : provisionRequirementList) {
      App.getInstance().provisionRequirement.insertOrReplace(provisionRequirement);
    }
    makeLog("save requirements " + new Gson().toJson(provisionRequirementList));
    makeLog("list requirements " + new Gson().toJson(App.getInstance().provisionRequirement.list()));
    getFragmentManager().popBackStack();

  }


  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}