package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.data.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Integer> {

}

