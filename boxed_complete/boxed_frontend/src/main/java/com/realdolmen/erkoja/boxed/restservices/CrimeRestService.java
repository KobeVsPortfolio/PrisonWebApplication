
package com.realdolmen.erkoja.boxed.restservices;

import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.facades.CrimeFacade;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("crime")
public class CrimeRestService {
    
    @Inject CrimeFacade crimeFacade;
    
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCells(){
        List<CrimeDto> crimes = crimeFacade.findAll();
        return Response.status(Response.Status.OK)
                .entity(crimes)
                .build();
    }
    
}
