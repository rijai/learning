package com.rijai.omt.omtserver.transform;

import com.rijai.omt.omtserver.data.UserData;
import com.rijai.omt.omtserver.model.User;

public class UserTransform implements Transform {
    User toModel(UserData userData){
        User user = new User();
        return user;
    }

    UserData toData(User user){
        UserData userData = new UserData();
        return userData;
    }
}
