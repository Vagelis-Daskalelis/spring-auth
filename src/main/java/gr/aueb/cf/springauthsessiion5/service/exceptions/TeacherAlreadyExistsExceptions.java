package gr.aueb.cf.springauthsessiion5.service.exceptions;

import java.io.Serial;

public class TeacherAlreadyExistsExceptions extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public TeacherAlreadyExistsExceptions(String username) {
        super("Teacher with username: " + username + " already exists");
    }
}
