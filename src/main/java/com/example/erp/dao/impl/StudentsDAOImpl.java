package com.example.erp.dao.impl;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentsDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StudentsDAOImpl implements StudentsDAO {
    @Override
    public void addStudent(Students student) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(student);
            System.out.println("Student created with id:" + id);

            /////Checking...
//            Query query = session.createQuery("from Students where student_id= :id");
//            query.setLong("id", 4);
//            Students students = (Students) query.uniqueResult();
//            System.out.println("Employee Name="+students.getFirst_name()+", City="+students.getEmail());

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
