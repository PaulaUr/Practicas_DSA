package edu.upc;


import edu.upc.Entity.ObjectUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("Etak")
public class RestObject {

    Map<Integer,ObjectUser> hasmap = new HashMap<Integer, ObjectUser>();
    private int counter =0;
//NO    FUNCIONAAAA
    @POST
    @Path("/add/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(ObjectUser e,@PathParam("name")String name) {

        try {
            e.insert();
            hasmap.put(counter,e);
            listEetakemon().add(e);
            counter++;

            return Response.status(201).entity("Eetakemon added successfully: " + e).build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(409).entity("Eetakemon already exists!").build();
        }
            }

    public int getCounter() {
        return counter;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ObjectUser> listEetakemon() throws Exception {
        ObjectUser e = new ObjectUser();
        List<ObjectUser> list = e.findAll();
        return list;
    }

   /* @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ObjectUser> searchByName (@PathParam("name") String name) throws Exception {

        ObjectUser e = new ObjectUser();
      //  List<ObjectUser> list = e.selectByName(name);
        return list;
    }*/
}
