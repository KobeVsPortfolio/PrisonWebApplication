
package com.realdolmen.erkoja.boxed.restservices;

import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.facades.CellFacade;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cell")
public class CellService {
    
    @Inject CellFacade cellFacade;
    
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCells(){
//        CellDto cellDto = new CellDto(1, "A1", 2, true);
//        List<CellDto> cellDtos = new ArrayList<>();
//        cellDtos.add(cellDto);
        List<CellDto> cellDtos = cellFacade.findAllCells();
        return Response.status(Response.Status.OK)
                .entity(cellDtos)
                .build();
    }
    
}
