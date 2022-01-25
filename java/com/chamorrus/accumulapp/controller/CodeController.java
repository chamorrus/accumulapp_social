package com.chamorrus.accumulapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeController {

	@RequestMapping("/redeem/{code}")
	public String redeemCode(@PathVariable String code) {
		//code check (!empty && valid)
		return "OK";
	}
}
