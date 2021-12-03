package odebrecht.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import odebrecht.app.repository.ProfessionalRepository;
import odebrecht.app.model.Professional;

@Service("professional")
public class ProfessionalServiceImpl {

	@Autowired
	private ProfessionalRepository professionalRepository;
	
	public Professional select(Long id) {
		return professionalRepository.findById(id);
	}
	
	public List<Professional> listar(String keyword) {
		if (keyword != null) {
			return professionalRepository.listP(keyword);
		}
		return professionalRepository.findAll();
	}
	
	public Professional selectMeetingAndProfessional(Long id) {
		return professionalRepository.selectByMeeting(id);
	}
	
	public Professional selectByType(String type) {
		return professionalRepository.selectByType(type);
	}
	
}