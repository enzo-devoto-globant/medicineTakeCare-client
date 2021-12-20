package enzoDevoto.apps.medicineTakeCareclient.web.client;

import enzoDevoto.apps.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.web.model.PatientDto;
import enzoDevoto.apps.medicineTakeCareclient.web.util.Utils;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties("enzo.devoto")
@Component
public class MedicineTakeCareClient {
    public final String PATIENT_PATH = "/api/v1/patients/";

    @Setter
    private String host;

    private final RestTemplate restTemplate;

    public MedicineTakeCareClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PatientDto getPatientById(UUID patientUuid){
        return restTemplate.getForObject(host+ Utils.PATIENT_PATH + patientUuid, PatientDto.class);
    }

    public URI setNewPatient(PatientDto patientDto) {

        return restTemplate.postForLocation(host.concat(Utils.PATIENT_PATH), patientDto);

    }

    public DoctorDto getDoctorByID(UUID doctorUuid) {
        return restTemplate.getForObject(host+Utils.DOCTOR_PATH+doctorUuid, DoctorDto.class);
    }


    public ResponseEntity<DoctorDto> setNewDoctor(DoctorDto doctorDto) {
        return restTemplate.postForEntity(host.concat(Utils.DOCTOR_PATH), doctorDto, DoctorDto.class);

    }
}
