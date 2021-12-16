package enzoDevoto.apps.medicineTakeCareclient.client;


import enzoDevoto.apps.medicineTakeCareclient.web.client.MedicineTakeCareClient;
import enzoDevoto.apps.medicineTakeCareclient.web.model.DoctorDto;
import enzoDevoto.apps.medicineTakeCareclient.web.model.PatientDto;
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
        assertNotNull(patientDto);
    }

    @Test
    void getDoctorById() {
        DoctorDto doctorDto = clientApplication.getDoctorByID(UUID.randomUUID());
        assertNotNull(doctorDto);
    }

}