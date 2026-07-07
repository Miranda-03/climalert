package ddsi.utn.frba.climalert.models.entities;

import lombok.Data;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmailSender {
    private final JavaMailSender mailSender;

    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void enviar(String mail, Clima datosDelClima) {

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(mail);
        mensaje.setSubject("Alerta de clima");
        mensaje.setText(
                "Temperatura actual: " + datosDelClima.getTemperatura() + "°C\n" +
                        "Humedad actual: " + datosDelClima.getHumedad() + "%\n"
        );

        mailSender.send(mensaje);
    }
}
