package com.example.textcomparer.entity;

import java.util.Date;
import java.util.Objects;

public class TextValueHistory {

  private Long id;
  private Date whenEdit;
  private Long textValueId;
  private String textValue;

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

  public String getTextValue() {
    return textValue;
  }

  public void setTextValue(String textValue) {
    this.textValue = textValue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.whenEdit, this.textValueId, this.textValue);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof TextValueHistory))
      return false;

    TextValueHistory textValueHistory = (TextValueHistory) obj;
    if (this.id != null && this.whenEdit != null && this.textValueId != null) {
      return this.id.equals(textValueHistory.id) && this.whenEdit.equals(textValueHistory.whenEdit)
          && this.textValueId.equals(textValueHistory.textValueId)
          && this.textValue.equals(textValueHistory.textValue);
    }
    else {
      return false;
    }
  }
}
