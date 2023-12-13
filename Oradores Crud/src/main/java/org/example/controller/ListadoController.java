package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.interfaces.CrudImplement;
import org.example.interfaces.CrudInterface;
import org.example.model.MiConexion;
import org.example.model.Orador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/index")
public class ListadoController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //creo la instaancia

        //CrudInterface<Orador> dao= new CrudImplement();
        CrudImplement dao= new CrudImplement();

        //creando listado Oradores
        List<Orador> listOradores= dao.listar();


        //grabando listado en el request
        req.setAttribute("listado",listOradores);


        //ir a la siguiente pagina
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);



    }


}
