package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.UserData;
import com.rijai.omt.omtserver.repository.UserRepository;
import com.rijai.omt.omtserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserData create(UserData userData) {
        return  userRepository.save(userData);
    }

    @Override
    public List<UserData> getUsers() {

        List<UserData> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public UserData get(int userId) {
        Optional<UserData> userData = userRepository.findById(userId);
        if(userData.isEmpty()) {
            return null;
        }
        else
            return userData.get();
    }

    @Override
    public UserData update(UserData userData) {
        return userRepository.save(userData);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }
}
