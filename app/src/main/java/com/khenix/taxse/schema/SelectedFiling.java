package com.khenix.taxse.schema;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kestrella on 9/29/17.
 */

@Entity(nameInDb = "selectedFiling")
public class SelectedFiling {
  @Id
  private String id;

  @Property(nameInDb = "title")
  private String title;

  @Generated(hash = 641203147)
  public SelectedFiling(String id, String title) {
      this.id = id;
      this.title = title;
  }

  @Generated(hash = 1226156529)
  public SelectedFiling() {
  }

  public String getId() {
      return this.id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getTitle() {
      return this.title;
  }

  public void setTitle(String title) {
      this.title = title;
  }
}