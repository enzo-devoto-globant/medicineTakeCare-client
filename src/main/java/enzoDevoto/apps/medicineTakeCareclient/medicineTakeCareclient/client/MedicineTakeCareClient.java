package enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.client;

import enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.web.model.PatientDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;



public class MedicineTakeCareClient {

    public final String PATIENT_PATH = "/api/v1/patients/";
    public final String DOCTOR_PATH = "/api/v1/doctors/";

    public MedicineTakeCareClient(String apihost, RestTemplate restTemplate) {
        this.apihost = apihost;
        this.restTemplate = restTemplate;
    }

    private String apihost;
    private final RestTemplate restTemplate;

    public MedicineTakeCareClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PatientDto getPatientById(UUID patientUuid){
        return restTemplate.getForObject(apihost + PATIENT_PATH+ patientUuid.toString(), PatientDto.class);
    }

    public DoctorDto getDoctorById(UUID doctorUuid){
        return restTemplate.getForObject(apihost + DOCTOR_PATH+ doctorUuid.toString(), DoctorDto.class);
    }



}
