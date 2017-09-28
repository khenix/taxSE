package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.schema.Provision;
import com.khenix.taxse.schema.ProvisionRequirement;

import java.util.ArrayList;
import java.util.List;

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
    initializeData();
  }

  @OnClick(R.id.btn_prov_list)
  void openProvList() {
    if (App.getInstance().selectedProvision.list().size() <= 0) {
      ProvisionSelectionFragment provisionSelectionFragment = new ProvisionSelectionFragment();
      getFragmentManager().beginTransaction()
          .replace(R.id.layout_content, provisionSelectionFragment, "ProvisionSelectionFragment")
          .addToBackStack("ProvisionSelectionFragment").commit();
    } else {
      ProvisionsFragment provisionsFragment = new ProvisionsFragment();
      getFragmentManager().beginTransaction()
          .replace(R.id.layout_content, provisionsFragment, "ProvisionsFragment")
          .addToBackStack("ProvisionSelectionFragment").commit();
    }


  }

  private void initializeData() {

//    Provision _1906 = new Provision();
//    _1906.setId(1906);
//    _1906.setTitle("Application for Authority to print receipts and invoices");
//    List<String> _1906_requirements = new ArrayList<>();
//    _1906_requirements.add("Accomplished 1906");
//    _1906_requirements.add("Job order");
//    _1906_requirements.add("Last booklet of previous ATP");
//    _1906_requirements.add("Photocopy - Cert. of Registration of BIR");
//    _1906_requirements.add("Permit to loose-leaf");
//    _1906_requirements.add("Printers certificate of delivery");
//    _1906.setRequirements(new Gson().toJson(_1906_requirements));
//    App.getInstance().provision.insertOrReplace(_1906);

    // ---------------- provision 1 --------------------------
    if (App.getInstance().provisionRequirement.list().size() <= 0) {


      ProvisionRequirement _1 = new ProvisionRequirement();
      _1.setId(1);
      _1.setCompleted(false);
      _1.setName("Business permit");
      App.getInstance().provisionRequirement.insertOrReplace(_1);

      ProvisionRequirement _2 = new ProvisionRequirement();
      _2.setId(2);
      _2.setCompleted(false);
      _2.setName("NSO birth cert");
      App.getInstance().provisionRequirement.insertOrReplace(_2);

      ProvisionRequirement _3 = new ProvisionRequirement();
      _3.setId(3);
      _3.setCompleted(false);
      _3.setName("Contract/Company certificate");
      App.getInstance().provisionRequirement.insertOrReplace(_3);

      Provision _1904 = new Provision();
      _1904.setId(1904);
      _1904.setTitle("Application Form for TIN");
      List<Long> _1904_requirements = new ArrayList<>();
      _1904_requirements.add(_1.getId());
      _1904_requirements.add(_2.getId());
      _1904_requirements.add(_3.getId());
      _1904.setRequirements(new Gson().toJson(_1904_requirements));
      App.getInstance().provision.insertOrReplace(_1904);

      // ---------------- provision 2 --------------------------
      ProvisionRequirement _4 = new ProvisionRequirement();
      _4.setId(4);
      _4.setCompleted(false);
      _4.setName("Accomplished 1905");
      App.getInstance().provisionRequirement.insertOrReplace(_4);

      ProvisionRequirement _5 = new ProvisionRequirement();
      _5.setId(5);
      _5.setCompleted(false);
      _5.setName("Notice of closure (business)");
      App.getInstance().provisionRequirement.insertOrReplace(_5);

      ProvisionRequirement _6 = new ProvisionRequirement();
      _6.setId(6);
      _6.setCompleted(false);
      _6.setName("Estate tax return");
      App.getInstance().provisionRequirement.insertOrReplace(_6);

      ProvisionRequirement _7 = new ProvisionRequirement();
      _7.setId(7);
      _7.setCompleted(false);
      _7.setName("List of ending inventory of goods");
      App.getInstance().provisionRequirement.insertOrReplace(_7);

      ProvisionRequirement _8 = new ProvisionRequirement();
      _8.setId(8);
      _8.setCompleted(false);
      _8.setName("All business notices and permits");
      App.getInstance().provisionRequirement.insertOrReplace(_8);

      Provision _1905 = new Provision();
      _1905.setId(1905);
      _1905.setTitle("Application Form for Registration Update");
      List<Long> _1905_requirements = new ArrayList<>();
      _1905_requirements.add(_4.getId());
      _1905_requirements.add(_5.getId());
      _1905_requirements.add(_6.getId());
      _1905_requirements.add(_7.getId());
      _1905_requirements.add(_8.getId());
      _1905.setRequirements(new Gson().toJson(_1905_requirements));
      App.getInstance().provision.insertOrReplace(_1905);

    }


  }
}