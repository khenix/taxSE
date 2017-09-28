package com.khenix.taxse.sources;

import android.util.Log;

import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.schema.ProvisionRequirement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class ProvisionRequirementImpl implements ProvisionRequirementInterface {
  private static final String TAG = ProvisionRequirementImpl.class.getSimpleName();

  private DaoSession daoSession;

  public ProvisionRequirementImpl(DaoSession daoSession) {
    this.daoSession = daoSession;
  }

  @Override
  public void create(ProvisionRequirement provisionRequirement) {
    try {
      daoSession.getProvisionRequirementDao().insert(provisionRequirement);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public List<ProvisionRequirement> list() {
    List<ProvisionRequirement> productList = new ArrayList<>();
    try {
      productList = daoSession.getProvisionRequirementDao().loadAll();
    } catch (Exception e) {
      makeLog(e.toString());

    }
    return productList;
  }

  @Override
  public ProvisionRequirement get(long key) {
    ProvisionRequirement product = null;
    try {
      product = daoSession.getProvisionRequirementDao().load(key);
    } catch (Exception e) {
      makeLog(e.toString());
    }
    return product;
  }

  @Override
  public void update(ProvisionRequirement provisionRequirement) {
    try {
      daoSession.getProvisionRequirementDao().update(provisionRequirement);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }


  @Override
  public void insertOrReplace(ProvisionRequirement provisionRequirement) {
    try {
      daoSession.getProvisionRequirementDao().insertOrReplace(provisionRequirement);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public void remove(ProvisionRequirement provisionRequirement) {
    try {
      daoSession.getProvisionRequirementDao().delete(provisionRequirement);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
