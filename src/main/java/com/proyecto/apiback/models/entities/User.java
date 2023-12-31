package com.proyecto.apiback.models.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String name;
    @Column( nullable = false)
    private String lastname;
    @Column
    private String birthDate;
    @Column
    private String institutions;
    @Column( nullable = false)
    private String academicDegree;
    @Column
    private String teachingInstitution;

    private String teachingRole;

    @Column(unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column
    @JoinTable(
            name = "user_interest",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="interest_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","interest_id"})}
    )
    @ManyToMany
    private List<Interest> interest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getInstitutions() {
        return institutions;
    }

    public void setInstitutions(String institutions) {
        this.institutions = institutions;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getTeachingInstitution() {
        return teachingInstitution;
    }

    public void setTeachingInstitution(String teachingInstitution) {
        this.teachingInstitution = teachingInstitution;
    }

    public String getTeachingRole() {
        return teachingRole;
    }

    public void setTeachingRole(String teachingRole) {
        this.teachingRole = teachingRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Interest> getInterest() {
        return interest;
    }

    public void setInterest(List<Interest> interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", institutions='" + institutions + '\'' +
                ", academicDegree='" + academicDegree + '\'' +
                ", teachingInstitution='" + teachingInstitution + '\'' +
                ", teachingRole='" + teachingRole + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", interest=" + interest +
                '}';
    }
}

