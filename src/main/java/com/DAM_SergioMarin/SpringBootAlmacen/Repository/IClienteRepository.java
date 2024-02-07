package com.DAM_SergioMarin.SpringBootAlmacen.Repository;

import com.DAM_SergioMarin.SpringBootAlmacen.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {

}
