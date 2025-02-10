package com.ncs.sol.uplus.messaging.optout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.sol.uplus.messaging.optout.dao.OptOutCusRepository;
import com.ncs.sol.uplus.messaging.optout.entity.User;
import com.ncs.sol.uplus.messaging.optout.entity.UserIdPK;

@Service
public class OptOutCusService {

	@Autowired
	OptOutCusRepository repository;

	// 아이디로 유저찾기
	public User findByUserId(UserIdPK userId) {
		return repository.findByUserId(userId);
	}

	public List<User> findByRegDate(String String) {
		return repository.findByUserId_RegDate(String);
	}

	public List<User> findByConnId(String String) {
		return repository.findByUserId_ConnId(String);
	}

	// 모든 유저리스트 반환
	public List<User> findAllUser() {
		List<User> userList = new ArrayList<User>();
		userList = repository.findAll();
		return userList;
	}

	// 유저로 업데이트
	public User updateUser(User user) {
		return repository.save(user);

	}

	// 수신거부 유저 생성
	public User createUser(User user) {
		return repository.save(user);
	}

}
