package com.DAM_SergioMarin.SpringBootAlmacen.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(length = 9, nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<CompraModel> compras = new HashSet<>();
    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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

    public Set<CompraModel> getCompras() {
        return compras;
    }

    public void setCompras(Set<CompraModel> compras) {
        this.compras = compras;
    }

    public ClienteModel(Long id_cliente, String nombre, String direccion, String telefono, String email, Set<CompraModel> compras) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.compras = compras;
    }

    public ClienteModel(){}
}