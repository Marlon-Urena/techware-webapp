package com.techware.repository;

import com.techware.model.UserAccountAddress;
import com.techware.model.UserAccountAddressId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserAccountAddressRepository extends CrudRepository<UserAccountAddress, UserAccountAddressId> {
    public List<UserAccountAddress> findAllByUserAccountAddressId_UserAccountId(Integer userAccountId);

}
