package com.example.erp.dao;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniEducation;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.bean.Students;

import java.util.List;

public interface AlumniDao {
    public abstract int alumniLogin(Alumni alumni);

    public abstract void addEducation(AlumniEducation alumniEducation);

    public abstract void addOrganisation(AlumniOrganisation alumniOrganisation);

    public abstract List<AlumniEducation> getEducationDetails(Integer id);

    public abstract List<AlumniOrganisation> getOrganisationDetails(Integer id);

    public abstract AlumniEducation getEducationById(Integer id, Integer alumniId);

    public abstract AlumniOrganisation getOrganisationById(Integer id, Integer alumniId);

    public abstract void updateEducation(AlumniEducation alumniEducation);

    public abstract void updateOrganisation(AlumniOrganisation alumniOrganisation);

    public abstract void deleteEducation(AlumniEducation alumniEducation);

    public abstract void deleteOrganisation(AlumniOrganisation alumniOrganisation);

}
