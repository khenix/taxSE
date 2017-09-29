package com.khenix.taxse.sources;

import com.khenix.taxse.schema.SelectedFiling;

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public interface SelectedFilingInterface {
  void create(SelectedFiling selectedFiling);

  List<SelectedFiling> list();

  SelectedFiling get(String key);

  void update(SelectedFiling selectedFiling);

  void insertOrReplace(SelectedFiling selectedFiling);

  void remove(SelectedFiling selectedFiling);
}