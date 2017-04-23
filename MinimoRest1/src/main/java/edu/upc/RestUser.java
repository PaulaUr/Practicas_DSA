package edu.upc;

import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pauli on 19/04/2017.
 */
@Path("User")
public class RestUser {


    Map<Integer, User> hasmap = new HashMap<Integer, User>();
    private int counter;

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(User u) {


        try {
            u.insert();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        hasmap.put(counter, u);
            counter++;
            String mensaje= "Usuario añadido";
        return "{\"mensaje\": \""+mensaje+"\" }";

        //Response.status(201).entity("Eetakemon added: ").build();
    }

    public int getCounter() {
        return counter;
    }

    @Path("/infoUser/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String InfoUser(@PathParam("id") Integer id){

        User user = new User();
        user.getId();
        String mensaje= "Usuario=  "+user.getNombre()+ " ID="+user.getId() ;//+user.getListObjectByUser();

        return "{\""+mensaje+"\" }";
    }


    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() throws Exception {

        User user= new User();
        List<User> list = user.findAll();

        return list;
    }
//Nofunciona
    @Path("/modify/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ModifyUser(User user,@PathParam("id") Integer id){
        try {
            user.update(id);
            return Response.status(201).entity("User added successfully: " + user.getNombre()).build();
        } catch (Exception e) {
            return Response.status(409).entity("User already exists!").build();
        }
  //  user.update(Integer.parseInt(user.getId()));

    }





}
