package com.springboot.conditionalproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "featurey.enabled",
havingValue = "true",matchIfMissing = false
)
public class Service2 implements MessageServices{

	@Override
	public void msg() {
		System.out.println("feature y");
		
	}

}
