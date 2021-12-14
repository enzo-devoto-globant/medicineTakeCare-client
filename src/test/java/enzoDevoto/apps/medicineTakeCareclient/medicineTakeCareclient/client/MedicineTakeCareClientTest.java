package enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.client;

import enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.medicineTakeCareclient.web.model.PatientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicineTakeCareClientTest {

    @Autowired
    MedicineTakeCareClient clientApplication;

    @Test
    void getPatientById() {
        PatientDto patientDto = clientApplication.getPatientById(UUID.randomUUID());
        DoctorDto doctorDto = clientApplication.getDoctorById(UUID.randomUUID());

        assertNotNull(patientDto);
        assertNotNull(doctorDto);
    }

    @Test
    void getDoctorById() {
    }

}