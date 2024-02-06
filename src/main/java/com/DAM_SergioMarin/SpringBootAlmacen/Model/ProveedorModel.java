package com.DAM_SergioMarin.SpringBootAlmacen.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedor")
public class ProveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column(length = 9)
    private String telefono;

    @Column
    private String email;
    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
