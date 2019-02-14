
package com.realdolmen.erkoja.boxed.restservices;

import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.facades.JobFacade;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("job")
public class JobRestService {
    
    @Inject JobFacade jobFacade;
    
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCells(){
        List<JobDto> jobs = jobFacade.findAll();
        return Response.status(Response.Status.OK)
                .entity(jobs)
                .build();
    }
    
}