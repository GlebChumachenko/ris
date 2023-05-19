package com.example.lab2.model;

public class Developer {

    private String fullName;
    private String position;
    private Double workExperience;
    private String coreTechnology;

    private Double salary;

    public Developer() {
    }

    public Developer(String fullName, String position, Double workExperience, String coreTechnology, Double salary) {
        this.fullName = fullName;
        this.position = position;
        this.workExperience = workExperience;
        this.coreTechnology = coreTechnology;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Double workExperience) {
        this.workExperience = workExperience;
    }

    public String isCoreTechnology() {
        return coreTechnology;
    }

    public void setCoreTechnology(String coreTechnology) {
        this.coreTechnology = coreTechnology;
    }

    public String getCoreTechnology() {
        return coreTechnology;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", workExperience=" + workExperience +
                ", coreTechnology='" + coreTechnology + '\'' +
                ", salary=" + salary +
                '}';
    }
}
