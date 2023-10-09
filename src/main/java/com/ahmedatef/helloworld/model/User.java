package com.ahmedatef.helloworld.model;

import com.ahmedatef.helloworld.validation.country.ValidateCountry;
import com.ahmedatef.helloworld.validation.gender.ValidateGender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class User {
    private String id;
    @NotBlank
    @Length(min = 2, max = 25, message = "Name must be at least 2 characters and cannot exceed 25 characters.")
    private String name;
    @Email(message = "Invalid email address.")
    private String email;
    @Pattern(regexp = "^01[0-2][0-9]{8}$", message = "Invalid phone number.")
    private String mobileNumber;
//    @Pattern(regexp = "^[MF]$", message = "Gender can either be M or F.")
    @ValidateGender
    private String gender;
    @Min(value = 18, message = "You must be at least 18 years old.")
    private int age;
//    @Pattern(regexp = "^(Egypt|Saudi Arabia|United Arab Emirates|Qatar)$", message = "Invalid country. Available countries are; Egypt, Saudi Arabia, United Arab Emirates and Qatar.")
    @ValidateCountry
    private String country;

    public User(String id, String name, String email, String mobileNumber, String gender, int age, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.age = age;
        this.country = country;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobileNumber() { return mobileNumber; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getCountry() { return country; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAge(int age) { this.age = age; }
    public void setCountry(String country) { this.country = country; }
}