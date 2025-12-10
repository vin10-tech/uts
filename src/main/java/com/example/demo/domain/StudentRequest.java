package com.example.demo.domain;

import java.time.LocalDate;

public class StudentRequest {
    // 1. Ubah nama variabel agar sesuai dengan pemanggilan di Service (camelCase)
    private String fullName; 
    
    // 2. Ubah tipe data ke LocalDate agar cocok dengan Entity Student
    private LocalDate dob;   
    
    // 3. Perbaiki ejaan 'addres' menjadi 'address' dan tipe data jadi String
    private String address;  

    // --- Getter dan Setter (Wajib disesuaikan) ---

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}