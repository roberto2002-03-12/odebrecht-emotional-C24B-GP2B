package odebrecht.app.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import odebrecht.app.model.Consulta;
import odebrecht.app.model.Professional;
import odebrecht.app.model.User;
import odebrecht.app.repository.UserRepository;
import odebrecht.app.service.ConsultaServicelmpl;
import odebrecht.app.service.ProfessionalServiceImpl;


@Controller
public class MainController {
	
	@Autowired
	@Qualifier("consulta")
	ConsultaServicelmpl consultaService;
	
	@Autowired
	@Qualifier("professional")
	ProfessionalServiceImpl professionalServiceImpl;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	@RequestMapping("/consultas") 
	public String menu(Authentication auth, Model model) {
		List<Consulta> consultas = consultaService.listByUser((userRepository.findByEmail(auth.getName())).getId());
		model.addAttribute("consultas", consultas);
		return "consultas";
	}
	
	@RequestMapping("/perfil") 
	public String perfil(Authentication auth, Model model) {
		User user = userRepository.findByEmail(auth.getName());
		model.addAttribute("user", user);
		return "perfil";
	}
	
	@RequestMapping("/detalles/{id}") 
	public String detalles(@PathVariable("id") Long id, Model model) {
		Consulta consulta = consultaService.buscar(id);
		Professional profesional = professionalServiceImpl.select(consulta.getMedico_id());
		model.addAttribute("consulta", consulta);
		model.addAttribute("profesional", profesional);
		return "detalles";
	}
	
	@RequestMapping("/detallesMed/{id}") 
	public String detallesMed(@PathVariable("id") Long id, Model model) {
		Professional profesional = professionalServiceImpl.select(id);
		model.addAttribute("profesional", profesional);
		return "detallesMed";
	}
	
	@RequestMapping("/cuestionario") 
	public String cuestionario(Model model) {
		return "cuestionario";
	}
	
	@RequestMapping("/resultado") 
	public String resultado(Authentication auth, HttpServletRequest request, Model model) {
		int r1 = Integer.parseInt(request.getParameter("q1"));
		int r2 = Integer.parseInt(request.getParameter("q2"));
		int r3 = Integer.parseInt(request.getParameter("q3"));
		int r4 = Integer.parseInt(request.getParameter("q4"));
		int r5 = Integer.parseInt(request.getParameter("q5"));
		int r6 = Integer.parseInt(request.getParameter("q6"));
		int r7 = Integer.parseInt(request.getParameter("q7"));
		int r8 = Integer.parseInt(request.getParameter("q8"));
		int r9 = Integer.parseInt(request.getParameter("q9"));
		int r10 = Integer.parseInt(request.getParameter("q10"));
		int r11 = Integer.parseInt(request.getParameter("q11"));
		int r12 = Integer.parseInt(request.getParameter("q12"));
		int r13 = Integer.parseInt(request.getParameter("q13"));
		int r14 = Integer.parseInt(request.getParameter("q14"));
		int r15 = Integer.parseInt(request.getParameter("q15"));
		int total = r1+r2+r3+r4+r5+r6+r7+r8+r9+r10+r11+r12+r13+r14+r15;
		String respuesta;
		String med;
		if ( total >= 10) {
			respuesta = "Muestras un nivel alto de inteligencia emocional";
			med = "psicologo";
		} 
		else if( total >= 20 ) {
			respuesta = "Muestras un nivel medio de inteligencia emocional";
			med = "psicologo";
		} else {
			respuesta = "Muestras un nivel bajo de inteligencia emocional";
			med = "psiquiatra";
		}
		Professional profesional = professionalServiceImpl.selectByType(med);
		Long id = profesional.getId();
		Consulta consulta= new Consulta();
		consulta.setResultado(respuesta);
		consulta.setUsuario_id((userRepository.findByEmail(auth.getName())).getId());
		consulta.setMedico_id(id);
		model.addAttribute("profesional", profesional);
		model.addAttribute("consulta", consulta);
		model.addAttribute("respuesta", respuesta);
		return "resultado";
	}
	
	@RequestMapping(value="/guardarconsulta",method=RequestMethod.POST)
	public String guardar(@Validated Consulta consulta, Model model) {
		consultaService.guardar(consulta);
		return "redirect:/";
	}
}