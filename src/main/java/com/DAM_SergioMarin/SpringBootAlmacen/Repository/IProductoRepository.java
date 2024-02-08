package com.DAM_SergioMarin.SpringBootAlmacen.Repository;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoModel, Long> {
}
