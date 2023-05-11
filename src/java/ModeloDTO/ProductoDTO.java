/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDTO;

/**
 *
 * @author julxo
 */
public class ProductoDTO {
    int id;
    String nom, precio, stock, estado;

    public ProductoDTO() {
    }

    public ProductoDTO(int id, String nom, String precio, String stock, String estado) {
        this.id = id;
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return "Id: " + id +
                "\nNombre: " + nom +
                "\nPrecio: " + precio +
                "\nStock: " + stock +
                "\nEstado: " + estado;
    }
    
}
