package com.ass2.assignment_2.models;

import jakarta.persistence.*;


@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    
    private String name;
    private String last_name;
    private int height;
    private int weight;
    private String hair_color;
    private float GPA;
    
    public Student() {
    }

    
    public Student(int sid, String name, String last_name, int height, int weight, String hair_color, float gPA) {
        this.sid = sid;
        this.name = name;
        this.last_name = last_name;
        this.height = height;
        this.weight = weight;
        this.hair_color = hair_color;
        GPA = gPA;
    }


    public void setSid(int sid) {
        this.sid = sid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    public void setGPA(float gPA) {
        GPA = gPA;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }
    public String getLast_name() {
        return last_name;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }
    public String getHair_color() {
        return hair_color;
    }
    public float getGPA() {
        return GPA;
    }

}
