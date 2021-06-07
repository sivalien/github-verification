package com.example.githubclient.model.databasemodels;

public class Student {
    private int student_ID;
    private String firstName;
    private String lastName;
    private String login;


    public Student(int student_id, String firstName, String lastName, String login) {
        student_ID = student_id;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
