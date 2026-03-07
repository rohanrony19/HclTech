package com.springboot.conditionalproperty;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "featurex.enabled",
havingValue = "true",matchIfMissing = false
)
@Primary
public class MsgServiceImpl implements MessageServices{

	
	@Override
	public void msg() {
		System.out.println("feature x");
		
	}

	
}
