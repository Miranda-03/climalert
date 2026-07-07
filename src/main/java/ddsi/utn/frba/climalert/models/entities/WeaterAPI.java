package ddsi.utn.frba.climalert.models.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeaterAPI {

    private final WebClient webClient;
    private final String apiKey;

    public WeaterAPI(WebClient.Builder builder,
                     @Value("${weather.api.base}") String baseUrl,
                     @Value("${weather.api.key}") String apiKey) {

        this.webClient = builder.baseUrl(baseUrl).build();
        this.apiKey = apiKey;
    }

    public Clima obtenerDatosDelClimaActual() {

        WeatherApiResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", "Buenos-Aires")
                        .queryParam("aqi", "no")
                        .queryParam("pollen", "no")
                        .queryParam("lang", "es")
                        .build()
                )
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .block();

        Clima climaCurrent = new Clima();
        climaCurrent.setTemperatura(response.getCurrent().getTemp_c());
        climaCurrent.setHumedad(response.getCurrent().getHumidity());

        return climaCurrent;
    }
}
