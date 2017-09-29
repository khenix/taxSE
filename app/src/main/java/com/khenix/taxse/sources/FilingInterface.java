package com.khenix.taxse.sources;

import com.khenix.taxse.schema.Filing;

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public interface FilingInterface {
  void create(Filing filing);

  List<Filing> list();

  Filing get(String key);

  void update(Filing filing);

  void insertOrReplace(Filing filing);

  void remove(Filing filing);
}