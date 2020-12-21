package com.example.erp.controller;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.Students;
import com.example.erp.services.AlumniService;
import com.example.erp.services.StudentsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

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
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }
}
