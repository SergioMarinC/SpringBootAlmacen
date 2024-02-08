    package com.DAM_SergioMarin.SpringBootAlmacen.Service;

    import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoModel;
    import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoRequest;
    import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProveedorModel;
    import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IProductoRepository;
    import com.DAM_SergioMarin.SpringBootAlmacen.Repository.IProveedorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.NoSuchElementException;
    import java.util.Optional;

    @Service
    public class ProductoService {
        @Autowired
        IProductoRepository productoRepository;
        @Autowired
        IProveedorRepository proveedorRepository;

        public ArrayList<ProductoModel> getProductos(){
            return (ArrayList<ProductoModel>) productoRepository.findAll();
        }

        public ProductoModel saveProducto(ProductoRequest productoRequest){
            ProductoModel producto = new ProductoModel();
            producto.setNombre(productoRequest.getNombre());
            producto.setTipo(productoRequest.getTipo());
            producto.setPrecio(productoRequest.getPrecio());
            producto.setStock(productoRequest.getStock());

            Long idProveedor = productoRequest.getId_proveedor();
            ProveedorModel proveedor = proveedorRepository.findById(idProveedor)
                    .orElseThrow(() -> new NoSuchElementException("Proveedor no encontrado con ID: " + idProveedor));

            producto.setProveedor(proveedor);

            return productoRepository.save(producto);
        }

        public Optional<ProductoModel> getById(Long id) {
            return productoRepository.findById(id);
        }

        //Intenta buscar en el repositorio por id, si no se encuentra lanza la excepción no implementada que concatena el string con el id
        public ProductoModel updateById(ProductoModel request, Long id, Long idProveedor) {
            ProductoModel producto = productoRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));

            producto.setNombre(request.getNombre());
            producto.setTipo(request.getTipo());
            producto.setPrecio(request.getPrecio());
            producto.setStock(request.getStock());

            ProveedorModel nuevoProveedor = proveedorRepository.findById(idProveedor)
                    .orElseThrow(() -> new NoSuchElementException("Proveedor no encontrado con ID: " + idProveedor));

            // Actualizar el proveedor del producto
            producto.setProveedor(nuevoProveedor);

            return productoRepository.save(producto);

        }

        public Boolean deleteProducto(Long id){
            try {
                productoRepository.deleteById(id);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
    }
