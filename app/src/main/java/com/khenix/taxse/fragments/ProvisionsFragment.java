package com.khenix.taxse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khenix.taxse.R;
import com.khenix.taxse.adapter.ProvisionsAdapter;
import com.khenix.taxse.util.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by kestrella on 9/25/17 at 11:55 AM.
 */

public class ProvisionsFragment extends Fragment {

  @BindView(R.id.recycler_forms)
  RecyclerView recyclerForms;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.provision_layout, container, false);

  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);


    final List<String> title = new ArrayList<>();
    int size = 10;
    for (int i = 0; i < size; i++) {
      title.add("Hello" + i);
    }
    GalleryLayoutManager layoutManager1 = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
    layoutManager1.attach(recyclerForms, 0);
    layoutManager1.setItemTransformer(new ScaleTransformer());
    ProvisionsAdapter demoAdapter1 = new ProvisionsAdapter(title) {
      @Override
      public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
      }
    };
    demoAdapter1.setOnItemClickListener(new ProvisionsAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        recyclerForms.smoothScrollToPosition(position);
      }
    });
    recyclerForms.setAdapter(demoAdapter1);

  }
}
