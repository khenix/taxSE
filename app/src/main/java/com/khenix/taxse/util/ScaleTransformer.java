package com.khenix.taxse.util;

import android.view.View;

import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by kestrella on 9/25/17 at 1:13 PM.
 */

public class ScaleTransformer implements GalleryLayoutManager.ItemTransformer {

  @Override
  public void transformItem(GalleryLayoutManager layoutManager, View item, float fraction) {
    item.setPivotX(item.getWidth() / 2.f);
    item.setPivotY(item.getHeight() + 15);
    float scale = 1 - 0.1f * Math.abs(fraction);
    item.setScaleX(scale + 0.05f);
    item.setScaleY(scale + 0.05f);
  }
}
