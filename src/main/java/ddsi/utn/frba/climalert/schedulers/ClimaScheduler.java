package ddsi.utn.frba.climalert.schedulers;

import ddsi.utn.frba.climalert.services.IClimaService;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClimaScheduler {
    private final IClimaService climaService;

    @Scheduled(cron = "${obtencionClima.cron}")
    public void obtenerClima(){
        climaService.ObtenerClimaActual();
    }
}
