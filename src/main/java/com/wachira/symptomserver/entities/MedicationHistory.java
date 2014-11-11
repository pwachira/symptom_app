package com.wachira.symptomserver.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the medication_history database table.
 * 
 */
@Entity
@Table(name="medication_history")
@NamedQuery(name="MedicationHistory.findAll", query="SELECT m FROM MedicationHistory m")
public class MedicationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="medication_history_id")
	private Integer medicationHistoryId;

	@Column(name="time_taken")
	private Timestamp timeTaken;

	//bi-directional many-to-one association to Medication
	@ManyToOne
	@JoinColumn(name="medicaton_id")
	private Medication medication;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public MedicationHistory() {
	}

	public Integer getMedicationHistoryId() {
		return this.medicationHistoryId;
	}

	public void setMedicationHistoryId(Integer medicationHistoryId) {
		this.medicationHistoryId = medicationHistoryId;
	}

	public Timestamp getTimeTaken() {
		return this.timeTaken;
	}

	public void setTimeTaken(Timestamp timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Medication getMedication() {
		return this.medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}