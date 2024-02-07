package com.DAM_SergioMarin.SpringBootAlmacen.Controller;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProveedorModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService  proveedorService;

    @GetMapping
    public ArrayList<ProveedorModel> getProveedores(){
        return this.proveedorService.getProveedores();
    }

    @PostMapping
    public ProveedorModel saveProveedor(@RequestBody ProveedorModel proveedor) {
        return this.proveedorService.saveProveedor(proveedor);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProveedorModel> getProveedorById(@PathVariable Long id){
        return this.proveedorService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ProveedorModel updateUserById(@RequestBody ProveedorModel request, @PathVariable("id") Long id){
        return  this.proveedorService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.proveedorService.deleteProveedor(id);

        if (ok){
            return "Proveedor con id " + id + " eliminado";
        } else {
            return "Error, tenemos un problema";
        }
    }
}
