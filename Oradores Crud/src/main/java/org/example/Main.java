package org.example;

import org.example.interfaces.CrudImplement;
import org.example.interfaces.CrudInterface;
import org.example.model.MiConexion;
import org.example.model.Orador;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try(Connection con= MiConexion.getInstance()){

            CrudInterface<Orador> repo= new CrudImplement();
            //listado.listar().forEach(System.out::println);

            //System.out.println(repo.buscarId(2L));
            //Orador o= new Orador("mateo","carrizo","seguridad",new Date());
            //repo.guardar(o);

            repo.eliminar(1L);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}