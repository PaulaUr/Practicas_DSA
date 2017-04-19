package edu.upc;

import edu.upc.Controlador.EtakemonManagerImpl;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.InvocationTargetException;
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
    public String addUser(User u) {

        //User user = new User();

        etakemonManagerImpl.AddUser(u.getId(),u.getNombre(),u.getContraseña());

        hasmap.put(u.getNombre(),u);
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
        //User user = new User();
        List<User> list = etakemonManagerImpl.listUser() ;
        return list;
    }



    @Path("/modify/{name}/{contraseña}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String ModifyUser(@PathParam("name") String name, @PathParam("contraseña") String contraseña){
        User user = new User();
        etakemonManagerImpl.ModifyUser(user,name,contraseña);

        hasmap.put(user.getNombre(),user);
        String mensaje= "Usuario modificado "+user.getNombre();
        /*for(Map.Entry<String, User> entry: hasmap.entrySet() )
        {
            User value = entry.getValue();
            String mensaje= "Usuario modificado "+value.getNombre();

        }*/
        return "{\"mensaje\": \""+mensaje+"\" }";
    }

    @Path("/infoUser/{name}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String InfoUser(@PathParam("name") String name){

        //User user = new User();
        etakemonManagerImpl.InfoUser(name);

        String mensaje= "Usuario=  "+name+ "";
        return "{\"mensaje\": \""+mensaje+"\" }";
    }




}
