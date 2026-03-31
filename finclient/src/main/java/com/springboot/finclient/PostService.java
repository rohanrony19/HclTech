package com.springboot.finclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements DemoClient{

	@Autowired
	DemoClient demoClient;
	
	@Override
	public String getPost() {
		return demoClient.getPost();
	}
}
