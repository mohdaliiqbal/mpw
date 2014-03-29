package pk.com.mypetworld.server.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import pk.com.mypetworld.server.common.ErrorResponse;

import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException>
{

    @Override
    public Response toResponse(UnrecognizedPropertyException exception)
    {
    	
    	ErrorResponse error = new ErrorResponse(); //_MAPPER.readValue(responseContext.getEntityStream(), ErrorResponse.class);
	

        error.setMessage("An error occurred. Please try again. Please contact support if the problem persist.");
        error.setError(400);
       
    	
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity( error )
                .type(MediaType.APPLICATION_JSON)
                .build();
        
    }

}