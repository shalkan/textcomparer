package com.example.textcomparer.entity;

import java.util.Date;

public class TextValueHistory {

  private Long id;
  private Date whenEdit;
  private Long textValueId;
  private Long textValue;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getWhenEdit() {
    return whenEdit;
  }

  public void setWhenEdit(Date whenEdit) {
    this.whenEdit = whenEdit;
  }

  public Long getTextValueId() {
    return textValueId;
  }

  public void setTextValueId(Long textValueId) {
    this.textValueId = textValueId;
  }

  public Long getTextValue() {
    return textValue;
  }

  public void setTextValue(Long textValue) {
    this.textValue = textValue;
  }
}
