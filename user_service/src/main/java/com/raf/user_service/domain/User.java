package com.raf.user_service.domain;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "username", unique = true), @Index(columnList = "email", unique = true)})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(insertable = false, updatable = false)
    private String firstName;
    @Column(insertable = false, updatable = false)
    private String lastName;
    private String username;
    private String password;
    private String passportId;
    @ManyToOne(optional = false)
    private Role role;
   // @Embedded
   // private CreditCard creditCard;
    private Integer milesTravelled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

  /*  public CreditCard getCreditCard() {
        return creditCard;
    }*/

  /*  public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }*/

    public Integer getMilesTravelled() {
        return milesTravelled;
    }

    public void setMilesTravelled(Integer milesTravelled) {
        this.milesTravelled = milesTravelled;
    }

}
