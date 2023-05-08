package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint.ReportEndpoint;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema.endpoint.VehicleEndpoint;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.register(RequestContextFilter.class);
        this.register(ReportEndpoint.class);
        this.register(VehicleEndpoint.class);
    }
}