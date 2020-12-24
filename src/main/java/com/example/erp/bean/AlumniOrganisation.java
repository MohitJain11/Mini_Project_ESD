package com.example.erp.bean;

import javax.persistence.*;

@Entity
@Table(name = "AlumniOrganisation")
public class AlumniOrganisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alumniOrganisationId;

    private Integer alumniId;
    private String organisationName;
    private String position;
    private String joiningDate;
    private String leavingDate;

    public AlumniOrganisation(){

    }

    public AlumniOrganisation(Integer alumniOrganisationId, Integer alumniId, String organisationName, String position, String joiningDate, String leavingDate) {
        this.alumniOrganisationId = alumniOrganisationId;
        this.alumniId = alumniId;
        this.organisationName = organisationName;
        this.position = position;
        this.joiningDate = joiningDate;
        this.leavingDate = leavingDate;
    }

    public Integer getAlumniOrganisationId() {
        return alumniOrganisationId;
    }

    public void setAlumniOrganisationId(Integer alumniOrganisationId) {
        this.alumniOrganisationId = alumniOrganisationId;
    }

    public Integer getAlumniId() {
        return alumniId;
    }

    public void setAlumniId(Integer alumniId) {
        this.alumniId = alumniId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }
}
