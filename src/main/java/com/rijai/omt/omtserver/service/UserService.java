package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.UserData;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserData create(UserData userData);
    List<UserData> getUsers();
    UserData get(int userDataId);

    UserData getUserByEmail(String email);
    UserData update(UserData userData);
    void delete(int itemId);
}
