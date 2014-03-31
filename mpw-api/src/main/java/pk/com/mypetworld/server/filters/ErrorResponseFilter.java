package pk.com.mypetworld.server.filters;

import java.io.IOException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import pk.com.mypetworld.server.common.ErrorResponse;

@Provider
public class ErrorResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {
        // for non-200 response, deal with the custom error messages
        if ( !(responseContext.getEntity() instanceof ErrorResponse) &&   responseContext.getStatus() != Response.Status.OK.getStatusCode()) {
                // get the "real" error message
                ErrorResponse error = new ErrorResponse(); //_MAPPER.readValue(responseContext.getEntityStream(), ErrorResponse.class);
                String message = responseContext.getStatusInfo().getReasonPhrase();                		

                error.setMessage(message);
                error.setError(responseContext.getStatus());
                
                Response.Status status = Response.Status.fromStatusCode(responseContext.getStatus());
                
                
                WebApplicationException webAppException;
                switch (status) {
                    case BAD_REQUEST:
                        webAppException = new BadRequestException(Response.status(Status.BAD_REQUEST).entity(error).build() );
                        break;
                    case UNAUTHORIZED:
                        webAppException = new NotAuthorizedException(Response.status(Status.UNAUTHORIZED).entity(error).build());
                        break;
                    case FORBIDDEN:
                        webAppException = new ForbiddenException(Response.status(Status.FORBIDDEN).entity(error).build());
                        break;
                    case NOT_FOUND:
                        webAppException = new NotFoundException(Response.status(Status.NOT_FOUND).entity(error).build());
                        break;
                    case METHOD_NOT_ALLOWED:
                        webAppException = new NotAllowedException(Response.status(Status.METHOD_NOT_ALLOWED).entity(error).build());
                        break;
                    case NOT_ACCEPTABLE:
                        webAppException = new NotAcceptableException(Response.status(Status.NOT_ACCEPTABLE).entity(error).build());
                        break;
                    case UNSUPPORTED_MEDIA_TYPE:
                        webAppException = new NotSupportedException(Response.status(Status.UNSUPPORTED_MEDIA_TYPE).entity(error).build());
                        break;
                    case INTERNAL_SERVER_ERROR:
                        webAppException = new InternalServerErrorException(Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build());
                        break;
                    case SERVICE_UNAVAILABLE:
                        webAppException = new ServiceUnavailableException(Response.status(Status.SERVICE_UNAVAILABLE).entity(error).build());
                        break;
                    default:
                        webAppException = new WebApplicationException(Response.status(responseContext.getStatus()).entity(error).build());
                }

                throw webAppException;
          }
    }
}