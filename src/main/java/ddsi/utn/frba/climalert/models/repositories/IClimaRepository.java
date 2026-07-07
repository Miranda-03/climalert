package ddsi.utn.frba.climalert.models.repositories;

import ddsi.utn.frba.climalert.models.entities.Clima;

public interface IClimaRepository {
    void save(Clima clima);
    Clima ultimoDato();
}
