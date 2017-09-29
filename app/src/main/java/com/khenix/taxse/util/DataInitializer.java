package com.khenix.taxse.util;

import com.google.gson.Gson;
import com.khenix.taxse.App;
import com.khenix.taxse.schema.Filing;
import com.khenix.taxse.schema.Provision;
import com.khenix.taxse.schema.ProvisionRequirement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class DataInitializer {
  private DataInitializer() {

  }

  public static void initializeProvisionAndRequirements() {

//    Provision _1906 = new Provision();
//    _1906.setId(1906);
//    _1906.setTitle("Application for Authority to print receipts and invoices");
//    List<String> _1906_requirements = new ArrayList<>();
//    _1906_requirements.add("Accomplished 1906");
//    _1906_requirements.add("Job order");
//    _1906_requirements.add("Last booklet of previous ATP");
//    _1906_requirements.add("Photocopy - Cert. of Registration of BIR");
//    _1906_requirements.add("Permit to loose-leaf");
//    _1906_requirements.add("Printers certificate of delivery");
//    _1906.setRequirements(new Gson().toJson(_1906_requirements));
//    App.getInstance().provision.insertOrReplace(_1906);

    // ---------------- provision 1 --------------------------
    if (App.getInstance().provisionRequirement.list().size() <= 0) {


      ProvisionRequirement _1 = new ProvisionRequirement();
      _1.setId(1);
      _1.setCompleted(false);
      _1.setName("Business permit");
      App.getInstance().provisionRequirement.insertOrReplace(_1);

      ProvisionRequirement _2 = new ProvisionRequirement();
      _2.setId(2);
      _2.setCompleted(false);
      _2.setName("NSO birth cert");
      App.getInstance().provisionRequirement.insertOrReplace(_2);

      ProvisionRequirement _3 = new ProvisionRequirement();
      _3.setId(3);
      _3.setCompleted(false);
      _3.setName("Contract/Company certificate");
      App.getInstance().provisionRequirement.insertOrReplace(_3);

      Provision _1904 = new Provision();
      _1904.setId(1904);
      _1904.setTitle("Application Form for TIN");
      List<Long> _1904_requirements = new ArrayList<>();
      _1904_requirements.add(_1.getId());
      _1904_requirements.add(_2.getId());
      _1904_requirements.add(_3.getId());
      _1904.setRequirements(new Gson().toJson(_1904_requirements));
      App.getInstance().provision.insertOrReplace(_1904);

      // ---------------- provision 2 --------------------------
      ProvisionRequirement _4 = new ProvisionRequirement();
      _4.setId(4);
      _4.setCompleted(false);
      _4.setName("Accomplished 1905");
      App.getInstance().provisionRequirement.insertOrReplace(_4);

      ProvisionRequirement _5 = new ProvisionRequirement();
      _5.setId(5);
      _5.setCompleted(false);
      _5.setName("Notice of closure (business)");
      App.getInstance().provisionRequirement.insertOrReplace(_5);

      ProvisionRequirement _6 = new ProvisionRequirement();
      _6.setId(6);
      _6.setCompleted(false);
      _6.setName("Estate tax return");
      App.getInstance().provisionRequirement.insertOrReplace(_6);

      ProvisionRequirement _7 = new ProvisionRequirement();
      _7.setId(7);
      _7.setCompleted(false);
      _7.setName("List of ending inventory of goods");
      App.getInstance().provisionRequirement.insertOrReplace(_7);

      ProvisionRequirement _8 = new ProvisionRequirement();
      _8.setId(8);
      _8.setCompleted(false);
      _8.setName("All business notices and permits");
      App.getInstance().provisionRequirement.insertOrReplace(_8);

      Provision _1905 = new Provision();
      _1905.setId(1905);
      _1905.setTitle("Application Form for Registration Update");
      List<Long> _1905_requirements = new ArrayList<>();
      _1905_requirements.add(_4.getId());
      _1905_requirements.add(_5.getId());
      _1905_requirements.add(_6.getId());
      _1905_requirements.add(_7.getId());
      _1905_requirements.add(_8.getId());
      _1905.setRequirements(new Gson().toJson(_1905_requirements));
      App.getInstance().provision.insertOrReplace(_1905);

    }


  }

  public static void initializeFiling() {
    if (App.getInstance().filing.list().size() <= 0) {

      App.getInstance().filing.insertOrReplace(
          new Filing("1601-E", "Monthly Withholding Tax on Credible Income (Expanded)"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1601-C", "Monthly Withholding Tax on Compensation"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1604-CF", "Annual Withholding Summary Report on Compensation"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1604-E", "Annual Withholding Summary Report on Credible Income"));

      App.getInstance().filing.insertOrReplace(
          new Filing("2551-M", "Monthly Percentage Tax Return"));

      App.getInstance().filing.insertOrReplace(
          new Filing("2550-M", "Monthly VAT Declaration"));

      App.getInstance().filing.insertOrReplace(
          new Filing("2550-Q", "Quarterly VAT Return"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1701-Q", "Quarterly Income Tax Return"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1701", "Annual Income Tax Return"));

      App.getInstance().filing.insertOrReplace(
          new Filing("0605", "Annual Registration Fee"));

      App.getInstance().filing.insertOrReplace(
          new Filing("1901", "Application for Registration"));
    }
  }

  public static List<String> fetchMonths() {
    List<String> months = new ArrayList<>();
    months.add("Jan");
    months.add("Feb");
    months.add("Mar");
    months.add("Apr");
    months.add("May");
    months.add("Jun");
    months.add("Jul");
    months.add("Aug");
    months.add("Sep");
    months.add("Oct");
    months.add("Nov");
    months.add("Dec");
    return months;
  }

}
