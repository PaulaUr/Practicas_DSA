package edu.upc;

import edu.upc.Entity.Etackemon;
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

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() throws Exception {
        User user = new User();
        List<User> list = user.findAll();
        return list;
    }

    @Path("/modify")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String ModifyUser(User user){
    user.update(Integer.parseInt(user.getId()));

        //hasmap.put(counter,user);
        String mensaje= "Usuario modificado "+user.getNombre();
        return "{\"mensaje\": \""+mensaje+"\" }";
    }





}
