package ddsi.utn.frba.climalert.models.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Alerta {

    private List<String> personasAlertadas;
    private EmailSender sender;

    private Integer temperaturaMaxima;
    private Integer humedadMaxima;

    public Alerta (EmailSender sender,
                   @Value("${alert.recipients}") List<String> personas,
                   @Value("${alert.tempMax}") Integer temperaturaMaxima,
                   @Value("${alert.humMax}") Integer humedadMaxima){
        this.sender = sender;
        this.personasAlertadas = personas;
        this.temperaturaMaxima = temperaturaMaxima;
        this.humedadMaxima = humedadMaxima;
    }

    public void enviar(Clima datos){
        for (String persona : personasAlertadas){
            this.sender.enviar(persona, datos);
        }
    }

    public void alertar(Clima datos){
        if(datos.getTemperatura() > this.temperaturaMaxima && datos.getHumedad() > humedadMaxima)
            this.enviar(datos);
    }
}
