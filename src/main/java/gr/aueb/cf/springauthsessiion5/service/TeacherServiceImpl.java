package gr.aueb.cf.springauthsessiion5.service;

import gr.aueb.cf.springauthsessiion5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsessiion5.mapper.Mapper;
import gr.aueb.cf.springauthsessiion5.model.Teacher;
import gr.aueb.cf.springauthsessiion5.model.User;
import gr.aueb.cf.springauthsessiion5.repository.TeacherRepository;
import gr.aueb.cf.springauthsessiion5.repository.UserRepository;
import gr.aueb.cf.springauthsessiion5.service.exceptions.TeacherAlreadyExistsExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService{

    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;

    @Transactional
    @Override
    public Teacher registerTeacher(RegisterTeacherDTO dto) throws TeacherAlreadyExistsExceptions {
        Teacher teacher;
        User user;

        try {
            teacher = Mapper.extractTeacherFromRegisterTeacherDTO(dto);
            user = Mapper.extractUserFromRegisterTeacherDTO(dto);

            Optional<User> returnedUser = userRepository.findByUsername(dto.getUsername());
            if (returnedUser.isPresent()) throw new TeacherAlreadyExistsExceptions(dto.getUsername());

            teacher.addUser(user);
            teacherRepository.save(teacher);
            log.info("Teacher wih id " + teacher.getId() + " inserted");

        }catch (TeacherAlreadyExistsExceptions e){
            log.error(e.getMessage());
            throw e;
        }
        return teacher;
    }

    @Override
    public List<Teacher> findAllTeachers() throws Exception {
        return teacherRepository.findAll();
    }
}
