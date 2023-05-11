/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloDTO.EmpleadoDTO;
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
public class EmpleadoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public EmpleadoDTO validar(String user, String dni){
        EmpleadoDTO em= new EmpleadoDTO();
        String sql="select * from empleado where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs= ps.executeQuery();
            while (rs.next()) { 
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
            System.out.println("Error en el método validar de la clase EmpleadoDAO...\n"+e.getMessage());
        }
        return em;
    }
    public List listar(){
       String sql="select * from empleado";
       List<EmpleadoDTO>lista= new ArrayList<>();
       try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {               
                EmpleadoDTO em= new EmpleadoDTO();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
           }
        } catch (Exception e) {
            System.out.println("Error en el método listar de la clase EmpleadoDAO...\n"+e.getMessage());
        }
       return lista;
    }
    public int agregar(EmpleadoDTO em){
        String sql="insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método agregar de la clase EmpleadoDAO...\n"+e.getMessage());
        }
        return r;
    }
    public EmpleadoDTO listarId(int id){
        EmpleadoDTO emp= new EmpleadoDTO();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error en el método listarId de la clase EmpleadoDAO...\n"+e.getMessage());
        }
        return emp;
    }
    public int actualizar(EmpleadoDTO em){
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=?"+
                   " where IdEmpleado=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método actualizar de la clase EmpleadoDAO...\n"+e.getMessage());
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado= "+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el método delete de la clase EmpleadoDAO...\n"+e.getMessage());
        }
        ;
    }
}
