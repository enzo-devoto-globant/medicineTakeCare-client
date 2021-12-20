package enzoDevoto.apps.medicineTakeCareclient.client;

import enzoDevoto.apps.medicineTakeCareclient.web.client.MedicineTakeCareClient;
import enzoDevoto.apps.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.web.model.PatientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicineTakeCareClientTest {

    @Autowired
    MedicineTakeCareClient clientApplication;

    @Test
    void test_should_pass_if_patientDto_contains_data() {
        PatientDto patientDto = clientApplication.getPatientById(UUID.randomUUID());
        assertNotNull(patientDto);
    }

    @Test
    void test_should_pass_if_doctorDto_contains_data() {
        DoctorDto doctorDto = clientApplication.getDoctorByID(UUID.randomUUID());
        assertNotNull(doctorDto);
    }

    @Test
    void test_should_pass_when_contains_uri(){

        PatientDto patientDto = PatientDto.builder()
                .name("New Patient")
                .description("jvhjvjv")
                .age(30)
                .email("jvjhvjvj")
                .gender("kjkjbkb")
                .isCritical(true)
                .timeOfEvaluation(Date.from(Instant.now()))
                .id(UUID.randomUUID())
                .build();

        System.out.println(patientDto);
        ResponseEntity<PatientDto> uri = clientApplication.setNewPatient(patientDto);
        System.out.println(uri);
        assertNotNull(uri);

    }


}