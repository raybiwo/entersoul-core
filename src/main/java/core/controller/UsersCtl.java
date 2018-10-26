package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.service.UsersSvc;
import core.util.CommonConstants;
import response.RestResponse;

@RestController
@RequestMapping("/users")
public class UsersCtl {

	@Autowired
	UsersSvc usersSvc;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(usersSvc.getAll());
		
		return restResponse;
	}
}
