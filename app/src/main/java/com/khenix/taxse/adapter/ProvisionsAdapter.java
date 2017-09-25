package com.khenix.taxse.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khenix.taxse.R;

import java.util.List;
import java.util.Random;

/**
 * Created by kestrella on 9/25/17 at 12:03 PM.
 */

public class ProvisionsAdapter extends RecyclerView.Adapter<ProvisionsAdapter.ViewHolder> implements View.OnClickListener {
  private static final String TAG = "ProvisionsAdapter";
  private List<String> mItems;
  private OnItemClickListener mOnItemClickListener;


  public ProvisionsAdapter(List<String> items) {
    this.mItems = items;
  }

  public void addData() {
    if (mItems != null) {
      for (int i = 0; i < 10; i++) {
        mItems.add("Extra:" + i);
      }
      notifyDataSetChanged();
    }
  }

  private static final Random RANDOM = new Random();

  public int dataChange() {
    int result = 0;
    if (mItems != null) {
      if (RANDOM.nextBoolean()) {
        for (int i = 0; i < 10; i++) {
          mItems.add("Extra:" + i);
        }
        result = 1;
      } else {
        int size = mItems.size();
        int cut = size / 2;
        for (int i = size - 1; i > cut; i--) {
          mItems.remove(i);
        }
        result = -1;
      }
      notifyDataSetChanged();
    }
    return result;
  }

  public ProvisionsAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.mOnItemClickListener = onItemClickListener;
    return this;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Log.e(TAG, "onCreateViewHolder: type:" + viewType);
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.provision_item_layout, parent, false);
    v.setOnClickListener(this);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Log.d(TAG, "onBindViewHolder: position:" + position);
    String item = mItems.get(position);
    holder.tvTitle.setText("HelloWorld：" + item);
    holder.itemView.setTag(position);
  }

  @Override
  public int getItemCount() {
    return mItems.size();
  }

  @Override
  public void onClick(final View v) {
    if (mOnItemClickListener != null) {
      mOnItemClickListener.onItemClick(v, (int) v.getTag());
    }
  }

  protected static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;

    public ViewHolder(View itemView) {
      super(itemView);
      tvTitle = itemView.findViewById(R.id.tv_item_title);
    }
  }

  public interface OnItemClickListener {

    void onItemClick(View view, int position);

  }
}
