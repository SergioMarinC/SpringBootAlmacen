package com.DAM_SergioMarin.SpringBootAlmacen.Controller;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.CompraModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Model.CompraRequest;
import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ArrayList<CompraModel> getCompras(){
        return this.compraService.getCompras();
    }

    @PostMapping
    public CompraModel saveProducto(@RequestBody CompraRequest compraRequest){
        return this.compraService.saveCompra(compraRequest);
    }

    @GetMapping(path = "/{id}")
    public Optional<CompraModel> getCompraById(@PathVariable Long id) {
        return this.compraService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public  CompraModel updateCompraById(@RequestBody CompraRequest request, @PathVariable("id") Long id){
        return this.compraService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
        boolean ok  = this.compraService.deleteCompra(id);

        if (ok){
            return "Compra con id" + id + " eliminada";
        }else {
            return "Error, tenemos un problema";
        }
    }
}
