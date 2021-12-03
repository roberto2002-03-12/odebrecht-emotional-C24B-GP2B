package odebrecht.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import odebrecht.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
	User findById(Long id);
	User findByEmail(String email);
}