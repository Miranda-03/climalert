package ddsi.utn.frba.climalert.models.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClimaActual {
    private WeaterAPI api;

    @Autowired
    public ClimaActual(WeaterAPI api){
        this.api = api;
    }

    public Clima obtenerDatos(){
        return api.obtenerDatosDelClimaActual();
    }
}
