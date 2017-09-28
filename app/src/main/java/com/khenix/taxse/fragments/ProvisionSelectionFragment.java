package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.R;
import com.khenix.taxse.adapter.ProvisionsAdapter;
import com.khenix.taxse.schema.Provision;
import com.khenix.taxse.util.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by kestrella on 9/25/17 at 11:55 AM.
 */

public class ProvisionSelectionFragment extends Fragment {
  private static final String TAG = ProvisionSelectionFragment.class.getSimpleName();

  @BindView(R.id.recycler_forms)
  RecyclerView recyclerForms;

  List<Provision> provisionList = new ArrayList<>();
  List<Provision> selectedProvisions = new ArrayList<>();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.provision_layout, container, false);

  }

  @SuppressWarnings("deprecation")
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    provisionList = App.getInstance().provision.list();


    GalleryLayoutManager layoutManager1 = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
    layoutManager1.attach(recyclerForms, 0);
    layoutManager1.setItemTransformer(new ScaleTransformer());
    ProvisionsAdapter demoAdapter1 = new ProvisionsAdapter(provisionList) {
      @Override
      public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
      }
    };
    demoAdapter1.setOnItemClickListener(new ProvisionsAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        recyclerForms.smoothScrollToPosition(position);
        ((CardView) view).setCardBackgroundColor(Color.WHITE);
        Provision provision = provisionList.get(position);
        if (isItemExistOnSelected(provision)) {
          selectedProvisions.remove(provisionList.get(position));

        }

      }
    });

    demoAdapter1.setOnItemLongClickListener(new ProvisionsAdapter.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(View view, int position) {
        recyclerForms.smoothScrollToPosition(position);
        ((CardView) view).setCardBackgroundColor(getResources().getColor(R.color.selected_item));
        Provision provision = provisionList.get(position);
        if (!isItemExistOnSelected(provision)) {
          selectedProvisions.add(provisionList.get(position));

        }
        return true;
      }
    });
    recyclerForms.setAdapter(demoAdapter1);

  }

  @OnClick(R.id.fab_add_to_provisions)
  void addToProvisions() {
    makeLog(new Gson().toJson(selectedProvisions));
  }

  boolean isItemExistOnSelected(Provision provision) {
    for (Provision each : selectedProvisions) {
      if (each.getId() == provision.getId()) {
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
