package com.example.jpainheritance;

public enum RecordStatus {
  ON("ON"),
  OFF("OFF");

  private final String state;

  RecordStatus(String state) {
    this.state = state;
  }
}
