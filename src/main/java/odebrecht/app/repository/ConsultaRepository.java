package odebrecht.app.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import odebrecht.app.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Serializable> {
	public abstract Consulta findById(Long id);
	@Query(value="SELECT * FROM consultas where usuario_id = ?1", nativeQuery = true)
	public abstract List<Consulta> findByUsuario_id(Long usuario_id);
}
