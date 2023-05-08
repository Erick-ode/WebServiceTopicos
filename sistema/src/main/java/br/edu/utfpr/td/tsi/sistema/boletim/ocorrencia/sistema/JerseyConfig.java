package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint.Endpoint;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint.EndpointVehicle;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.register(RequestContextFilter.class);
        this.register(Endpoint.class);
        this.register(EndpointVehicle.class);
    }
}