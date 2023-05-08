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
    @Path("/all")
    @Produces({"application/json"})
    public Response listAllReports() {
        List<StolenVehicleReport> listReports = reportRules.readAll();
        return Response.ok((Object) listReports).build();
    }

    @GET
    @Path("/byId")
    @Produces({"application/json"})
    public Response listReportById(@QueryParam("id") final int id) {
        StolenVehicleReport report = reportRules.readById(id);
        return Response.ok((Object) report).build();
    }

    @GET
    @Path("/byCity")
    @Produces({"application/json"})
    public Response listReportsByCity(@QueryParam("city") final String city) {
        List<StolenVehicleReport> listReports = new ArrayList<>();
        if (city != null) {
            listReports = reportRules.readByCity(city);
        } else {
            listReports = reportRules.readAll();
        }
        return Response.ok((Object) listReports).build();
    }

    @GET
    @Path("/byDayTime")
    @Produces({"application/json"})
    public Response listReportsByDayTime(@QueryParam("dayTime") final String dayTime) {
        List<StolenVehicleReport> listReports = new ArrayList<>();
        if (dayTime != null) {
            listReports = reportRules.readByDayTime(dayTime);
        } else {
            listReports = reportRules.readAll();
        }
        return Response.ok((Object) listReports).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response build(final StolenVehicleReport bo) {
        this.reportRules.register(bo);
        return Response.ok((Object) bo).build();
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response edit(final StolenVehicleReport bo) {
        this.reportRules.update(bo);
        return Response.ok((Object) bo).build();
    }

    @DELETE
    public Response delete(@QueryParam("id") final int id) {
        this.reportRules.remove(id);
        return Response.ok().build();
    }
}
