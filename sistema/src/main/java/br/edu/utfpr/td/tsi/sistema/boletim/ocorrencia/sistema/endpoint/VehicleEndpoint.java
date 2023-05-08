package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business.VehicleRules;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Component
@Path("vehicle")
public class VehicleEndpoint {

    @Autowired
    private VehicleRules vehicleRules;

    @GET
    @Path("/all")
    @Produces({"aplication/json"})
    public Response listAllVehicles() {
        List<Vehicle> vehicles = vehicleRules.readAll();
        return Response.ok((Object) vehicles).build();
    }

    @GET
    @Path("/byPlate")
    @Produces({"application/json"})
    public Response listVehiclesByPlate(@QueryParam("plate") final String plate) {
        Vehicle vehicle = vehicleRules.readByPlate(plate);
        return Response.ok((Object) vehicle).build();
    }

    @GET
    @Path("/byColor")
    @Produces({"application/json"})
    public Response listVehiclesByColor(@QueryParam("color") final String color) {
        List<Vehicle> vehicle = vehicleRules.readByColor(color);
        return Response.ok((Object) vehicle).build();
    }

    @GET
    @Path("/byType")
    @Produces({"application/json"})
    public Response listVehiclesByType(@QueryParam("type") final String type) {
        List<Vehicle> vehicle = vehicleRules.readByType(type);
        return Response.ok((Object) vehicle).build();
    }
}