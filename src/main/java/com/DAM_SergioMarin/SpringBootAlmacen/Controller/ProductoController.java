package com.DAM_SergioMarin.SpringBootAlmacen.Controller;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoRequest;
import com.DAM_SergioMarin.SpringBootAlmacen.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> getProductos(){
        return this.productoService.getProductos();
    }

    @PostMapping
    public ProductoModel saveProducto(@RequestBody ProductoRequest productoRequest) {
        return this.productoService.saveProducto(productoRequest);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> getProductoById(@PathVariable Long id){
        return this.productoService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ProductoModel updateProductoById(@RequestBody ProductoRequest request, @PathVariable("id") Long id){
        return  this.productoService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.productoService.deleteProducto(id);

        if (ok){
            return "Producto con id " + id + " eliminado";
        } else {
            return "Error, tenemos un problema";
        }
    }
}
