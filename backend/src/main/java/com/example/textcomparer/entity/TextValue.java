package com.example.textcomparer.entity;

import java.util.Date;
import java.util.Objects;

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

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.textValue, this.audWhen, this.audWhenCreate);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof TextValue))
      return false;

    TextValue textValue = (TextValue) obj;
    if (this.id != null && this.audWhen != null && this.audWhenCreate != null) {
      return this.id.equals(textValue.id) && this.audWhen.equals(textValue.audWhen)
          && this.audWhenCreate.equals(textValue.audWhenCreate)
          && this.textValue.equals(textValue.textValue);
    }
    else {
      return false;
    }
  }
}
