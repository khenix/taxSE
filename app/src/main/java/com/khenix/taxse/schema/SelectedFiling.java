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

  @Property(nameInDb = "filingDates")
  private String filingDates;

  @Generated(hash = 1278653889)
public SelectedFiling(String id, String title, String filingDates) {
    this.id = id;
    this.title = title;
    this.filingDates = filingDates;
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

public String getFilingDates() {
    return this.filingDates;
}

public void setFilingDates(String filingDates) {
    this.filingDates = filingDates;
}
}