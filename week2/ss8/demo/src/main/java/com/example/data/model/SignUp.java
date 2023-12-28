package com.example.data.model;

import org.springframework.stereotype.Component;

import javax.validation.Validator;
import javax.validation.constraints.*;

@Component
public class SignUp   {
    @Size(min = 5,max = 45)
    @NotBlank
    private String firstName;
    @Size(min = 5,max = 45)
    @NotBlank
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "so dien thoai khong hop le")
    private String phoneNumber;

    @Min(18)
    @Max(120)
    private int age;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "nhap chua dung dinh dang abc@gmail.com")
    private String email;

    public SignUp() {
    }

    public SignUp(String firstName, String lastName, String phoneNumber, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
