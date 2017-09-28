package com.khenix.taxse.sources;

import android.util.Log;

import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.schema.SelectedProvision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/28/17.
 */

public class SelectedProvisionImpl implements SelectedProvisionInterface {
  private static final String TAG = SelectedProvisionImpl.class.getSimpleName();

  private DaoSession daoSession;

  public SelectedProvisionImpl(DaoSession daoSession) {
    this.daoSession = daoSession;
  }

  @Override
  public void create(SelectedProvision selectedProvision) {
    try {
      daoSession.getSelectedProvisionDao().insert(selectedProvision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public List<SelectedProvision> list() {
    List<SelectedProvision> productList = new ArrayList<>();
    try {
      productList = daoSession.getSelectedProvisionDao().loadAll();
    } catch (Exception e) {
      makeLog(e.toString());

    }
    return productList;
  }

  @Override
  public SelectedProvision get(long key) {
    SelectedProvision product = null;
    try {
      product = daoSession.getSelectedProvisionDao().load(key);
    } catch (Exception e) {
      makeLog(e.toString());
    }
    return product;
  }

  @Override
  public void update(SelectedProvision selectedProvision) {
    try {
      daoSession.getSelectedProvisionDao().update(selectedProvision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }


  @Override
  public void insertOrReplace(SelectedProvision selectedProvision) {
    try {
      daoSession.getSelectedProvisionDao().insertOrReplace(selectedProvision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public void remove(SelectedProvision selectedProvision) {
    try {
      daoSession.getSelectedProvisionDao().delete(selectedProvision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
