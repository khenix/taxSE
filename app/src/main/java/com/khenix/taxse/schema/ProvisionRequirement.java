package com.khenix.taxse.schema;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kestrella on 9/29/17.
 */
@Entity(nameInDb = "provisionRequirement")
public class ProvisionRequirement {
  @Id
  private long id;

  @Property(nameInDb = "name")
  private String name;

  @Property(nameInDb = "completed")
  @NotNull
  private boolean completed;

  @Generated(hash = 1960595583)
  public ProvisionRequirement(long id, String name, boolean completed) {
      this.id = id;
      this.name = name;
      this.completed = completed;
  }

  @Generated(hash = 1799202753)
  public ProvisionRequirement() {
  }

  public long getId() {
      return this.id;
  }

  public void setId(long id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public boolean getCompleted() {
      return this.completed;
  }

  public void setCompleted(boolean completed) {
      this.completed = completed;
  }
}
