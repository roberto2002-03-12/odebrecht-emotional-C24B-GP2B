package odebrecht.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import odebrecht.app.model.Consulta;
import odebrecht.app.repository.ConsultaRepository;

@Service("consulta")
public class ConsultaServicelmpl {
	@Autowired
	ConsultaRepository consultaRepository;
	
	public void guardar(Consulta consulta) {
		consultaRepository.save(consulta);
	}
	
	public Consulta buscar(Long id) {
		return consultaRepository.findById(id);
	}
	
	public List<Consulta> listByUser(Long id) {
		return consultaRepository.findByUsuario_id(id);
	}
}
