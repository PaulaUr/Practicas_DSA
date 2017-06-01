package edu.upc;

import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 15/03/2017.
 */
public abstract class DDBB<E>{

    //conexion con base de datos
    public Connection getConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "25098866");
            System.out.println("Conexión exitoso");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return conn;
    }

    StringBuffer query = new StringBuffer();
    StringBuffer query1 = new StringBuffer();


    public void insert() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Connection con = getConnection();
        query.append("INSERT INTO ").append(this.getClass().getSimpleName() + " ");
        query1.append(") VALUES (");

        query.append("(");

        Field[] campos = this.getClass().getDeclaredFields();//Obtengo instancia x cada campo Declarado de la clase
        int i = 0;
        for (Field f : campos) {
            //System.out.println(f.getName()); //los printo para ver que sean ellos

            if (i == campos.length - 1) { //para que no se printe la ultima coma
                query.append(f.getName());
                query1.append("?)");
            } else {
                query.append(f.getName()).append(",");
                query1.append("?,");
            }
            i++;
        }
        query.append(query1);
        System.out.println(query);

        try {
            PreparedStatement pstm = con.prepareStatement(query.toString());
            addClassFieldParams(pstm);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addClassFieldParams(PreparedStatement pstm) throws InvocationTargetException, IllegalAccessException {

        Field[] campos = this.getClass().getDeclaredFields();//Obtengo instancia x cada campo Declarado de la clase
        int i = 1;
        for (Field f : campos) {
            String value = getValue(f);
            try {
                pstm.setObject(i, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    private String getValue(Field f) {
        String valueInvoke = null;
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName(f.getName()));
            valueInvoke = (String) method.invoke(this, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return valueInvoke;
    }

    // name, addres, id == >  getName getDescription getId
    private String methodName(String m) {

        String mayus = m.charAt(0) + "";
        mayus = mayus.toUpperCase();
        String Mayus = m.replaceFirst(m.charAt(0) + "", mayus);
        String returnValue = ("get" + Mayus);

        return returnValue;
    }

    public void update(int id) {
        Connection con = getConnection();
        query.append("UPDATE ").append(this.getClass().getSimpleName()).append(" SET ");
        query1.append(" WHERE id=" + id);

        Field[] campos = this.getClass().getDeclaredFields();//Obtengo instancia x cada campo Declarado de la clase
        int i = 0;
        for (Field f : campos) {

            if (i == campos.length - 1) { //para que no se printe la ultima coma
                query.append(f.getName()).append("=?");
            } else {
                query.append(f.getName()).append("=?,");
            }
            i++;
        }
        query.append(query1);
        System.out.println(query);

        try {
            PreparedStatement pstm = con.prepareStatement(query.toString());
            addClassFieldParams(pstm);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void select(int id) {

        Connection con = getConnection();
        query.append("SELECT *FROM ").append(this.getClass().getSimpleName()).append(" WHERE id= "+id);

        try {
            Statement stm = con.createStatement(); //creando Statement(sin paramatetros)
            ResultSet rs = stm.executeQuery(query.toString());//ejecutando query en un ResultSet(consigue info sobre tipo y propiedades)
            ResultSetMetaData rsmd = rs.getMetaData();//da info sobre nºcolumnas,nombre y tipo a traves de getMetadata del objeto ResultSet

            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {
                        System.out.println(rsmd.getColumnLabel(i) + "= " + rs.getInt(i));
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                        System.out.println(rsmd.getColumnName(i) + "= " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) {
                        rs.next();
                        i = 0;

                    }
                } catch (Exception e) {
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection con = getConnection();

        query.append("DELETE FROM ").append(this.getClass().getSimpleName()).append(" WHERE id= " + id);

        Statement stm = null; //creando Statement(sin paramatetros)
        try {
            stm = con.createStatement();
            stm.execute(query.toString());//ejecutando query en un ResultSet(consigue info sobre tipo y propiedades)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> findAll() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<Object> out = new ArrayList<Object>();

        Connection con = getConnection();
        query.append("SELECT *FROM ").append(this.getClass().getSimpleName());
        //int counter = 1;
        try {
           // Statement stm = con.createStatement(); //creando Statement(sin paramatetros)
            PreparedStatement pstm = con.prepareStatement(query.toString());
            addClassFieldParams(pstm);
            pstm.execute();
            ResultSet rs = pstm.executeQuery();//ejecutando query en un ResultSet(consigue info sobre tipo y propiedades)
            ResultSetMetaData rsmd = rs.getMetaData();//da info sobre nºcolumnas,nombre y tipo a traves de getMetadata del objeto ResultSet

              while (rs.next()) {
                  Integer id=0;
                  String nombre=null;
                  String tipo=null;

                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {
                        //System.out.println(rsmd.getColumnLabel(i)+"= " +rs.getInt(i));
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                         nombre= rs.getString(i);
                        tipo=rs.getString(i+1);
                       // out.add(rs.getString(i));
                        //System.out.println(rsmd.getColumnName(i)+ "= " +rs.getString(i));
                    }
                    /*if (i == rsmd.getColumnCount()){
                        rs.next();
                        i = 0;
                    }*/
                    ObjectUser o = new ObjectUser(id,nombre,tipo);
                    out.add(o);
                }
              }
              //  out.add(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return out;
    }

    public List<User> Allusername() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<User> out = new ArrayList<User>();
        Connection con = getConnection();
        query.append("SELECT *FROM ").append(this.getClass().getSimpleName());
        //int counter = 1;
        try {

            // Statement stm = con.createStatement(); //creando Statement(sin paramatetros)
            PreparedStatement pstm = con.prepareStatement(query.toString());
            addClassFieldParams(pstm);
            pstm.execute();
            ResultSet rs = pstm.executeQuery();//ejecutando query en un ResultSet(consigue info sobre tipo y propiedades)
            ResultSetMetaData rsmd = rs.getMetaData();//da info sobre nºcolumnas,nombre y tipo a traves de getMetadata del objeto ResultSet

            while (rs.next()) {
                int id=0;
                String nombre=null;
                String contraseña=null;

                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {
                        id= rs.getInt(i);
                        //lista.add(rs.getInt(i));
                        //System.out.println(rsmd.getColumnLabel(i)+"= " +rs.getInt(i));
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                        //lista.add(rs.getString(i));
                        nombre = rs.getString(i);
                        contraseña = rs.getString(i);
                        //System.out.println(rsmd.getColumnName(i)+ "= " +rs.getString(i));
                    }
                  //  if (i == rsmd.getColumnCount()){
                    //    rs.next();
                      //  i = 0;
                    }
                    User u = new User(id,nombre,contraseña);

                    out.add(u);
                //}
            }
     //         out.add((User) lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return out;
    }

    protected List<Object> selectByName(String name) {

        List<Object> out = new ArrayList<Object>();
        Connection con = getConnection();
        query.append("SELECT *FROM ").append(this.getClass().getSimpleName()).append(" WHERE nombre= " + name);

      //  ArrayList<Object> lista;
        //int counter = 1;

        try {
            Statement stm = con.createStatement(); //creando Statement(sin paramatetros)
            ResultSet rs = stm.executeQuery(query.toString());//ejecutando query en un ResultSet(consigue info sobre tipo y propiedades)
            ResultSetMetaData rsmd = rs.getMetaData();//da info sobre nºcolumnas,nombre y tipo a traves de getMetadata del objeto ResultSet
        //    lista = new ArrayList<Object>();

            while (rs.next()) {
               // Object cosas = new Object();

                for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {

                    if (rsmd.getColumnTypeName(i).equals("INT")) {
          //              lista.add(rs.getInt(i));
                        out.add(rs.getInt(i));
                        //System.out.println(rsmd.getColumnLabel(i)+"= " +rs.getInt(i));
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                        //lista.add(rs.getString(i));
                        out.add(rs.getInt(i));
                        //System.out.println(rsmd.getColumnName(i)+ "= " +rs.getString(i));
                    }
                    //if (i == rsmd.getColumnCount()) {
                    //  rs.next();
                    //i = 0;
                    //}
                }
            }
            //out.add(lista);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return out;
    }
    public String selectPassSOLOPARALOGIN(String pk) {
        Connection con = getConnection(); //OBTENGO CONEXION DE LA BASE DE DATOS

        //CONSTRUYO CONSULTA
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT contraseña FROM User").append(" WHERE nombre = '" + pk+"'");
        System.out.println(consulta);
        Statement stmt = null;
        String resultado= null;
        try {
            //EJECUTO CONSULTA
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta.toString()); //Y RECOJO LOS DATOS EN rs
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) { //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    rsmd.getColumnName(1);
                    System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    resultado=rs.getString(i);
                    rs.next();

                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    //Seleccionar los objetos que tiene un usuario
    public List<String> selectObjectsUser(String pk) {
        Connection con = getConnection(); //OBTENGO CONEXION DE LA BASE DE DATOS
        List<String> milista= new ArrayList<String>();

        //CONSTRUYO CONSULTA
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT tipo FROM objectUser").append(" WHERE nombre= '" + pk+"'");
        System.out.println(consulta);
        Statement stmt = null;
        String nameEtakemon="0";
        try {
            //EJECUTO CONSULTA
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta.toString()); //Y RECOJO LOS DATOS EN rs
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                        milista.add(rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                } catch (Exception e) {
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return milista;
    }

}
//xq StringBuffer es inmutable
    /*
    * Insert
    * Update
    * Select(pk)
    * delete()
    * findAll(): List<E>
    *
    * */







