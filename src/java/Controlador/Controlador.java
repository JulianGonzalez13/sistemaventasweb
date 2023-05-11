/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import ModeloDAO.*;
import ModeloDTO.*;
import config.*;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julxo
 */
public class Controlador extends HttpServlet {

    EmpleadoDTO em= new EmpleadoDTO();
    EmpleadoDAO edao= new EmpleadoDAO();
    ClienteDTO cl= new ClienteDTO();
    ClienteDAO cldao= new ClienteDAO();
    ProductoDTO pr= new ProductoDTO();
    ProductoDAO prdao= new ProductoDAO();
    int ide, idc, idp;
    VentaDTO v= new VentaDTO();
    VentaDAO vdao= new VentaDAO();
    List <VentaDTO> lista= new ArrayList<>();
    int item, cod, cant;
    String descripcion;
    double precio, subtotal, totalPagar;
    String numeroserie;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion= request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    em.setDni(request.getParameter("txtDni"));
                    em.setNom(request.getParameter("txtNombres"));
                    em.setTel(request.getParameter("txtTel"));
                    em.setEstado(request.getParameter("txtestado"));
                    em.setUser(request.getParameter("txtUsuario"));
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    EmpleadoDTO e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    em.setDni(request.getParameter("txtDni"));
                    em.setNom(request.getParameter("txtNombres"));
                    em.setTel(request.getParameter("txtTel"));
                    em.setEstado(request.getParameter("txtestado"));
                    em.setUser(request.getParameter("txtUsuario"));
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista=cldao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    cl.setDni(request.getParameter("txtDni"));
                    cl.setNom(request.getParameter("txtNombres"));
                    cl.setDirec(request.getParameter("txtDirec"));
                    cl.setEstado(request.getParameter("txtestado"));
                    cldao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    ClienteDTO e=cldao.listarId(idc);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    cl.setDni(request.getParameter("txtDni"));
                    cl.setNom(request.getParameter("txtNombres"));
                    cl.setDirec(request.getParameter("txtDirec"));
                    cl.setEstado(request.getParameter("txtestado"));
                    cl.setId(idc);
                    cldao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cldao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista=prdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    pr.setNom(request.getParameter("txtNombres"));
                    pr.setPrecio(request.getParameter("txtPrecio"));
                    pr.setStock(request.getParameter("txtStock"));
                    pr.setEstado(request.getParameter("txtestado"));
                    prdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    ProductoDTO e=prdao.listarId(ide);
                    request.setAttribute("producto", e);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    pr.setNom(request.getParameter("txtNombres"));
                    pr.setPrecio(request.getParameter("txtPrecio"));
                    pr.setStock(request.getParameter("txtStock"));
                    pr.setEstado(request.getParameter("txtestado"));
                    pr.setId(ide);
                    prdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    prdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    request.setAttribute("nserie", numeroserie);
                    String dni=request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl=cldao.buscar(dni);
                    request.setAttribute("c", cl);
                    break;
                case "BuscarProducto":
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroserie);
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    pr=prdao.listarId(id);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroserie);
                    totalPagar=0.0;
                    item+=1;
                    cod=pr.getId();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    v=new VentaDTO();
                    v.setItem(item);
                    v.setId(cod);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar+=lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);                    
                    break;
                case "GenerarVenta":
                    //Actualización del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        ProductoDTO prd=new ProductoDTO();
                        ProductoDAO ao=new ProductoDAO();
                        int cantidad= lista.get(i).getCantidad();
                        int idproducto= lista.get(i).getIdproducto();
                        prd=ao.buscar(idproducto);
                        int sac=Integer.parseInt(prd.getStock())-cantidad;
                        ao.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(1);
                    v.setNumserie(numeroserie);
                    v.setFecha("2019-06-14");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Guardar Detalle ventas
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new VentaDTO();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(v);
                    }
                    lista=new ArrayList<>();
                    break;
                default:
                    numeroserie=vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs=new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }                    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
