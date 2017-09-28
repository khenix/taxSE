package com.khenix.taxse;

import android.app.Application;
import android.content.Context;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.khenix.taxse.schema.DaoMaster;
import com.khenix.taxse.schema.DaoSession;
import com.khenix.taxse.sources.ProvisionImpl;
import com.khenix.taxse.sources.ProvisionInterface;
import com.khenix.taxse.sources.ProvisionRequirementImpl;
import com.khenix.taxse.sources.ProvisionRequirementInterface;
import com.khenix.taxse.sources.SelectedProvisionImpl;
import com.khenix.taxse.sources.SelectedProvisionInterface;
import com.khenix.taxse.util.DatabaseUpgradeHelper;

/**
 * Created by kestrella on 9/28/17.
 */

public class App extends Application {
  private static App appInstance = new App();

  public ProvisionInterface provision;
  public SelectedProvisionInterface selectedProvision;
  public ProvisionRequirementInterface provisionRequirement;

  public static App getInstance() {
    return appInstance;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    appInstance = this;
    DaoSession daoSession = makeDaoSession(this);
    provision = new ProvisionImpl(daoSession);
    selectedProvision = new SelectedProvisionImpl(daoSession);
    provisionRequirement = new ProvisionRequirementImpl(daoSession);

  }

  DaoSession makeDaoSession(Context context) {
    DatabaseUpgradeHelper helper = new DatabaseUpgradeHelper(context, "taxSe", null);
    MigrationHelper.DEBUG = true;
    DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
    return daoMaster.newSession();
  }
}
