package com.khenix.taxse.schema;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kestrella on 9/29/17.
 */
@Entity(nameInDb = "filing")
public class Filing {
  @Id
  private String id;

  @Property(nameInDb = "title")
  private String title;

  @Generated(hash = 414590844)
  public Filing(String id, String title) {
      this.id = id;
      this.title = title;
  }

  @Generated(hash = 1300761059)
  public Filing() {
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
