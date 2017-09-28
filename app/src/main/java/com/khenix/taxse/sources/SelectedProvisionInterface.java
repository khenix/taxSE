package com.khenix.taxse.sources;

import com.khenix.taxse.schema.SelectedProvision;

import java.util.List;

/**
 * Created by kestrella on 9/28/17.
 */

public interface SelectedProvisionInterface {
  void create(SelectedProvision selectedProvision);

  List<SelectedProvision> list();

  SelectedProvision get(long key);

  void update(SelectedProvision selectedProvision);

  void insertOrReplace(SelectedProvision selectedProvision);

  void remove(SelectedProvision selectedProvision);
}