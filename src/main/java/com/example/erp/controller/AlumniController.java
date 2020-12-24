package com.example.erp.controller;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniEducation;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.bean.Students;
import com.example.erp.services.AlumniService;
import com.example.erp.services.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("alumni")
public class AlumniController {
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Alumni alumni) throws URISyntaxException {
        System.out.println(alumni.getAlumni_id());
        System.out.println(alumni.getAlumni_password());

        AlumniService alumniService = new AlumniService();
        int result = alumniService.alumniLogin(alumni);
        if(result == 1){
            StudentsService studentsService = new StudentsService();
            Global.gStudent = studentsService.getStudentDetails(Global.loginId);
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }

    @POST
    @Path("/getEducationById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEducationDetailsById(String str){
        List<String> alumniEducationList = new ArrayList<>();
        System.out.println(str);
        System.out.println("id:"+ str.charAt(6));
        int id = Integer.parseInt(""+str.charAt(6));
        System.out.println("id:"+ id);
        AlumniService alumniService = new AlumniService();
        AlumniEducation alumniEducation = alumniService.getEducationById(id, Global.loginId);
        System.out.println(alumniEducation.getAddress());
        System.out.println(alumniEducation.getDegree());
        alumniEducationList.add(alumniEducation.getDegree());
        alumniEducationList.add(alumniEducation.getCollegeName());
        alumniEducationList.add(alumniEducation.getJoiningYear());
        alumniEducationList.add(alumniEducation.getPassingYear());
        alumniEducationList.add(alumniEducation.getAddress());
        return Response.ok().entity(alumniEducationList).build();
    }

    @POST
    @Path("/getOrganisationById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOrganisationDetailsById(String str){
        List<String> alumniOrganisationList = new ArrayList<>();
        System.out.println(str);
        System.out.println("id:"+ str.charAt(6));
        int id = Integer.parseInt(""+str.charAt(6));
        System.out.println("id:"+ id);
        AlumniService alumniService = new AlumniService();
        AlumniOrganisation alumniOrganisation = alumniService.getOrganisationById(id, Global.loginId);
        System.out.println(alumniOrganisation.getOrganisationName());
        System.out.println(alumniOrganisation.getPosition());
        alumniOrganisationList.add(alumniOrganisation.getOrganisationName());
        alumniOrganisationList.add(alumniOrganisation.getPosition());
        alumniOrganisationList.add(alumniOrganisation.getJoiningDate());
        alumniOrganisationList.add(alumniOrganisation.getLeavingDate());
        return Response.ok().entity(alumniOrganisationList).build();
    }

    @POST
    @Path("/register_education")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerNewEducation(AlumniEducation alumniEducation) throws URISyntaxException {
        System.out.println(alumniEducation.getAlumniId());
        System.out.println(alumniEducation.getDegree());
        System.out.println(alumniEducation.getAddress());
        alumniEducation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.addEducation(alumniEducation);
        return Response.ok().build();
    }

    @POST
    @Path("/register_organisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerNewOrganisation(AlumniOrganisation alumniOrganisation){
        System.out.println(alumniOrganisation.getPosition());
        System.out.println(alumniOrganisation.getOrganisationName());
        alumniOrganisation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.addOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @POST
    @Path("/updateEducation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEducation(AlumniEducation alumniEducation) throws URISyntaxException {
        System.out.println(alumniEducation.getDegree());
        System.out.println(alumniEducation.getAddress());
        alumniEducation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.updateEducation(alumniEducation);
        return Response.ok().build();
    }

    @POST
    @Path("/updateOrganisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganisation(AlumniOrganisation alumniOrganisation){
        System.out.println(alumniOrganisation.getPosition());
        System.out.println(alumniOrganisation.getOrganisationName());
        alumniOrganisation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.updateOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @POST
    @Path("/deleteEducation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEducation(AlumniEducation alumniEducation) throws URISyntaxException {
        System.out.println(alumniEducation.getDegree());
        System.out.println(alumniEducation.getAddress());
        alumniEducation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.deleteEducation(alumniEducation);
        return Response.ok().build();
    }

    @POST
    @Path("/deleteOrganisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOrganisation(AlumniOrganisation alumniOrganisation) {
        System.out.println(alumniOrganisation.getPosition());
        System.out.println(alumniOrganisation.getOrganisationName());
        alumniOrganisation.setAlumniId(Global.loginId);
        AlumniService alumniService = new AlumniService();
        alumniService.deleteOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @GET
    @Path("/geteducation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentDetails() {
        List<String> educationList = new ArrayList<>();
        Integer id = Global.loginId;
        System.out.println("ID: "+ id);
        AlumniService alumniService = new AlumniService();
        List<AlumniEducation> alumniEducation = alumniService.getEducationDetails(id);
        System.out.println("Address: "+ alumniEducation.get(0).getAddress());
        System.out.println("Degree: "+ alumniEducation.get(0).getDegree());
        educationList.add(""+alumniEducation.size());
        educationList.add(Global.gStudent.getFirst_name());
        educationList.add(Global.gStudent.getLast_name());
        for (AlumniEducation education : alumniEducation) {
            educationList.add((education.getDegree()));
            educationList.add((education.getCollegeName()));
            educationList.add((education.getJoiningYear()));
            educationList.add((education.getPassingYear()));
            educationList.add((education.getAddress()));
            educationList.add((""+education.getAlumniEducationId()));
        }
        return Response.ok().entity(educationList).build();
    }

    @GET
    @Path("/getOrganisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisation() {
        List<String> organisationList = new ArrayList<>();
        Integer id = Global.loginId;
        System.out.println("ID: "+ id);
        AlumniService alumniService = new AlumniService();
        List<AlumniOrganisation> alumniOrganisations = alumniService.getOrganisationDetails(id);
        System.out.println("Address: "+ alumniOrganisations.get(0).getPosition());
        System.out.println("Degree: "+ alumniOrganisations.get(0).getOrganisationName());
        organisationList.add(""+alumniOrganisations.size());
        organisationList.add(Global.gStudent.getFirst_name());
        organisationList.add(Global.gStudent.getLast_name());
        for (AlumniOrganisation organisation : alumniOrganisations) {
            organisationList.add((organisation.getOrganisationName()));
            organisationList.add((organisation.getPosition()));
            organisationList.add((organisation.getJoiningDate()));
            organisationList.add((organisation.getLeavingDate()));
            organisationList.add((""+organisation.getAlumniOrganisationId()));
        }
        return Response.ok().entity(organisationList).build();
    }



}
