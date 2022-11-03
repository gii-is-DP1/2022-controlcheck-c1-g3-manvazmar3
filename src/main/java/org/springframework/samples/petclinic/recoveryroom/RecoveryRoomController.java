package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	private static final String VIEW_RECOVERYROOMS_CREATE_FORM =
			"recoveryroom/createOrUpdateRecoveryRoomForm";
	private static final String WELCOME = "welcome";
	private RecoveryRoomService pservice;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService service) {
		this.pservice = service;
	}
	
	@GetMapping("/create")
	public String initRecoveryRoom(ModelMap map) {
		map.addAttribute("recoveryRoom", new RecoveryRoom());
		map.addAttribute("types", pservice.getAllRecoveryRoomTypes());
		return VIEW_RECOVERYROOMS_CREATE_FORM;
	}
	
	@PostMapping(path="/create")
	public String createRecoveryRoom(@Valid RecoveryRoom room, BindingResult br, ModelMap map) {
		if(!br.hasErrors()) {
			pservice.save(room);
			map.addAttribute("messagge", "RecoveryRoom successfully save");
			return WELCOME;
		} else {
			map.addAttribute("recoveryRoom", room);
			map.addAttribute("types", pservice.getAllRecoveryRoomTypes());
		}
		return VIEW_RECOVERYROOMS_CREATE_FORM;
	}
    
}
