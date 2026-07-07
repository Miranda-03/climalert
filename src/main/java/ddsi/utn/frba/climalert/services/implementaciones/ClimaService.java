package ddsi.utn.frba.climalert.services.implementaciones;

import ddsi.utn.frba.climalert.models.entities.ClimaActual;
import ddsi.utn.frba.climalert.models.repositories.IClimaRepository;
import ddsi.utn.frba.climalert.services.IClimaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClimaService implements IClimaService {
    private final IClimaRepository climaRepository;
    private final ClimaActual climaActual;

    private static final Logger log = LoggerFactory.getLogger(ClimaService.class);

    @Autowired
    public ClimaService(IClimaRepository climaRepository, ClimaActual climaActual){
        this.climaActual = climaActual;
        this.climaRepository = climaRepository;
    }

    @Override
    public void ObtenerClimaActual() {
        climaRepository.save(climaActual.obtenerDatos());
        log.info(String.valueOf(climaRepository.ultimoDato().getTemperatura()));
    }
}
