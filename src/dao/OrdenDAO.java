//DAO encargado de realizar operaciones sobre la tabla orden_servicio

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jcell_jdbc.conexion;
import modelo.Orden;

public class OrdenDAO {

    conexion cn = new conexion();
    public void insertarOrden(Orden orden){ //Metodo para insertar una orden en la base de datos 
    

        String sql =
"INSERT INTO orden_servicio(fecha_ingreso, descripcion_falla, costo_estimado, id_cliente, id_equipo, id_tecnico, id_estado) VALUES(?,?,?,?,?,?,?)";

        try (
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, orden.getFechaIngreso());
            ps.setString(2, orden.getDescripcionFalla());
            ps.setDouble(3, orden.getCostoEstimado());
            ps.setInt(4, orden.getIdCliente());
            ps.setInt(5, orden.getIdEquipo());
            ps.setInt(6, orden.getIdTecnico());
            ps.setInt(7, orden.getIdEstado());
            ps.executeUpdate();

            System.out.println("Orden registrada correctamente");

        } catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public List<Orden> listarOrdenes() { //metodo para listar todas las ordendes registradas 

    List<Orden> lista = new ArrayList<>();

    String sql = "SELECT * FROM orden_servicio";

    try (
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    ) {

        while (rs.next()) {

            Orden orden = new Orden();

            orden.setIdOrden(rs.getInt("id_orden"));
            orden.setFechaIngreso(rs.getString("fecha_ingreso"));
            orden.setDescripcionFalla(rs.getString("descripcion_falla"));
            orden.setCostoEstimado(rs.getDouble("costo_estimado"));

            orden.setIdCliente(rs.getInt("id_cliente"));
            orden.setIdEquipo(rs.getInt("id_equipo"));
            orden.setIdTecnico(rs.getInt("id_tecnico"));
            orden.setIdEstado(rs.getInt("id_estado"));

            lista.add(orden);
        }

    } catch (SQLException e) {

        System.out.println("Error: " + e.getMessage());
    }

    return lista;
}
    public void actualizarEstado(int idOrden, int nuevoEstado) { // metodo para actualizar el estado de una orden 

    String sql =
    "UPDATE orden_servicio SET id_estado = ? WHERE id_orden = ?";

    try (
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, nuevoEstado);
        ps.setInt(2, idOrden);

        ps.executeUpdate();

        System.out.println("Estado actualizado correctamente");

    } catch (SQLException e) {

        System.out.println("Error: " + e.getMessage());
    }
}
    public void eliminarOrden(int idOrden) { // metodo para eleminar una orden 

    String sql =
    "DELETE FROM orden_servicio WHERE id_orden = ?";

    try (
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, idOrden);

        ps.executeUpdate();

        System.out.println("Orden eliminada correctamente");

    } catch (SQLException e) {

        System.out.println("Error: " + e.getMessage());
    }
}
}
