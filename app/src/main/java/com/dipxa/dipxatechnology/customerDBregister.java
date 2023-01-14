package com.dipxa.dipxatechnology;

public class customerDBregister {

    private Integer id;
    private String username;
    private Integer password;
    private String email;
    private Integer passwordConfirm;

    public customerDBregister(Integer id, String username, String email, Integer password, Integer passwordConfirm) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.passwordConfirm = passwordConfirm;
    }

    public customerDBregister() {
    }

    public customerDBregister(String username, String email, Integer password, Integer passwordConfirm) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.passwordConfirm = passwordConfirm;
    }

    public customerDBregister(Integer password, Integer passwordConfirm) {
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public customerDBregister(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(Integer passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return "customerDBregister{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", passwordConfirm=" + passwordConfirm +
                '}';
    }
}
