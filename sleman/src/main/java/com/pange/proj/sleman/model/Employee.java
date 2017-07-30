package com.pange.proj.sleman.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@Entity
@Table(name = "slm_employee")
@GeneratePojoBuilder
public class Employee {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "username", unique = true)
  private String username;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private List<Transaction> transactions;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
