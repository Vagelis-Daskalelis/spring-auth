package gr.aueb.cf.springauthsessiion5.controller;

import gr.aueb.cf.springauthsessiion5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsessiion5.model.Teacher;
import gr.aueb.cf.springauthsessiion5.service.ITeacherService;
import gr.aueb.cf.springauthsessiion5.service.IUserService;
import gr.aueb.cf.springauthsessiion5.service.exceptions.TeacherAlreadyExistsExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterTeacherController {

    private final IUserService userService;
    private final ITeacherService teacherService;

    @GetMapping("/teachers/register")
    public String register(Model model) {
        model.addAttribute("userForm", new RegisterTeacherDTO());
        return "register";
    }
    @PostMapping("/teachers/register")
    public String registration(@Valid @ModelAttribute("userForm") RegisterTeacherDTO dto, BindingResult bindingResult)
            throws TeacherAlreadyExistsExceptions {

        if (bindingResult.hasErrors()) { return "register";}

        try {
            Teacher createdTeacher = teacherService.registerTeacher(dto);
        }catch (TeacherAlreadyExistsExceptions e){
            throw e;
        }
        return "redirect:/login";
    }
}
