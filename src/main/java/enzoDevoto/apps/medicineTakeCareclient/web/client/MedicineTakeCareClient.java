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

    @Setter
    private String host;

    private final RestTemplate restTemplate;

    public MedicineTakeCareClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PatientDto getPatientById(UUID patientUuid){
        return restTemplate.getForObject(host+ Utils.PATIENT_PATH + patientUuid, PatientDto.class);
    }

    public ResponseEntity<PatientDto> setNewPatient(PatientDto patientDto) {

        return restTemplate.postForEntity(host.concat(Utils.PATIENT_PATH), patientDto, PatientDto.class);

    }
    public void updatePatient(UUID patientId, PatientDto patient){
        restTemplate.put(host+Utils.PATIENT_PATH.concat("updatePatient/")+patientId,patient);
    }

    public void deletePatient(UUID patientId){
        restTemplate.delete(host+Utils.PATIENT_PATH.concat("deletePatient/")+patientId);
    }

    public DoctorDto getDoctorByID(UUID doctorUuid) {
        return restTemplate.getForObject(host+Utils.DOCTOR_PATH+doctorUuid, DoctorDto.class);
    }

}
