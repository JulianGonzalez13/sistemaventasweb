/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDTO;

/**
 *
 * @author julxo
 */
public class ClienteDTO {
    int id;
    String dni, nom, direc, estado;

    public ClienteDTO() {
    }

    public ClienteDTO(int id, String dni, String nom, String direc, String estado) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.direc = direc;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
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
                "\nDNI: " + dni +
                "\nNombre: " + nom +
                "\nDirección: " + direc +
                "\nEstado: " + estado;
    }
    
}
