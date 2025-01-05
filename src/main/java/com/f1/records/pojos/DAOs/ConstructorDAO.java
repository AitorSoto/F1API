package com.f1.records.pojos.DAOs;

import javax.persistence.*;

@Entity
@Table(name = "constructors")
public class ConstructorDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructor_id")
    private int constructorId;
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;

    public ConstructorDAO() {
    }

    public ConstructorDAO(int constructorId, String constructorRef, String name, String nationality, String url) {
        this.constructorId = constructorId;
        this.constructorRef = constructorRef;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public void setConstructorRef(String constructorRef) {
        this.constructorRef = constructorRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "constructorId=" + constructorId +
                ", constructorRef='" + constructorRef + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
