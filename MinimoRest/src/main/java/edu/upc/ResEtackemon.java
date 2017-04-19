package edu.upc;


import edu.upc.Controlador.EtakemonManagerImpl;
import edu.upc.Entity.Etackemon;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("Etak")
public class ResEtackemon {
    EtakemonManagerImpl etakemonManagerImpl = EtakemonManagerImpl.getInstance();

    Map<Integer,Etackemon> hasmap = new HashMap<Integer, Etackemon>();
    private int counter =0;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(Etackemon e) {
        User u = new User();
        etakemonManagerImpl.AddEtackemon(u.getId(),e.getNombre(),e.getTipo());

        hasmap.put(u.getNombre(),u);
        counter++;
        String mensaje= "Usuario añadido";
        return "{\"mensaje\": \""+mensaje+"\" }";

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
