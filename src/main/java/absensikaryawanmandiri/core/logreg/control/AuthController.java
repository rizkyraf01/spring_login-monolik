package absensikaryawanmandiri.core.logreg.control;

import absensikaryawanmandiri.core.logreg.dto.UserDto;
import absensikaryawanmandiri.core.logreg.entity.User;
import absensikaryawanmandiri.core.logreg.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login_admin")
    public String loginForm() {
        return "login_admin";
    }

    @GetMapping("/add/admin")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "pages/forms/add_form_register_admin";
    }

    @PostMapping("/save/admin")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/dashboard/add/admin";
        }
        userService.saveUser(user);
        return "redirect:/dashboard/admin?success";
    }


}
