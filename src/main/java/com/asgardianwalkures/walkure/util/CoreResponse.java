package com.asgardianwalkures.walkure.util;

import lombok.Data;

import java.util.Date;

@Data
public class CoreResponse {
  private Object payload;
  private String message;
  private Date date;

  public CoreResponse(Object payload) {
    this(payload, null);
  }

  public CoreResponse(Object payload, String message) {
    this.message = message;
    this.payload = payload;
    this.date = new Date();
  }
}
