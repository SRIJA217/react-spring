package controller;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Model.Role;
import Model.User;
import dto.UserDto;
import service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	public ResponseEntity<?> register(@RequestBody @Valid UserDto user){
		if(user.getUsername()!=null) {
		userService.findByUsername(user.getUsername());
			return new ResponseEntity<>(user,HttpStatus.CONFLICT);
		}
		userService.saveUser(user.convertToUser());
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("login")
	public ResponseEntity<?> login(HttpServletRequest request){
		Principal principal=request.getUserPrincipal();
		if(principal ==null || principal.getName()== null)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		User user =userService.findByUsername(principal.getName());
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
    public ResponseEntity<?> changeRole(@PathVariable String username,@PathVariable Role role)
    {
    	User user=userService.changeRole(role, username);
    	return ResponseEntity.ok(user);
    }
}
