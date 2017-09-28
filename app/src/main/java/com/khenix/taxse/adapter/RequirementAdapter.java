package com.khenix.taxse.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.khenix.taxse.R;
import com.khenix.taxse.schema.ProvisionRequirement;

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class RequirementAdapter extends ArrayAdapter<ProvisionRequirement> {
  private Context context;
  private List<ProvisionRequirement> requirementList;

  public RequirementAdapter(Context context, List<ProvisionRequirement> objects) {
    super(context, R.layout.requirement_item_layout, objects);
    this.context = context;
    this.requirementList = objects;

  }

  @Override
  public int getCount() {
    if (requirementList != null)
      return requirementList.size();

    return 0;
  }

  @Override
  public ProvisionRequirement getItem(int position) {
    if (requirementList != null && requirementList.size() > 0 && position < requirementList.size()) {
      return requirementList.get(position);
    }

    return null;
  }


  public void setData(List<ProvisionRequirement> data) {
    requirementList = data;
    notifyDataSetChanged();
  }

  //store the views here
  private static class ViewHolder {
    private CheckBox checkRequirement;
  }


  @Override
  @NonNull
  public View getView(final int position, @Nullable View convertView,
                      @NonNull ViewGroup parent) {

    final ViewHolder viewHolder;
    View rowView = convertView;

    if (rowView == null) {

      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      rowView = inflater.inflate(R.layout.requirement_item_layout, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.checkRequirement = rowView.findViewById(R.id.check_requirement_item);
      rowView.setTag(viewHolder);

    } else {
      viewHolder = (ViewHolder) rowView.getTag();
    }

    final ProvisionRequirement object = getItem(position);

    if (object != null) {
      viewHolder.checkRequirement.setText(object.getName());
      viewHolder.checkRequirement.setChecked(object.getCompleted());

      viewHolder.checkRequirement.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (viewHolder.checkRequirement.isChecked()) {
            object.setCompleted(true);
          } else {
            object.setCompleted(false);
          }
          notifyDataSetChanged();
        }
      });


    } else {
      throw new NullPointerException();
    }

    return rowView;
  }

}
