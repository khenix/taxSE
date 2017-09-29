package com.khenix.taxse.sources;

import android.util.Log;

import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.schema.SelectedFiling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class SelectedFilingImpl implements SelectedFilingInterface {
  private static final String TAG = SelectedFilingImpl.class.getSimpleName();

  private DaoSession daoSession;

  public SelectedFilingImpl(DaoSession daoSession) {
    this.daoSession = daoSession;
  }

  @Override
  public void create(SelectedFiling selectedFiling) {
    try {
      daoSession.getSelectedFilingDao().insert(selectedFiling);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public List<SelectedFiling> list() {
    List<SelectedFiling> productList = new ArrayList<>();
    try {
      productList = daoSession.getSelectedFilingDao().loadAll();
    } catch (Exception e) {
      makeLog(e.toString());

    }
    return productList;
  }

  @Override
  public SelectedFiling get(String key) {
    SelectedFiling product = null;
    try {
      product = daoSession.getSelectedFilingDao().load(key);
    } catch (Exception e) {
      makeLog(e.toString());
    }
    return product;
  }

  @Override
  public void update(SelectedFiling selectedFiling) {
    try {
      daoSession.getSelectedFilingDao().update(selectedFiling);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }


  @Override
  public void insertOrReplace(SelectedFiling selectedFiling) {
    try {
      daoSession.getSelectedFilingDao().insertOrReplace(selectedFiling);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  @Override
  public void remove(SelectedFiling selectedFiling) {
    try {
      daoSession.getSelectedFilingDao().delete(selectedFiling);
    } catch (Exception e) {
      makeLog(e.toString());
    }
  }

  private void makeLog(String message) {
    String PREFIX = "*********----->>> ";
    Log.d(TAG, PREFIX + message);
  }
}
