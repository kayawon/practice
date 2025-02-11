package com.ncs.sol.uplus.messaging.optout.contoller;

import java.lang.module.ModuleDescriptor.Builder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.sol.uplus.messaging.optout.Response;
import com.ncs.sol.uplus.messaging.optout.entity.User;
import com.ncs.sol.uplus.messaging.optout.entity.UserIdPK;
import com.ncs.sol.uplus.messaging.optout.service.OptOutCusService;

@CrossOrigin(origins = "*")
@RestController
public class OptOutCusController {

	@Autowired
	OptOutCusService service;

	/*
	 * // test용 데이터 User testUser = User.builder().userId(new
	 * UserIdPK("20241025000000", "0x00000000000000")) .rejectNo("ghgh테스트12345678")
	 * .build(); UserIdPK testId = new UserIdPK("20241025000000",
	 * "0x00000000000000");
	 */

	// 유저 전체 리스트 조회
	@GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Response> user_list() throws Exception {

		/***********************************************************/
		Response response = new Response();

		try {
			response.setStatus(1);
			response.setMessage("성공");
			response.setData(service.findAllUser());
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(2);
			response.setMessage("실패");
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

	}

	// regdate로 유저 조회
	@GetMapping(value = "/users/date/{regDate}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Response> user_regDate_list(@PathVariable String regDate) throws Exception {

		/***********************************************************/
		Response response = new Response();

		try {
			response.setStatus(1);
			response.setMessage("성공");
			/* response.setData(service.findByRegDate(regDate)); */
			if (service.findByRegDate(regDate).isEmpty()) {
			    response.setMessage("유저 정보가 없습니다.");
			} else {
			    response.setData(service.findByRegDate(regDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(2);
			response.setMessage("실패");
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

	}

	// connId로 유저 조회
	@GetMapping(value = "/users/id/{connId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Response> user_connId_list(@PathVariable String connId) throws Exception {

		/***********************************************************/
		Response response = new Response();

		try {
			response.setStatus(1);
			response.setMessage("성공");
			response.setData(service.findByConnId(connId));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(2);
			response.setMessage("실패");
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

	}

	// 유저 생성
	@PostMapping(value = "/user", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Response> user_insert_action(@RequestBody User user) throws Exception {

		/***********************************************************/
		Response response = new Response();

		try {
			response.setStatus(1);
			response.setMessage("성공");
			response.setData(service.createUser(user));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(2);
			response.setMessage("실패");
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

	}

	@PutMapping(value = "/user/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Response> user_update(@PathVariable(name = "userId") UserIdPK id,
			@RequestPart(name = "user") User updateUser) throws Exception {

		updateUser.setUserId(id);

		/***********************************************************/
		Response response = new Response();

		try {
			response.setStatus(1);
			response.setMessage("성공");
			response.setData(service.updateUser(updateUser));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(2);
			response.setMessage("실패");
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

	}

}
