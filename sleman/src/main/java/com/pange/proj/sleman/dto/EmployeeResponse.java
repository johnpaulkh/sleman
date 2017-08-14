package com.pange.proj.sleman.dto;

import java.io.Serializable;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String username;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
