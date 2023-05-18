/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloDTO.*;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julxo
 */
public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public ProductoDTO buscar(int id){
        ProductoDTO p= new ProductoDTO();
        String sql="select * from producto where IdProducto="+id;
        try {
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getString(3));
                p.setStock(rs.getString(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en el método buscar de la clase ProductoDAO...\n"+e.getMessage());
        }
        return p;
    }
    public int actualizarstock(int id, int stock){
        String sql="update producto set Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error en el método actualizarstock de la clase ProductoDAO...\n"+e.getMessage());
        }
        return r;
    }
    public List listar(){
       String sql="select * from producto";
       List<ProductoDTO>lista= new ArrayList<>();
       try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {               
                ProductoDTO em= new ProductoDTO();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));
                em.setPrecio(rs.getString(3));
                em.setStock(rs.getString(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
           }
        } catch (SQLException e) {
            System.out.println("Error en el método listar de la clase ProductoDAO...\n"+e.getMessage());
        }
       return lista;
    }
    public int agregar(ProductoDTO em){
        String sql="insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setString(2, em.getPrecio());
            ps.setString(3, em.getStock());
            ps.setString(4, em.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en el método agregar de la clase ProductoDAO...\n"+e.getMessage());
        }
        return r;
    }
    public ProductoDTO listarId(int id){
        ProductoDTO emp= new ProductoDTO();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt(1));
                emp.setNom(rs.getString(2));
                emp.setPrecio(rs.getString(3));
                emp.setStock(rs.getString(4));
                emp.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error en el método listarId de la clase ProductoDAO...\n"+e.getMessage());
        }
        return emp;
    }
    public int actualizar(ProductoDTO em){
        String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=?"+
                   " where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setString(2, em.getPrecio());
            ps.setString(3, em.getStock());
            ps.setString(4, em.getEstado());
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en el método actualizar de la clase ProductoDAO...\n"+e.getMessage());
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto= "+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en el método delete de la clase ProductoDAO...\n"+e.getMessage());
        }
        
    }
}
