package org.example.model;

import java.sql.*;

public class MiConexion {

    private static String  url = "jdbc:mysql://localhost:3306/conferencias?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user= "root";
    private static String pass= "admin";
    private static Connection con;


    public static Connection getInstance() throws SQLException {
        if (con== null){
            con= DriverManager.getConnection(url,user,pass);
        }
        return con;
    }


}

