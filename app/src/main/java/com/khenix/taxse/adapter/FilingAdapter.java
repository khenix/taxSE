package com.khenix.taxse.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khenix.taxse.R;
import com.khenix.taxse.schema.Filing;

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class FilingAdapter extends RecyclerView.Adapter<FilingAdapter.ViewHolder>
    implements View.OnClickListener, View.OnLongClickListener {
  private static final String TAG = "FilingAdapter";
  private List<Filing> mItems;
  private FilingAdapter.OnItemClickListener mOnItemClickListener;
  private FilingAdapter.OnItemLongClickListener mOnItemLongClickListener;


  public FilingAdapter(List<Filing> items) {
    this.mItems = items;
  }

  public FilingAdapter setOnItemClickListener(FilingAdapter.OnItemClickListener onItemClickListener) {
    this.mOnItemClickListener = onItemClickListener;
    return this;
  }

  public FilingAdapter setOnItemLongClickListener(FilingAdapter.OnItemLongClickListener onItemLongClickListener) {
    this.mOnItemLongClickListener = onItemLongClickListener;
    return this;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Log.e(TAG, "onCreateViewHolder: type:" + viewType);
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filing_item_layout, parent, false);
    v.setOnClickListener(this);
    v.setOnLongClickListener(this);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Log.d(TAG, "onBindViewHolder: position:" + position);
    Filing item = mItems.get(position);
    holder.tvId.setText(item.getId());
    holder.tvTitle.setText(item.getTitle());
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

  @Override
  public boolean onLongClick(View v) {
    if (mOnItemLongClickListener != null) {
      return mOnItemLongClickListener.onItemLongClick(v, (int) v.getTag());
    }
    return true;
  }

  protected static class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvId, tvTitle;

    ViewHolder(View itemView) {
      super(itemView);
      tvId = itemView.findViewById(R.id.tv_filing_item_id);
      tvTitle = itemView.findViewById(R.id.tv_filing_item_title);
    }
  }

  public interface OnItemClickListener {

    void onItemClick(View view, int position);

  }

  public interface OnItemLongClickListener {

    boolean onItemLongClick(View view, int position);

  }
}
