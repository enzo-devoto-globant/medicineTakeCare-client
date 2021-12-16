package enzoDevoto.apps.medicineTakeCareclient.web.client;

import enzoDevoto.apps.medicineTakeCareclient.web.model.PatientDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Configuration
@ConfigurationProperties(prefix = "application.properties")
@Component
public class MedicineTakeCareClient {

    @Value("${mtc.setHost}")
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public final String PATIENT_PATH = "/api/v1/patients/";
    private final RestTemplate restTemplate;

    public MedicineTakeCareClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public PatientDto getPatientById(UUID uuid){
        return restTemplate.getForObject(host+PATIENT_PATH+uuid, PatientDto.class);
    }
}
