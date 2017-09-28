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
    ProvisionSelectionFragment provisionSelectionFragment = new ProvisionSelectionFragment();
    getFragmentManager().beginTransaction()
        .replace(R.id.layout_content, provisionSelectionFragment, "ProvisionSelectionFragment")
        .addToBackStack("ProvisionSelectionFragment").commit();

  }

  private void initializeData() {
    Provision _1904 = new Provision();
    _1904.setId(1904);
    _1904.setTitle("Application Form for TIN");
    List<String> _1904_requirements = new ArrayList<>();
    _1904_requirements.add("Business permit");
    _1904_requirements.add("NSO birth cert");
    _1904_requirements.add("Contract/Company certificate");
    _1904.setRequirements(new Gson().toJson(_1904_requirements));
    App.getInstance().provision.insertOrReplace(_1904);

    Provision _1905 = new Provision();
    _1905.setId(1905);
    _1905.setTitle("Application Form for Registration Update");
    List<String> _1905_requirements = new ArrayList<>();
    _1905_requirements.add("Accomplished 1905");
    _1905_requirements.add("Notice of closure (business)");
    _1905_requirements.add("Estate tax return");
    _1905_requirements.add("List of ending inventory of goods");
    _1905_requirements.add("All business notices and permits");
    _1905.setRequirements(new Gson().toJson(_1905_requirements));
    App.getInstance().provision.insertOrReplace(_1905);

    Provision _1906 = new Provision();
    _1906.setId(1906);
    _1906.setTitle("Application for Authority to print receipts and invoices");
    List<String> _1906_requirements = new ArrayList<>();
    _1906_requirements.add("Accomplished 1906");
    _1906_requirements.add("Job order");
    _1906_requirements.add("Last booklet of previous ATP");
    _1906_requirements.add("Photocopy - Cert. of Registration of BIR");
    _1906_requirements.add("Permit to loose-leaf");
    _1906_requirements.add("Printers certificate of delivery");
    _1906.setRequirements(new Gson().toJson(_1906_requirements));
    App.getInstance().provision.insertOrReplace(_1906);
  }
}