package com.example.erp.dao.impl;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.Students;
import com.example.erp.dao.AlumniDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AlumniDAOImpl implements AlumniDao {
    @Override
    public int alumniLogin(Alumni alumni) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from Alumni where alumni_id= :id");
            query.setLong("id", alumni.getAlumni_id());
            Alumni alumni1 = (Alumni) query.uniqueResult();
            System.out.println("Employee Name="+alumni1.getAlumni_id()+", City="+alumni1.getAlumni_password());
            if(alumni.getAlumni_id().equals(alumni1.getAlumni_id()) && alumni.getAlumni_password().equals(alumni1.getAlumni_password())){
                Global.loginId = alumni.getAlumni_id();
                Global.password = alumni.getAlumni_password();
                return 1;
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
}
