package com.example.textcomparer.entity;

import java.util.Date;

public class TextValue {

  private Long id;
  private String textValue;
  private Date audWhen;
  private Date audWhenCreate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTextValue() {
    return textValue;
  }

  public void setTextValue(String textValue) {
    this.textValue = textValue;
  }

  public Date getAudWhen() {
    return audWhen;
  }

  public void setAudWhen(Date audWhen) {
    this.audWhen = audWhen;
  }

  public Date getAudWhenCreate() {
    return audWhenCreate;
  }

  public void setAudWhenCreate(Date audWhenCreate) {
    this.audWhenCreate = audWhenCreate;
  }
}
