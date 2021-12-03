package odebrecht.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import odebrecht.app.model.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Serializable>{
	
	Meeting findById(Long id);
	
	@Query("SELECT m FROM Meeting m WHERE m.users.id = ?1")
	List<Meeting> listByUser(Long id);
	
}