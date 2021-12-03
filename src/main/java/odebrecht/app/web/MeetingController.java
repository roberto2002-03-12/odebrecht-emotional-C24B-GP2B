package odebrecht.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

import odebrecht.app.model.Meeting;
import odebrecht.app.model.Professional;
import odebrecht.app.model.User;
import odebrecht.app.repository.UserRepository;
import odebrecht.app.service.MeetingServiceImpl;
import odebrecht.app.service.ProfessionalServiceImpl;
import odebrecht.app.service.UserServiceImpl;

@Controller
public class MeetingController {
	
	@Autowired
	@Qualifier("meeting")
	MeetingServiceImpl meetingServiceImpl;
	
	@Autowired
	@Qualifier("professional")
	ProfessionalServiceImpl professionalServiceImpl;
	
	@Autowired
	@Qualifier("user")
	UserServiceImpl userServiceImpl;
	
	@Autowired
	UserRepository userRepository;
	
	//seleccionar cita
	@GetMapping("/cita/{id}")
	public String oneMeeting(@PathVariable("id") Long id, Model model) {
		Professional professional = professionalServiceImpl.selectMeetingAndProfessional(id);
		Meeting meeting = meetingServiceImpl.select(id);
		model.addAttribute("meeting", meeting);
		model.addAttribute("professional", professional);
		return "cita_seleccionada";
	}
	
	//enviar a formulario para citar
	@GetMapping("/citar/{id}")
	public String citar(@PathVariable("id") Long id, Authentication auth, Model model) {
		Meeting meeting = new Meeting();
		Professional professional = professionalServiceImpl.select(id);
		User user = userServiceImpl.select((userRepository.findByEmail(auth.getName())).getId());
		model.addAttribute("user", user);
		model.addAttribute("professional", professional);
		model.addAttribute("meeting", meeting);
		return "cita_formulario";
	}
	
	//crear cita
	@RequestMapping(value="/citar/guardar", method=RequestMethod.POST)
	public String crearCita(@Validated Meeting meeting) {
		meetingServiceImpl.save(meeting);
		return "redirect:/";
	}
	
	//listado de citas
	@RequestMapping("/citas")
	public String citas(Authentication auth, Model model) {
		List<Meeting> citas = meetingServiceImpl.listMeeting((userRepository.findByEmail(auth.getName())).getId());
		model.addAttribute("meetings", citas);
		return "cita_lista";
	}
}