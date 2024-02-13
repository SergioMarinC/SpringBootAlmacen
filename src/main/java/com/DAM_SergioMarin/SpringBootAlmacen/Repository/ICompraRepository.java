package com.DAM_SergioMarin.SpringBootAlmacen.Repository;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<CompraModel, Long> {
}
