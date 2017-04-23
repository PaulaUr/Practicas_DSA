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

/**
 * Created by pauli on 19/04/2017.
 */
@Path("User")
public class RestUser {
    EtakemonManagerImpl etakemonManagerImpl = EtakemonManagerImpl.getInstance();

    Map<String, User> hasmap = new HashMap<String, User>();
    private int counter;

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {

        try {
            etakemonManagerImpl.AddUser(u);
            return Response.status(201).entity("User added successfully: " + u.getNombre()).build();
        }catch (Exception e){
                return Response.status(409).entity("User already exists!").build();
        }
    }

    public int getCounter() {
        return counter;
    }

    //Muestra todos los usuarios
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() throws Exception {
        //User user = new User();
        List<User> list = etakemonManagerImpl.listUserOrdenados() ;
        return list;
    }

    @Path("/modify")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ModifyUser(User user) {//@PathParam("name") String name){
        //User user = new User(0,name,null);
        try {
            etakemonManagerImpl.ModifyUser(user);
            return Response.status(201).entity("User added successfully: " + user.getNombre()).build();
        } catch (Exception e) {
            return Response.status(409).entity("User already exists!").build();
        }
    }


    @Path("/infoUser/{name}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String InfoUser(@PathParam("name") String name){

        User user = new User();
        etakemonManagerImpl.InfoUser(name);

        String mensaje= "Usuario=  "+name+ " ID="+user.getId() ;//+user.getListObjectByUser();

        return "{\""+mensaje+"\" }";
    }
    //Muestra Objetos de un solo Usuario
    @GET
    @Path("/infObjectByUser/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ObjectUser> Objects (@PathParam("name") String name) throws Exception {
          User user = new User(name);
        List<ObjectUser> list = etakemonManagerImpl.ListObjectByUser(name);
        return list;
    }




}
