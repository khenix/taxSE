package com.khenix.taxse.sources;

import com.khenix.taxse.schema.ProvisionRequirement;

import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public interface ProvisionRequirementInterface {
  void create(ProvisionRequirement provisionRequirement);

  List<ProvisionRequirement> list();

  ProvisionRequirement get(long key);

  void update(ProvisionRequirement provisionRequirement);

  void insertOrReplace(ProvisionRequirement provisionRequirement);

  void remove(ProvisionRequirement provisionRequirement);
}