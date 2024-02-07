package com.DAM_SergioMarin.SpringBootAlmacen.Service;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ClienteModel;
import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public ArrayList<ClienteModel> getClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel saveCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> getById(Long id) {
        return clienteRepository.findById(id);
    }

    //Intenta buscar en el repositorio por id, si no se encuentra lanza la excepción no implementada que concatena el string con el id
    public ClienteModel updateById(ClienteModel request, Long id) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con ID: " + id));

        cliente.setNombre(request.getNombre());
        cliente.setDireccion(request.getDireccion());
        cliente.setTelefono(request.getTelefono());
        cliente.setEmail(request.getEmail());

        return clienteRepository.save(cliente);

    }

    public Boolean deleteCliente(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
