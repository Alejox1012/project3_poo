/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.model;

/**
 *
 * @author User
 */


import java.util.ArrayList;
import java.util.List;


public abstract class Person {
    private String firstName;
    private String lastName;
    private String id;
    private String phone;
    private boolean isMember;

    // Static list to manage Person instances
    private static List<Person> personList = new ArrayList<>();

    // Constructor with parameters
    public Person(String firstName, String lastName, String id, String phone, boolean isMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.phone = phone;
        this.isMember = isMember;
    }

    // Abstract method to be implemented in subclasses
    public abstract String getDetails();

    // Method to add a new person
    public static void addPerson(Person person) {
        personList.add(person);
    }

    // Method to modify an existing person's details
    public static void modifyPerson(String id, String newFirstName, String newLastName, String newPhone, boolean newIsMember) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(newFirstName);
                person.setLastName(newLastName);
                person.setPhone(newPhone);
                person.setMember(newIsMember);
                System.out.println("Person modified successfully.");
                return;
            }
        }
        System.out.println("Person not found.");
    }

    // Method to delete a person
    public static void deletePerson(String id) {
        personList.removeIf(person -> person.getId().equals(id));
        System.out.println("Person deleted successfully.");
    }

    // Method to change membership status
    public void changeMembershipStatus(boolean newStatus) {
        this.isMember = newStatus;
    }

    // Getters and Setters
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    // toString method to display person information
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", isMember=" + isMember +
                '}';
    }
}
