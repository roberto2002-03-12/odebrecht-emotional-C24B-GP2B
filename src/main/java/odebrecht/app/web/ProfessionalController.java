package odebrecht.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import odebrecht.app.model.Professional;
import odebrecht.app.service.ProfessionalServiceImpl;

@Controller
public class ProfessionalController {
	@Autowired
	@Qualifier("professional")
	ProfessionalServiceImpl professionalServiceImpl;
	
	//mostrar vista de profesionales
	
	@GetMapping("/professionals/{id}")
	public String oneProfessional(@PathVariable("id") Long id, Model model) {
		model.addAttribute("professional", professionalServiceImpl.select(id));
		return "professionalProfile";
	}
	
	@GetMapping("/professionals")
	public String home(Model model) {
		String keyword2 = "psiquiatra";
		String keyword = "psicologo";
		
		List<Professional> psiquiatra = professionalServiceImpl.listar(keyword2);
		List<Professional> psicologo = professionalServiceImpl.listar(keyword);
		
		model.addAttribute("psiquiatra", psiquiatra);
		model.addAttribute("psicologo", psicologo);
		
		return "professionals";
	}
}
