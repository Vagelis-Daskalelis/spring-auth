package gr.aueb.cf.springauthsessiion5.service;

import gr.aueb.cf.springauthsessiion5.model.User;
import gr.aueb.cf.springauthsessiion5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException("User with username " + username + " was not found"));
    }
}
