package com.ncs.sol.uplus.messaging.optout.contoller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.sol.uplus.messaging.optout.entity.User;
import com.ncs.sol.uplus.messaging.optout.entity.UserIdPK;
import com.ncs.sol.uplus.messaging.optout.service.OptOutCusService;

@CrossOrigin(origins = "*")
@RestController
public class OptOutCusController {
	
	User testUser = User.builder()
            .userId(new UserIdPK(/* userId 값 */))
            .dinsNo("12345")
            .aniNo("67890")
            .rejectNo("111213")
            .authCode("authCode123")
            .secretKey("secretKey")
            .aniHash("aniHash")
            .rejectHash("rejectHash")
            .build();

	@Autowired
	OptOutCusService service;

	// 유저 생성
	@PostMapping(value = "/user", produces = "application/json;charset=UTF-8")
	public Map user_insert_action(@RequestBody User testUser) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "성공";
		List<User> data = new ArrayList<>();

		/****************************************************/
		try {
			User createUser = service.createUser(testUser);
			data.add(createUser);

		} catch (Exception e) {
			e.printStackTrace();
			status = 2;
			msg = "유저 생성 실패";
		}
		/****************************************************/
		resultMap.put("status", status);
		resultMap.put(msg, msg);
		resultMap.put("data", data);
		return resultMap;

	}

}
