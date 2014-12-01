package com.wachira.symptomserver.service;

import java.sql.Timestamp;
import java.util.List;

import com.wachira.symptomserver.entities.Patient;

public class CheckinDTO {
	private Integer checkinId;

	private Timestamp checkindate;

	private String eatingimpact;

	private Boolean medicationtaken;

	private String painseverity;

	private Patient patient;

	private List<MedicationHistoryDTO> medicationHistories;

	public CheckinDTO() {
	}

	public Integer getCheckinId() {
		return this.checkinId;
	}

	public void setCheckinId(Integer checkinId) {
		this.checkinId = checkinId;
	}

	public Timestamp getCheckindate() {
		return this.checkindate;
	}

	public void setCheckindate(Timestamp checkindate) {
		this.checkindate = checkindate;
	}

	public String getEatingimpact() {
		return this.eatingimpact;
	}

	public void setEatingimpact(String eatingimpact) {
		this.eatingimpact = eatingimpact;
	}

	public Boolean getMedicationtaken() {
		return this.medicationtaken;
	}

	public void setMedicationtaken(Boolean medicationtaken) {
		this.medicationtaken = medicationtaken;
	}

	public String getPainseverity() {
		return this.painseverity;
	}

	public void setPainseverity(String painseverity) {
		this.painseverity = painseverity;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<MedicationHistoryDTO> getMedicationHistories() {
		return this.medicationHistories;
	}

	public void setMedicationHistories(List<MedicationHistoryDTO> medicationHistories) {
		this.medicationHistories = medicationHistories;
	}

	public MedicationHistoryDTO addMedicationHistory(MedicationHistoryDTO medicationHistory) {
		getMedicationHistories().add(medicationHistory);
		medicationHistory.setCheckin(this);

		return medicationHistory;
	}

	public MedicationHistoryDTO removeMedicationHistory(MedicationHistoryDTO medicationHistory) {
		getMedicationHistories().remove(medicationHistory);
		medicationHistory.setCheckin(null);

		return medicationHistory;
	}

}
