
package com.realdolmen.erkoja.boxed.restservices;

import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.facades.PrisonerFacade;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("prisoner")
public class PrisonerRestService {
    
    @Inject PrisonerFacade prisonerFacade;
    
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCells(){
        List<PrisonerDto> p = prisonerFacade.findAll();
        return Response.status(Response.Status.OK)
                .entity(p)
                .build();
    }
    
}