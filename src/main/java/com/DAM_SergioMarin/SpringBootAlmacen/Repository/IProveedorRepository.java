package com.DAM_SergioMarin.SpringBootAlmacen.Repository;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository extends JpaRepository<ProveedorModel, Long>{
}