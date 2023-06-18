package com.example.emr;

public class PatientTreatment {
    public String diagnosis_code;
    public String appointment_date;

    public PatientTreatment(String dc, String ad) {
        this.diagnosis_code = dc;
        this.appointment_date = ad;
    }

    public String getDiagnosis_code() {
        return diagnosis_code;
    }

    public void setDiagnosis_code(String diagnosis_code) {
        this.diagnosis_code = diagnosis_code;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }
}
