package ajax.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AJAXController {
	
	@Autowired
	private AJAXDAO dao;
	@Autowired
	private MailSender ms;

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		
		
		return new ResponseEntity<List<User>>(dao.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public @ResponseBody String sendMail(@RequestParam("message") String message, @RequestParam("email") String adressee) {
		
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("example@gmail.com");
		smm.setTo(adressee);
		smm.setSubject("Just a mail");
		smm.setText(message);
		ms.send(smm);
		return "Message has successfully been sent!!!";
	}
	
}
