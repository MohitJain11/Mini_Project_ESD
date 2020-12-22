package com.example.erp.services;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniEducation;
import com.example.erp.bean.Students;
import com.example.erp.dao.AlumniDao;
import com.example.erp.dao.StudentsDAO;
import com.example.erp.dao.impl.AlumniDAOImpl;
import com.example.erp.dao.impl.StudentsDAOImpl;

import java.util.List;

public class AlumniService {
    AlumniDao alumniDao = new AlumniDAOImpl();
    public int alumniLogin(Alumni alumni){
        return alumniDao.alumniLogin(alumni);
    }

    public void addEducation(AlumniEducation alumniEducation){
        new AlumniDAOImpl().addEducation(alumniEducation);
    }

    public AlumniEducation getEducationById(Integer id, Integer alumniId){
        return alumniDao.getEducationById(id, alumniId);
    }

    public void updateEducation(AlumniEducation alumniEducation){
        new AlumniDAOImpl().updateEducation(alumniEducation);
    }

    public void deleteEducation(AlumniEducation alumniEducation){
        new AlumniDAOImpl().deleteEducation(alumniEducation);
    }


    public List<AlumniEducation> getEducationDetails(Integer id){
        return alumniDao.getEducationDetails(id);
    }
}
