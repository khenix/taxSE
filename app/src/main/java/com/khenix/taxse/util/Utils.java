package com.khenix.taxse.util;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kestrella on 9/29/17.
 */

public class Utils {
  private Utils() {

  }

  public static <T> T parseGeneric(String jsonString, Class<T> clazz) {
    Gson gson = new Gson();
    return gson.fromJson(jsonString, clazz);
  }

  public static <T> List<T> parseGenericList(final String json, final Class<T[]> clazz) {
    final T[] jsonToObject = new Gson().fromJson(json, clazz);
    return Arrays.asList(jsonToObject);
  }
}
