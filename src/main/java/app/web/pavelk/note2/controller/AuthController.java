package app.web.pavelk.note2.controller;

import app.web.pavelk.note2.service.UserService;
import app.web.pavelk.note2.service.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserValidation());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(
            @Valid @ModelAttribute("user") UserValidation userValidation,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!userValidation.getPassword().equals(userValidation.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "Пароли не совпадают");
            return "register";
        }

        userService.createUser(userValidation);
        return "redirect:/login";
    }
}
