package com.gestionEmpleados.backend.repository;

import com.gestionEmpleados.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //se le agrega extend jparepository ya que tomara la entidad Employee y el tipo de su id que en este caso en Long
public interface EmpleadoRepository extends JpaRepository<Employee, Long> {


}
