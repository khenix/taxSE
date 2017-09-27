package com.khenix.taxse.schema;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kestrella on 9/28/17.
 */
@Entity(nameInDb = "provision")
public class Provision {
  @Id
  private long id;

  @Property(nameInDb = "title")
  private String title;

  @Property(nameInDb = "requirements")
  private String requirements;

  @Generated(hash = 598780457)
  public Provision(long id, String title, String requirements) {
      this.id = id;
      this.title = title;
      this.requirements = requirements;
  }

  @Generated(hash = 44146593)
  public Provision() {
  }

  public long getId() {
      return this.id;
  }

  public void setId(long id) {
      this.id = id;
  }

  public String getTitle() {
      return this.title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getRequirements() {
      return this.requirements;
  }

  public void setRequirements(String requirements) {
      this.requirements = requirements;
  }
}
