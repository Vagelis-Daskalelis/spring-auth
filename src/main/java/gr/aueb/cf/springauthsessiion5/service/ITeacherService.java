package gr.aueb.cf.springauthsessiion5.service;

import gr.aueb.cf.springauthsessiion5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsessiion5.model.Teacher;
import gr.aueb.cf.springauthsessiion5.service.exceptions.TeacherAlreadyExistsExceptions;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAllTeachers () throws Exception;
    Teacher registerTeacher(RegisterTeacherDTO dto) throws TeacherAlreadyExistsExceptions;
}
