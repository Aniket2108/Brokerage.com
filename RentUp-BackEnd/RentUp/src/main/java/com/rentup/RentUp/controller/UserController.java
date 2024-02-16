package com.rentup.RentUp.controller;

import java.io.IOException;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.rentup.RentUp.dto.UserDTO;
import com.rentup.RentUp.request.UserLoginRequest;
import com.rentup.RentUp.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/users") 
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers()) ;
	}


	@PostMapping(value = "/register" )
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) throws Exception {
		System.out.println("from register"+ userDTO);
	
		UserDTO newUser = userService.addUser(userDTO);

		if (newUser != null) {
			System.out.println("Added new user"+newUser);
			return ResponseEntity.status(HttpStatus.OK).body(newUser);
			
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest loginRequest) {
		UserDTO user = userService.loginUser(loginRequest.getMobileNumber(), loginRequest.getPassword());
		System.out.println(user);
		if (user != null) {
			System.out.println(user);
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserProfile(@PathVariable Integer userId,
											   @RequestParam("userName") String userName,
											   @RequestParam("userEmail") String userEmail,
											   @RequestParam(name = "userProfilePicture",required = false) MultipartFile userProfilePicture) throws IOException {
		UserDTO userDTO = userService.updateUser(userId, userName,userEmail,userProfilePicture);
		System.out.println(userDTO);
		return ResponseEntity.ok(userDTO);

	}


	@PostMapping("/create_order")
	@ResponseBody
	public String createOrder(@RequestBody String data) throws RazorpayException {
		JSONObject jsonData = new JSONObject(data);
		int amount = jsonData.getInt("price");
		var client = new RazorpayClient("rzp_test_c3HAknCruxSgid","we0dLWDuEcKL4QyJ02kpv4NK");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount",amount*100);
		jsonObject.put("currency","INR");
		jsonObject.put("receipt","txn_235425");

		Order create = client.orders.create(jsonObject);

		return create.toString();
	}


	@GetMapping("/subscription_type/{mobileNumber}")
	public String getSubsricptionType(@PathVariable String mobileNumber){
		return userService.getSubscriptionType(mobileNumber);
	}


	@PutMapping("/subscription/{mobileNumber}/{planType}")
	public ResponseEntity<?> updateSubscription(@PathVariable String mobileNumber,@PathVariable String planType){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateSubscription(mobileNumber,planType));
	}

}
