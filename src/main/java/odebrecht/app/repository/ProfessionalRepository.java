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
	
	@Query("SELECT p FROM Professional p WHERE p.type LIKE %?1%")
	List <Professional> listP(String keyword);
	
	@Query(value="SELECT p.* FROM professional AS p INNER JOIN meeting AS m WHERE m.id = ?1 AND m.professional_id = p.id", nativeQuery = true)
	Professional selectByMeeting(Long id);
}