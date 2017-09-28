package com.khenix.taxse.schema;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kestrella on 9/28/17.
 */

@Entity(nameInDb = "selectedProvisions")
public class SelectedProvision {
  @Id
  private long id;

  @Property(nameInDb = "title")
  private String title;

  @Property(nameInDb = "requirements")
  private String requirements;

  @Property(nameInDb = "completed")
  @NotNull
  private boolean completed;

  @Generated(hash = 1589701026)
public SelectedProvision(long id, String title, String requirements,
        boolean completed) {
    this.id = id;
    this.title = title;
    this.requirements = requirements;
    this.completed = completed;
}

@Generated(hash = 1513279892)
  public SelectedProvision() {
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

public boolean getCompleted() {
    return this.completed;
}

public void setCompleted(boolean completed) {
    this.completed = completed;
}

}