package enzoDevoto.apps.medicineTakeCareclient.web.util;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

@FieldNameConstants
@SuperBuilder
@Data
public abstract class Utils {
    public static String PATIENT_PATH = "/api/v1/patients/";
    public static String DOCTOR_PATH = "/api/v1/doctors/";
}
