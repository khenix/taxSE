package com.khenix.taxse.sources;

import android.util.Log;

import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.schema.Provision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/28/17.
 */

public class ProvisionImpl implements ProvisionInterface {
  private static final String TAG = ProvisionImpl.class.getSimpleName();

  private DaoSession daoSession;

  public ProvisionImpl(DaoSession daoSession) {
    this.daoSession = daoSession;
  }

  @Override
  public void create(Provision provision) {
    try {
      daoSession.getProvisionDao().insert(provision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public List<Provision> list() {
    List<Provision> productList = new ArrayList<>();
    try {
      productList = daoSession.getProvisionDao().loadAll();
    } catch (Exception e) {
      makeLog(e.toString());

    }
    return productList;
  }

  @Override
  public Provision get(long key) {
    Provision product = null;
    try {
      product = daoSession.getProvisionDao().load(key);
    } catch (Exception e) {
      makeLog(e.toString());
    }
    return product;
  }

  @Override
  public void update(Provision provision) {
    try {
      daoSession.getProvisionDao().update(provision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }


  @Override
  public void insertOrReplace(Provision provision) {
    try {
      daoSession.getProvisionDao().insertOrReplace(provision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public void remove(Provision provision) {
    try {
      daoSession.getProvisionDao().delete(provision);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
