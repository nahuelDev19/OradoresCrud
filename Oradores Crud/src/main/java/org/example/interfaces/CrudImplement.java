package org.example.interfaces;

import org.example.model.MiConexion;
import org.example.model.Orador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudImplement implements CrudInterface{

    private Connection getConnection() throws SQLException {
        return MiConexion.getInstance();
    }

    @Override
    public List listar() {
        List<Orador> listaOradores= new ArrayList<>();
        try (Connection con = MiConexion.getInstance();
             Statement stmt= getConnection().createStatement();
             ResultSet resultado = stmt.executeQuery("select * from oradores")){

            while (resultado.next()){
                Orador or = creandoOrador(resultado);

                listaOradores.add(or);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaOradores;
    }



    @Override
    public Object buscarId(Long id) {
        Orador orador = null;

        try(PreparedStatement stmt = getConnection()
                .prepareStatement("select * from oradores where id= ?")){
            stmt.setLong(1,id);
            ResultSet resul= stmt.executeQuery();

            if(resul.next()){
                orador= creandoOrador(resul);
            }

            resul.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orador;
    }

    @Override
    public void guardar(Orador o) {
        String sql;
        if (o.getId()!=null && o.getId()>0){
            sql="update oradores set nombre=?, apellido=?, tema=?, fecha=? where id=?";
        }else {
            sql="insert into oradores (nombre, apellido, tema, fecha) values (?,?,?,?)";
        }
        try(PreparedStatement stmt= getConnection().prepareStatement(sql)) {
            stmt.setString(1,o.getNombre());
            stmt.setString(2,o.getApellido());
            stmt.setString(3,o.getTema());
            stmt.setDate(4,new Date(o.getFecha().getTime()));

            if (o.getId()!=null && o.getId()>0){
                stmt.setLong(5,o.getId());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("delete from oradores where id= ?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    private static Orador creandoOrador(ResultSet resultado) throws SQLException {
        Orador or= new Orador("mateo", "carrizo", "seguridad", "2023-10-10");
        or.setId(resultado.getLong(1));
        or.setNombre(resultado.getString(2));
        or.setApellido(resultado.getNString(3));
        or.setTema(resultado.getString(4));
        or.setFecha(resultado.getDate(5));
        return or;
    }
}
