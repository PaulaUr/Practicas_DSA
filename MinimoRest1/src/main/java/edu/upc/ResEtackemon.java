package edu.upc;


import edu.upc.Entity.Etackemon;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("Etak")
public class ResEtackemon {

    Map<Integer,Etackemon> hasmap = new HashMap<Integer, Etackemon>();
    private int counter =0;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(Etackemon e) {

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
    public List<Etackemon> listEetakemon() throws Exception {
        Etackemon e = new Etackemon();
        List<Etackemon> list = e.findAll();
        return list;
    }

   /* @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etackemon> searchByName (@PathParam("name") String name) throws Exception {

        Etackemon e = new Etackemon();
      //  List<Etackemon> list = e.selectByName(name);
        return list;
    }*/
}
