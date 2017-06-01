package edu.upc;


import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("Etak")
public class RestObject {

    protected List<User> info;

    List<ObjectUser> objetosUsuario = new ArrayList<ObjectUser>();
    List<Integer> infoUser = new ArrayList<Integer>();
    List<String> listaobjetos = new ArrayList<String>();

    Map<Integer,ObjectUser> hasmap = new HashMap<Integer, ObjectUser>();
    private int counter =0;
    @POST
    @Path("/add/{name}")  //FUNCIONA ****
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(ObjectUser e,@PathParam("name")String name) {

        try {
            e.insert();
            hasmap.put(counter,e);
          //  listEetakemon().add(e);
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
    @GET
    @Path("/objetos/{Username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ObjectUser> objetosUser(@PathParam("Username") String username) {
        info = new ArrayList<>();
        User user = new User();
        listaobjetos = user.selectObjectsUser(username);
        for(int i = 0; i< listaobjetos.size(); i++) {
            ObjectUser ob1 = new ObjectUser(listaobjetos.get(i));
            objetosUsuario.add(ob1);
        }
        //lista del tipo Objeto_Usuario
        return objetosUsuario;
    }


}
