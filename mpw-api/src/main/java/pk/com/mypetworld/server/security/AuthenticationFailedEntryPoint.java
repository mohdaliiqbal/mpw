/**
 * 
 */
package pk.com.mypetworld.server.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Ali
 *
 */
@Component
public class AuthenticationFailedEntryPoint implements AuthenticationEntryPoint {
    static Logger log = Logger.getLogger(AuthenticationFailedEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("Authenticaiton failed:",authException);
        
        ErrorResponse error = new ErrorResponse();
        
        error.setError(401);
        error.setMessage("Authentication failed. Pleasee make sure you have typed correct email address and password");
        
        ObjectMapper jsonMapper = new ObjectMapper();

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(401); 
        
        PrintWriter out = response.getWriter();
        out.print(jsonMapper.writeValueAsString(error));   
    }
    
    private class ErrorResponse
    {
    	private int error;
    	private String message;
		public int getError() {
			return error;
		}
		public void setError(int error) {
			this.error = error;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
    }
    
}