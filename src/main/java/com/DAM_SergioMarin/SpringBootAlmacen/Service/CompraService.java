package com.DAM_SergioMarin.SpringBootAlmacen.Service;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.*;
import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IClienteRepository;
import com.DAM_SergioMarin.SpringBootAlmacen.Repository.ICompraRepository;
import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    ICompraRepository compraRepository;

    @Autowired
    IClienteRepository clienteRepository;

    @Autowired
    IProductoRepository productoRepository;

    public ArrayList<CompraModel> getCompras(){
        return (ArrayList<CompraModel>) compraRepository.findAll();
    }

    public Optional<CompraModel> getById(Long id)  {
        return compraRepository.findById(id);
    }

    public CompraModel saveCompra(CompraRequest compraRequest) {
        CompraModel compra = new CompraModel();
        compra.setCantidad(compraRequest.getCantidad());
        compra.setFechaCompra(compraRequest.getFecha_compra());

        ClienteModel nuevoCliente = clienteRepository.findById(compraRequest.getId_cliente())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con ID: " + compraRequest.getId_cliente()));
        ProductoModel nuevoProducto = productoRepository.findById(compraRequest.getId_producto())
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + compraRequest.getId_producto()));

        compra.setCliente(nuevoCliente);
        compra.setProducto(nuevoProducto);

        return compraRepository.save(compra);
    }

    public CompraModel updateById(CompraRequest compraRequest, Long id){
        CompraModel compra = compraRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Compra no encontrada con ID: " + id));

        compra.setCantidad(compraRequest.getCantidad());
        compra.setFechaCompra(compraRequest.getFecha_compra());

        ClienteModel nuevoCliente = clienteRepository.findById(compraRequest.getId_cliente())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con ID: " + compraRequest.getId_cliente()));
        ProductoModel nuevoProducto = productoRepository.findById(compraRequest.getId_producto())
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + compraRequest.getId_producto()));

        compra.setCliente(nuevoCliente);
        compra.setProducto(nuevoProducto);

        return compraRepository.save(compra);

    }

    public Boolean deleteCompra(Long id){
        try {
            compraRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
