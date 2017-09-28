package com.khenix.taxse.sources;

import com.khenix.taxse.schema.Provision;

import java.util.List;

/**
 * Created by kestrella on 9/28/17.
 */

public interface ProvisionInterface {
  void create(Provision provision);

  List<Provision> list();

  Provision get(long key);

  void update(Provision provision);

  void insertOrReplace(Provision provision);

  void remove(Provision provision);
}