/**
 * 
 */
package ae.com.ali.poc.jjs.service.impl;

import org.springframework.stereotype.Service;

import ae.com.ali.poc.jjs.service.api.GreetingService;

/**
 * @author Ali
 *
 */
@Service
public class GreetingServiceImpl implements GreetingService {

	/* (non-Javadoc)
	 * @see ae.com.ali.poc.jjs.service.api.GreetingService#sayHello()
	 */
	
	@Override	
	public String sayHello() {

		return "Hello World";
	}

}
