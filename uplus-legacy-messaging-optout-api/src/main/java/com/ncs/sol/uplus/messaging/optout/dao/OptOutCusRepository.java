package com.ncs.sol.uplus.messaging.optout.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.sol.uplus.messaging.optout.entity.User;
import com.ncs.sol.uplus.messaging.optout.entity.UserIdPK;

@Repository
public interface OptOutCusRepository extends JpaRepository<User, UserIdPK> {

	
	User findByUserId(UserIdPK id);
	
	List<User> findByUserId_RegDate(String regDate);
	
	List<User> findByUserId_ConnId(String connId);

}
