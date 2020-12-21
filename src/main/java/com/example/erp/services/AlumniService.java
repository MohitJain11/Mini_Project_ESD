package com.example.erp.services;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.Students;
import com.example.erp.dao.AlumniDao;
import com.example.erp.dao.impl.AlumniDAOImpl;
import com.example.erp.dao.impl.StudentsDAOImpl;

public class AlumniService {
    AlumniDao alumniDao = new AlumniDAOImpl();
    public int alumniLogin(Alumni alumni){
        return alumniDao.alumniLogin(alumni);
    }
}
