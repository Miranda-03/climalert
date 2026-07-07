package ddsi.utn.frba.climalert.schedulers;

import ddsi.utn.frba.climalert.services.IAlertaService;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Data
public class AlertaScheduler {
    private final IAlertaService alertaService;

    @Scheduled(cron = "${alerta.cron}")
    public void alertar(){
        alertaService.alertar();
    }
}
