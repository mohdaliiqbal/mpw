package pk.com.mypetworld.server.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import pk.com.mypetworld.server.common.ErrorResponse;


/**
 * {@link AuthenticationEntryPoint} that rejects all requests with an unauthorized error message.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		ErrorResponse error = new ErrorResponse();
		error.setError(Response.Status.UNAUTHORIZED.getStatusCode());
		error.setMessage("Unauthorized: Authentication token was either missing or invalid.");
		
		//Response.status(Response.Status.UNAUTHORIZED).entity(error).build().
		response.setHeader("Status", String.valueOf(Response.Status.OK.getStatusCode()));
		response.setContentType("applicRation/json");
		PrintWriter writer = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, error);	
		
	}
}