package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business.ReportRules;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Path("boletim")
public class Endpoint {

    @Autowired
    private ReportRules reportRules;

    @GET
    @Produces({"application/json"})
    public Response listAllReports() {
        List<StolenVehicleReport> list = reportRules.readAll();
        return Response.ok((Object)list).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response build(final StolenVehicleReport bo) {
        this.reportRules.register(bo);
        return Response.ok((Object)bo).build();
    }

    @DELETE
    @Consumes({"application/json"})
    public Response delete(@QueryParam("id") final int id) {
        this.reportRules.remove(id);
        return Response.ok().build();
    }
}
