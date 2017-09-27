package com.khenix.taxse.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.khenix.taxse.schema.DaoMaster;
import com.khenix.taxse.schema.ProvisionDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by kestrella on 9/28/17.
 */

public class DatabaseUpgradeHelper extends DaoMaster.OpenHelper {

  public DatabaseUpgradeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
    super(context, name, factory);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void onUpgrade(Database db, int oldVersion, int newVersion) {
    MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
      @Override
      public void onCreateAllTables(Database db, boolean ifNotExists) {
        DaoMaster.createAllTables(db, ifNotExists);
      }

      @Override
      public void onDropAllTables(Database db, boolean ifExists) {
        DaoMaster.dropAllTables(db, ifExists);
      }
    }, ProvisionDao.class);
  }

}