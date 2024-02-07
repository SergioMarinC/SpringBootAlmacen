package com.DAM_SergioMarin.SpringBootAlmacen.Controller;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ClienteModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> getClientes(){
        return this.clienteService.getClientes();
    }

    @PostMapping
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente) {
        return this.clienteService.saveCliente(cliente);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> getClienteById(@PathVariable Long id){
        return this.clienteService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ClienteModel updateUserById(@RequestBody ClienteModel request, @PathVariable("id") Long id){
        return  this.clienteService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.clienteService.deleteCliente(id);

        if (ok){
            return "Cliente con id " + id + " eliminado";
        } else {
            return "Error, tenemos un problema";
        }
    }
}
