package ddsi.utn.frba.climalert.models.repositories.implementaciones;

import ddsi.utn.frba.climalert.models.entities.Clima;
import ddsi.utn.frba.climalert.models.repositories.IClimaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClimaRepository implements IClimaRepository {

    private List<Clima> climas = new ArrayList<>();

    @Override
    public void save(Clima clima) {
        this.climas.add(clima);
    }

    @Override
    public Clima ultimoDato() {
        if(climas.isEmpty())
             return null;
        return climas.getLast();
    }
}
