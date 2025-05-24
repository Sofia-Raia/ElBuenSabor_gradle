package org.example.configuracion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class DatabaseConnection {
    //consultas sql
    public static final String URL="jdbc:mysql://localhost:3306/pruebadb";
    public static final String USER="root";
    public static final String PASSWORD="";

    //esto es para cargar el driver
    static{
        try{
            Class.forName("com.mysql:mysql-connector-j:9.3.0");
        }catch(ClassNotFoundException e){
            throw new RuntimeException("Error no se encontro el driver MySQL");
        }
    }

//metodo para obtener una coneccion a la base de datos.
    public static Connection obtenerConexion()throws SQLException{
        if(URL==null||URL.isEmpty()||USER==null||PASSWORD==null){
            throw new SQLException("Configuracion de la base de datos incompleta o inconclusa.");
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
