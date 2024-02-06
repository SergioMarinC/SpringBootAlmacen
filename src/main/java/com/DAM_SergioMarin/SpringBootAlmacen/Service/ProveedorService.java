package com.DAM_SergioMarin.SpringBootAlmacen.Service;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProveedorModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    IProveedorRepository proveedorRepository;

    public ArrayList<ProveedorModel> getProveedores(){
        return (ArrayList<ProveedorModel>) proveedorRepository.findAll();
    }

    public ProveedorModel saveProveedor(ProveedorModel proveedor){
        return proveedorRepository.save(proveedor);
    }

    public Optional<ProveedorModel> getById(Long id) {
        return proveedorRepository.findById(id);
    }

    //Intenta buscar en el repositorio por id, si no se encuentra lanza la excepción no implementada que concatena el string con el id
    public ProveedorModel updateById(ProveedorModel request, Long id) {
        ProveedorModel proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + id));

        proveedor.setNombre(request.getNombre());
        proveedor.setDireccion(request.getDireccion());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setEmail(request.getEmail());

        return proveedorRepository.save(proveedor);

    }
}
