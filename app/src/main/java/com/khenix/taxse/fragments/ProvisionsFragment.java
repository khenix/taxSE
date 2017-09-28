package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.SelectedProvisionsAdapter;
import com.khenix.taxse.schema.ProvisionRequirement;
import com.khenix.taxse.schema.SelectedProvision;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

import static com.khenix.taxse.util.Utils.parseGenericList;

/**
 * Created by kestrella on 9/28/17.
 */

public class ProvisionsFragment extends Fragment {
  private static final String TAG = ProvisionsFragment.class.getSimpleName();

  @BindView(R.id.lv_provisions)
  ListView lvProvisions;

  List<SelectedProvision> selectedProvisionList = new ArrayList<>();

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
    selectedProvisionList = App.getInstance().selectedProvision.list();
    scanCompleteness();

    SelectedProvisionsAdapter demoAdapter1 = new SelectedProvisionsAdapter(getActivity(), selectedProvisionList);
    lvProvisions.setAdapter(demoAdapter1);

  }

  @OnItemClick(R.id.lv_provisions)
  void selectProvision(int position) {
    SelectedProvision selectedProvision = selectedProvisionList.get(position);
    Bundle bundle = new Bundle();
    bundle.putString("selectedProvision", new Gson().toJson(selectedProvision));

    RequirementListFragment requirementListFragment = new RequirementListFragment();
    requirementListFragment.setArguments(bundle);
    getFragmentManager().beginTransaction()
        .replace(R.id.layout_content, requirementListFragment, "RequirementListFragment")
        .addToBackStack("RequirementListFragment").commit();
  }

  void scanCompleteness() {
    for (SelectedProvision selectedProvision: selectedProvisionList) {
      List<Long> requirementIDs = parseGenericList(selectedProvision.getRequirements(), Long[].class);
      int requirementLen = requirementIDs.size();
      int completedLen = 0;
      for (Long id : requirementIDs) {
        ProvisionRequirement provisionRequirement = App.getInstance().provisionRequirement.get(id);
        if (provisionRequirement.getCompleted()) {
         completedLen++;
        }
      }
      if (completedLen == requirementLen) {
        selectedProvision.setCompleted(true);
      } else {
        selectedProvision.setCompleted(false);
      }
    }
  }

}
