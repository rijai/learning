package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.data.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserData, Integer> {
    Optional<UserData> findByEmail(String email);
}

