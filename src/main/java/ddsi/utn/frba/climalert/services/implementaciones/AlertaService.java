package ddsi.utn.frba.climalert.services.implementaciones;

import ddsi.utn.frba.climalert.models.entities.Alerta;
import ddsi.utn.frba.climalert.models.entities.Clima;
import ddsi.utn.frba.climalert.models.repositories.IClimaRepository;
import ddsi.utn.frba.climalert.services.IAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertaService implements IAlertaService {

    private final IClimaRepository climaRepository;
    private final Alerta alerta;

    @Autowired
    public AlertaService(IClimaRepository climaRepository, Alerta alerta){
        this.climaRepository = climaRepository;
        this.alerta = alerta;
    }

    @Override
    public void alertar() {
        Clima ultimoDatoDelClima =  climaRepository.ultimoDato();
        if(ultimoDatoDelClima != null)
            alerta.alertar(ultimoDatoDelClima);
    }
}
