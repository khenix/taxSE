package com.khenix.taxse.sources;

import android.util.Log;

import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.schema.Filing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class FilingImpl implements FilingInterface {
  private static final String TAG = FilingImpl.class.getSimpleName();

  private DaoSession daoSession;

  public FilingImpl(DaoSession daoSession) {
    this.daoSession = daoSession;
  }

  @Override
  public void create(Filing filing) {
    try {
      daoSession.getFilingDao().insert(filing);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public List<Filing> list() {
    List<Filing> productList = new ArrayList<>();
    try {
      productList = daoSession.getFilingDao().loadAll();
    } catch (Exception e) {
      makeLog(e.toString());

    }
    return productList;
  }

  @Override
  public Filing get(String key) {
    Filing product = null;
    try {
      product = daoSession.getFilingDao().load(key);
    } catch (Exception e) {
      makeLog(e.toString());
    }
    return product;
  }

  @Override
  public void update(Filing filing) {
    try {
      daoSession.getFilingDao().update(filing);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }


  @Override
  public void insertOrReplace(Filing filing) {
    try {
      daoSession.getFilingDao().insertOrReplace(filing);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public void remove(Filing filing) {
    try {
      daoSession.getFilingDao().delete(filing);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
