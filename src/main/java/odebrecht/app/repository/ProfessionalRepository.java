package odebrecht.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import odebrecht.app.model.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Serializable>{
	Professional findById(Long id);
	//sirve para mostrar los profesionales por un categoria predeterminado que coloque en su controlador
	//NOTA IMPORTANTE: si quieres utilizar un query este no debe utilizar el nombre de la tabla, sino
	//el nombre de la clase
	@Query("SELECT p FROM Professional p WHERE p.type LIKE %?1%")
	List <Professional> listP(String keyword);
}