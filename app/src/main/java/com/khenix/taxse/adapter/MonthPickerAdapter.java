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

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class MonthPickerAdapter  extends ArrayAdapter<String> {
  private Context context;
  private List<String> monthList;

  public MonthPickerAdapter(Context context, List<String> objects) {
    super(context, R.layout.month_item_layout, objects);
    this.context = context;
    this.monthList = objects;

  }

  @Override
  public int getCount() {
    if (monthList != null)
      return monthList.size();

    return 0;
  }

  @Override
  public String getItem(int position) {
    if (monthList != null && monthList.size() > 0 && position < monthList.size()) {
      return monthList.get(position);
    }

    return null;
  }


  public void setData(List<String> data) {
    monthList = data;
    notifyDataSetChanged();
  }

  //store the views here
  private static class ViewHolder {
    private TextView tvMonth;
  }


  @Override
  @NonNull
  public View getView(final int position, @Nullable View convertView,
                      @NonNull ViewGroup parent) {

    final ViewHolder viewHolder;
    View rowView = convertView;

    if (rowView == null) {

      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      rowView = inflater.inflate(R.layout.month_item_layout, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.tvMonth = rowView.findViewById(R.id.item_tv_month);
      rowView.setTag(viewHolder);

    } else {
      viewHolder = (ViewHolder) rowView.getTag();
    }

    final String object = getItem(position);

    if (object != null) {
      viewHolder.tvMonth.setText(object);
    } else {
      throw new NullPointerException();
    }

    return rowView;
  }

}
