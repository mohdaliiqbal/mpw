package pk.com.mypetworld.server.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

import pk.com.mypetworld.server.common.ErrorResponse;

@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException>
{
	Logger logger = Logger.getLogger(UnrecognizedPropertyExceptionMapper.class);

    @Override
    public Response toResponse(UnrecognizedPropertyException exception)
    {
    	logger.error(exception);
    	
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