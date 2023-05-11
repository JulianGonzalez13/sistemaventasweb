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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julxo
 */
public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public ClienteDTO buscar(String dni){
        ClienteDTO c= new ClienteDTO();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareCall(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDirec(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en el método buscar de la clase ClienteDAO...\n"+e.getMessage());
        }
        return c;
    }
    public List listar(){
       String sql="select * from cliente";
       List<ClienteDTO>lista= new ArrayList<>();
       try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {               
                ClienteDTO em= new ClienteDTO();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setDirec(rs.getString(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
           }
        } catch (Exception e) {
            System.out.println("Error en el método listar de la clase ClienteDAO...\n"+e.getMessage());
        }
       return lista;
    }
    public int agregar(ClienteDTO em){
        String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getDirec());
            ps.setString(4, em.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método agregar de la clase ClienteDAO...\n"+e.getMessage());
        }
        return r;
    }
    public ClienteDTO listarId(int id){
        ClienteDTO emp= new ClienteDTO();
        String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setDirec(rs.getString(4));
                emp.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en el método listarId de la clase ClienteDAO...\n"+e.getMessage());
        }
        return emp;
    }
    public int actualizar(ClienteDTO em){
        String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=?"+
                   " where IdCliente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getDirec());
            ps.setString(4, em.getEstado());
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método actualizar de la clase ClienteDAO...\n"+e.getMessage());
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from cliente where IdCliente= "+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método delete de la clase ClienteDAO...\n"+e.getMessage());
        }
    }
}
