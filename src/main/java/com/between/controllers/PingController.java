package com.between.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody
	String ping() {
		return "pong";
	}
}
