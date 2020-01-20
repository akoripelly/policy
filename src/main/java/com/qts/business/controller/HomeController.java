/**
 * 
 */
package com.qts.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qts.business.vo.Business;

/**
 * @author mtoluchuri
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(@RequestBody Business business) {

		return "Success";
	}
}
