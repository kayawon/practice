package com.ncs.sol.uplus.messaging.optout.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.sol.uplus.messaging.optout.entity.User;
import com.ncs.sol.uplus.messaging.optout.entity.UserIdPK;

@Repository
public interface OptOutCusRepository extends JpaRepository<User, UserIdPK> {

    User findByUserId(UserIdPK id);

    @Query("SELECT u FROM User u where u.id.regDate = :regDate")
    List<User> findByUserId_RegDate(@Param("regDate") String regDate);

    @Query("SELECT u FROM User u where u.id.connId = :connId")
    List<User> findByUserId_ConnId(@Param("connId") String connId);

    @Query("SELECT u FROM User u ORDER BY u.id.regDate DESC")
    Page<User> findAllUsers(Pageable pageable);

}
