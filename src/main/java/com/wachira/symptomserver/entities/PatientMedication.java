package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the patient_medication database table.
 * 
 */
@Entity
@Table(name="patient_medication")
@NamedQuery(name="PatientMedication.findAll", query="SELECT p FROM PatientMedication p")
public class PatientMedication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="PATIENT_MEDICATION_PATIENTMEDICATIONID_GENERATOR", sequenceName="PATIENT_MEDICATION_PATIENT_MEDICATION_ID_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_MEDICATION_PATIENTMEDICATIONID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_medication_id", unique=true, nullable=false)
	private Integer patientMedicationId;

	

	//bi-directional many-to-one association to Medication
	@ManyToOne
	@JoinColumn(name="medication_id")
	private Medication medication;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public PatientMedication() {
	}

	public Integer getPatientMedicationId() {
		return this.patientMedicationId;
	}

	public void setPatientMedicationId(Integer patientMedicationId) {
		this.patientMedicationId = patientMedicationId;
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