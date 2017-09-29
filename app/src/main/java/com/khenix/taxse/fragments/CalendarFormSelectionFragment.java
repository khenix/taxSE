package com.khenix.taxse.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.FilingAdapter;
import com.khenix.taxse.schema.Filing;
import com.khenix.taxse.schema.SelectedFiling;
import com.khenix.taxse.util.ScaleTransformer;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by kestrella on 9/29/17.
 */

public class CalendarFormSelectionFragment extends Fragment {
  private static final String TAG = CalendarFormSelectionFragment.class.getSimpleName();
  @BindView(R.id.rv_cal_forms)
  RecyclerView rvForms;


  List<Filing> filingList = new ArrayList<>();
  List<Filing> selectedFilings = new ArrayList<>();
  ModelMapper mapper = new ModelMapper();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.calendar_forms_selection_layout, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    filingList = App.getInstance().filing.list();

    GalleryLayoutManager layoutManager1 = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
    layoutManager1.attach(rvForms, 0);
    layoutManager1.setItemTransformer(new ScaleTransformer());
    FilingAdapter filingAdapter = new FilingAdapter(filingList) {
      @Override
      public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
      }
    };
    filingAdapter.setOnItemClickListener(new FilingAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        rvForms.smoothScrollToPosition(position);
        ((CardView) view).setCardBackgroundColor(Color.WHITE);
        Filing filing = filingList.get(position);
        if (isItemExistOnSelected(filing)) {
          selectedFilings.remove(filing);

        }

      }
    });

    filingAdapter.setOnItemLongClickListener(new FilingAdapter.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(View view, int position) {
        rvForms.smoothScrollToPosition(position);
        ((CardView) view).setCardBackgroundColor(getResources().getColor(R.color.selected_item));
        Filing filing = filingList.get(position);
        if (!isItemExistOnSelected(filing)) {
          selectedFilings.add(filing);

        }
        return true;
      }
    });
    rvForms.setAdapter(filingAdapter);
  }


  @OnClick(R.id.fab_add_to_cal_forms)
  void addToFilingsListener() {
    showConfirmDialog();
  }

  private void saveAsSelectedFilings() {
    makeLog(new Gson().toJson(selectedFilings));
    for (Filing each : selectedFilings) {
      SelectedFiling selectedFiling = mapper.map(each, SelectedFiling.class);
      if (selectedFiling.getId().equalsIgnoreCase("1601-E")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1601-C")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1604-CF")) {
        DateTime now = new DateTime();
        DateTime filingDate = new DateTime(now.getYear() + 1, 1, 30, 0, 0);
        List<String> filingDates = new ArrayList<>();
        filingDates.add(filingDate.toString());
        selectedFiling.setFilingDates(new Gson().toJson(filingDates));

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1604-E")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("2551-M")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("2550-M")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("2550-Q")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1701-Q")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1701")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("0605")) {

      }
      else if (selectedFiling.getId().equalsIgnoreCase("1901")) {

      }

      App.getInstance().selectedFiling.insertOrReplace(selectedFiling);
      makeLog(new Gson().toJson(App.getInstance().selectedFiling.list()));

    }
    // // TODO: 9/29/17 filing dates 
  }

  void showConfirmDialog() {
    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    AlertDialog dialog;

    builder.setMessage(getString(R.string.add_confirm))
        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            saveAsSelectedFilings();
            dialog.dismiss();
          }
        })
        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });

    dialog = builder.create();
    dialog.show();
  }

  boolean isItemExistOnSelected(Filing filing) {
    for (Filing each : selectedFilings) {
      if (each.getId().equals(filing.getId())) {
        return true;
      }
    }
    return false;
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
