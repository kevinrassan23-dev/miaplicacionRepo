package org.miaplicacion.repository;

import org.miaplicacion.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anotación que declara el repositorio
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
