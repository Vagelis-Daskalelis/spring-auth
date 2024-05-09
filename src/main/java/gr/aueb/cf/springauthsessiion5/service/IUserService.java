package gr.aueb.cf.springauthsessiion5.service;

import gr.aueb.cf.springauthsessiion5.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    User getUserByUsername(String username)throws UsernameNotFoundException;
}
