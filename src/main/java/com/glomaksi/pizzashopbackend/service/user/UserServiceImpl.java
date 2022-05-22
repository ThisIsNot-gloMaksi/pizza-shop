package com.glomaksi.pizzashopbackend.service.user;

import com.glomaksi.pizzashopbackend.entity.User;
import com.glomaksi.pizzashopbackend.exception.alreadyexist.UserAlreadyExistException;
import com.glomaksi.pizzashopbackend.exception.notfound.UserNotFoundException;
import com.glomaksi.pizzashopbackend.factory.Factory;
import com.glomaksi.pizzashopbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final Factory<User> adminFactory;

    private final Factory<User> userFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           @Qualifier("adminFactory")
                           Factory<User> adminFactory,
                           @Qualifier("userFactory")
                           Factory<User> userFactory) {
        this.userRepository = userRepository;
        this.adminFactory = adminFactory;
        this.userFactory = userFactory;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> {
                    throw UserNotFoundException.createForId(id);
                }
        );
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByUsername(name)
                .orElseThrow(
                        () -> {
                            throw UserNotFoundException.createForName(name);
                        }
                );
    }

    @Override
    public User createSimpleUser(String username, String password) {
        return templateCreateUser(username, password, userFactory);
    }

    @Override
    public User createAdmin(String username, String password) {
        return templateCreateUser(username, password, adminFactory);
    }

    private User templateCreateUser(String username, String password, Factory<User> factory) {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        if (optionalUser.isEmpty()) {
            return userRepository.save(factory.createItem(username, password));
        }
        throw UserAlreadyExistException.createForUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        } else {
            throw UserNotFoundException.createForId(id);
        }
    }
}
