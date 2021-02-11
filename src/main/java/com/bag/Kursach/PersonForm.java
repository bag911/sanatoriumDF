package com.bag.Kursach;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonForm {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    @NotNull
    @Size(min=10, max=10)
    private String phone;

    @NotNull
    private String service;

    @NotNull
    private String sTime;

    @NotNull
    private String wishText;


    public PersonForm()
    {
    }

    public PersonForm(String name, String lastName,String phone,String service,String sTime, String wishText)
    {
        this.name=name;
        this.lastName=lastName;
        this.phone=phone;
        this.service=service;
        this.sTime=sTime;
        this.wishText=wishText;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }

    public String getSTime() {
        return sTime;
    }
    public void setSTime(String sTime) {
        this.sTime = sTime;
    }
    public String getWishText() {
        return wishText;
    }
    public void setWishText(String wishText) {
        this.wishText = wishText;
    }




    public String toString() {
        return "Person(Name: " + this.name + ", LastName: " + this.lastName +", phone: " + this.phone +", service: " + this.service +", sTime: " + this.sTime +", wishText: " + this.wishText + ")";
    }
}
