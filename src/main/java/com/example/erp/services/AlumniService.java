package com.example.erp.services;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.Students;
import com.example.erp.dao.impl.AlumniDAOImpl;
import com.example.erp.dao.impl.StudentsDAOImpl;

public class AlumniService {
    public void alumniLogin(Alumni alumni){
        new AlumniDAOImpl().alumniLogin(alumni);
    }
}
