/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloDTO.VentaDTO;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julxo
 */
public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                numeroserie=rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en el método GenerarSerie de la clase VentaDAO...\n"+e.getMessage());
        }
        return numeroserie;
    }
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en el método IdVentas de la clase VentaDAO...\n"+e.getMessage());
        }
        return idventas;
    }
    public int guardarVenta(VentaDTO ve){
        String sql="insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en el método guardarVenta de la clase VentaDAO...\n"+e.getMessage());
        }
        return r;
    }
    public int guardarDetalleVentas(VentaDTO ve){
        String sql="insert into detalle_ventas(IdVentas,IdProducto, Cantidad, PrecioVenta) values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getId());
            ps.setInt(2, ve.getIdproducto());
            ps.setInt(3, ve.getCantidad());
            ps.setDouble(4, ve.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en el método guardarDetalleVentas de la clase VentaDAO...\n"+e.getMessage());
        }
        return r;
    }
}
