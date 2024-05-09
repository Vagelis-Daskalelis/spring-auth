package gr.aueb.cf.springauthsessiion5.controller;

import gr.aueb.cf.springauthsessiion5.model.Teacher;
import gr.aueb.cf.springauthsessiion5.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeacherController {

    private final ITeacherService teacherService;

    @GetMapping("/teachers/dashboard")
    public String dashboard(Model model) throws Exception{
        List<Teacher> teachers;
        try {
            teachers = teacherService.findAllTeachers();
            model.addAttribute("teachers", teachers);

        }catch (Exception e){
            throw e;
        }
        return "/teacher/dashboard";
    }
}
