package edu.upc;

import edu.upc.Entity.Login;
import edu.upc.Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pauli on 19/04/2017.
 */
@Path("User")
public class RestUser {


    Map<Integer, User> hasmap = new HashMap<Integer, User>();
    List<String> lista = new ArrayList<String>();
    private int counter;

    @POST
    @Path("/addUser") //FUNCIONAAAA*****************************************+
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

  /*  @POST
    @Path("/login/{nombre}/{contraseña}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String loginUser(@PathParam("nombre") String nombre,@PathParam("contraseña")String contraseña) {

        String i="2";
        User user= new User();
        String contraseñaVerdadera = user.selectPassSOLOPARALOGIN(nombre);

        String valorComparado = contraseña;
        //Contraseña correcta
        if (contraseñaVerdadera.equals(valorComparado)){
            i="0";
           // logger.info("usuario "+username +"logueado");
        }
        //Contraseña incorrecta
        if (!contraseñaVerdadera.equals(valorComparado)){
            i="1";
           // logger.warn("Intento de login con contraseña incorrecta: "+username);
        }
        return i;

    }*/
  @POST
  @Path("/login")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response loginUser(User user) {
        String nombre = user.getNombre();
      String contraseña = user.getContraseña();

     // String i="2";
      String contraseñaVerdadera = user.selectPassSOLOPARALOGIN(nombre);

      String valorComparado = contraseña;
      try {
          //Contraseña correcta
          if (contraseñaVerdadera.equals(valorComparado)) {
              return Response.status(200).entity("Log successfully").build();
          }
          if (!contraseñaVerdadera.equals(valorComparado)) {
              return Response.status(409).entity("Not loggin!").build();
          }
      }catch(Exception e) {
          e.printStackTrace();
          //Contraseña incorrecta
      }
      return Response.status(200).entity("Log successfully").build();

  }
          // logger.warn("Intento de login con contraseña incorrecta: "+username);





    @Path("/infoUser/{id}") //  NO FUNCIONA
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String InfoUser(@PathParam("id") Integer id){

        User user = new User();
        user.getId();
        String mensaje= "Usuario=  "+user.getNombre()+ " ID="+user.getId() ;//+user.getListObjectByUser();

        return "{\""+mensaje+"\" }";
    }


    @Path("/all") //FUNCIONAAAA*****************************************+
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() throws Exception {
        User user = new User();
       // List<User> userList = new ArrayList<User>();

        List<User> list = user.Allusername();
        //userList.add(new User());
       /* for(int i=0; i< list.size();i++){
            Object o = list.get(i);
            userList.add(i, (User) o);

        }*/

        return list;
    }
//Nofunciona
    @Path("/modify/{id}") //FUNCIONAAAA*****************************************+
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
  /*  @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login() {

    User user = new User();
    return user;
    }*/







}
