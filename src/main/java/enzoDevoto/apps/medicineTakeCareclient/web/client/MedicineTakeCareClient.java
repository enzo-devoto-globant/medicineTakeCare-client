package enzoDevoto.apps.medicineTakeCareclient.web.client;

import enzoDevoto.apps.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.web.model.PatientDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@ConfigurationProperties("enzo.devoto")
@Component
public class MedicineTakeCareClient {

    @Setter
    private String host;

    public final String PATIENT_PATH = "/api/v1/patients/";
    public final String DOCTOR_PATH = "/api/v1/doctors/";
    private final RestTemplate restTemplate;

    public MedicineTakeCareClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PatientDto getPatientById(UUID patientUuid){
        return restTemplate.getForObject(host+PATIENT_PATH+patientUuid, PatientDto.class);
    }

    public DoctorDto getDoctorByID(UUID doctorUuid) {
        return restTemplate.getForObject(host+DOCTOR_PATH+doctorUuid, DoctorDto.class);
    }

}
