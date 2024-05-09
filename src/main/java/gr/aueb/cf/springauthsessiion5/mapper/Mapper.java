package gr.aueb.cf.springauthsessiion5.mapper;

import gr.aueb.cf.springauthsessiion5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsessiion5.model.Teacher;
import gr.aueb.cf.springauthsessiion5.model.User;

public class Mapper {

    private Mapper() {}

    public static Teacher extractTeacherFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        return new Teacher(dto.getFirstname(), dto.getLastname(), true);
    }

    public static User extractUserFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        User user = User.NEW_TEACHER(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }


}
