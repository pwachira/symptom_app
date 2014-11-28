package com.wachira.symptomserver.service;

public class PatientMedsDTO {

	private String MedicationName;
	private Integer MedicationId;
	private String PatientUsername;
	private Integer PatientId;
	public String getMedicationName() {
		return MedicationName;
	}
	public void setMedicationName(String medicationName) {
		MedicationName = medicationName;
	}
	public Integer getMedicationId() {
		return MedicationId;
	}
	public void setMedicationId(Integer medicationId) {
		MedicationId = medicationId;
	}
	public String getPatientUsername() {
		return PatientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		PatientUsername = patientUsername;
	}
	public Integer getPatientId() {
		return PatientId;
	}
	public void setPatientId(Integer patientId) {
		PatientId = patientId;
	}

}
