package com.khenix.taxse.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.khenix.taxse.R;
import com.khenix.taxse.schema.SelectedProvision;

import java.util.List;

/**
 * Created by kestrella on 9/28/17.
 */

public class SelectedProvisionsAdapter extends ArrayAdapter<SelectedProvision> {
  Context context;
  List<SelectedProvision> selectedProvisionList;

  public SelectedProvisionsAdapter(Context context, List<SelectedProvision> objects) {
    super(context, R.layout.selected_provision_item_layout, objects);
    this.context = context;
    this.selectedProvisionList = objects;

  }

  @Override
  public int getCount() {
    if (selectedProvisionList != null)
      return selectedProvisionList.size();

    return 0;
  }

  @Override
  public SelectedProvision getItem(int position) {
    if (selectedProvisionList != null && selectedProvisionList.size() > 0 && position < selectedProvisionList.size()) {
      return selectedProvisionList.get(position);
    }

    return null;
  }


  public void setData(List<SelectedProvision> data) {
    selectedProvisionList = data;
    notifyDataSetChanged();
  }

  //store the views here
  private static class ViewHolder {
    private TextView tvId, tvTitle;
  }


  @Override
  @NonNull
  public View getView(final int position, @Nullable View convertView,
                      @NonNull ViewGroup parent) {

    ViewHolder viewHolder;
    View rowView = convertView;

    if (rowView == null) {

      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      rowView = inflater.inflate(R.layout.selected_provision_item_layout, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.tvId = rowView.findViewById(R.id.tv_item_idd);
      viewHolder.tvTitle = rowView.findViewById(R.id.tv_item_titlee);
      rowView.setTag(viewHolder);

    } else {
      viewHolder = (ViewHolder) rowView.getTag();
    }

    SelectedProvision object = getItem(position);

    if (object != null) {

      viewHolder.tvId.setText(String.valueOf(object.getId()));
      viewHolder.tvTitle.setText(object.getTitle());


    } else {
      throw new NullPointerException();
    }

    return rowView;
  }

}