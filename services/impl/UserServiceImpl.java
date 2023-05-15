package com.example.hospital.services.impl;

import com.example.hospital.entitites.User;
import com.example.hospital.repo.UserRepository;
import com.example.hospital.services.UserService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.Optional;

import static com.example.hospital.constants.ExceptionConstants.USER_NOT_FOUND;
import static com.example.hospital.constants.MessagesConstants.*;
import static com.example.hospital.constants.ModelConstants.EMAIL_REGEX;
import static com.example.hospital.constants.ModelConstants.PHONE_REGEX;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username))
            return null;
        User user = null;
        if (username.matches(PHONE_REGEX)) {
            LOG.debug(GETTING_USER_BY_PHONE, username);
            user = userRepository.findByPhone(username);
        } else if (username.matches(EMAIL_REGEX)) {
            LOG.debug(GETTING_USER_BY_EMAIL, username);
            user = userRepository.findByEmail(username);
            if (user != null && !user.isEmailConfirmed()) {
                throw new UsernameNotFoundException(MessageFormat.format(USER_NOT_FOUND, username));
            }
        } else {
            LOG.debug(INVALID_LOGIN, username);
        }
        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format(USER_NOT_FOUND, username));
        }
        return user;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public User getCurrentUser() {
        String username = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getPhone)
                .orElse(Strings.EMPTY);
        return getUserByPhone(username);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


}

