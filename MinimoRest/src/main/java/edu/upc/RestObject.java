package edu.upc;


import edu.upc.Controlador.EtakemonManagerImpl;
import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("Etak")
public class RestObject {
    EtakemonManagerImpl etakemonManagerImpl = EtakemonManagerImpl.getInstance();

    Map<Integer,ObjectUser> hasmap = new HashMap<Integer, ObjectUser>();
    private int counter =0;

    @POST
    @Path("/add/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(ObjectUser objectUser, @PathParam("name") String name) {
        User user= new User(name);
        try {
            etakemonManagerImpl.AddEtackemon(user, objectUser);
            return Response.status(201).entity("Etakemon added successfully: " + objectUser.getNombre()).build();
        }catch (Exception e1){
            return Response.status(409).entity("User already exists!").build();
        }

    }
    public int getCounter() {
        return counter;
    }

//MUestra a todos
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ObjectUser> listEetakemon() throws Exception {
      //  User user = new User();
        List<ObjectUser> list = etakemonManagerImpl.AllObject();
        return list;
    }

    }

