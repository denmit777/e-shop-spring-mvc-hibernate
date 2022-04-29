package homework24.service.impl.security;

import homework24.dao.UserDAO;
import homework24.model.User;
import homework24.model.security.CustomUserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final User user = userDAO.getByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        CustomUserDetails details = new CustomUserDetails(user);

        return details;
    }
}
