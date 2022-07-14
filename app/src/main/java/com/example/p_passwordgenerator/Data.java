package com.example.p_passwordgenerator;

public class Data {
    private Integer serial;
    private String password;

    public Data(Integer serial, String password) {
        this.serial = serial;
        this.password = password;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
