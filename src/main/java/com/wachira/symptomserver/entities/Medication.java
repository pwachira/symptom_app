package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.wachira.symptomserver.entities.PatientMedication;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the medication database table.
 * 
 */
@Entity
@Table(name="medication")
@NamedQuery(name="Medication.findAll", query="SELECT m FROM Medication m")
public class Medication implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	//@SequenceGenerator(name="MEDICATION_MEDICATIONID_GENERATOR", sequenceName="MEDICATION_MEDICATION_ID_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICATION_MEDICATIONID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="medication_id", unique=true, nullable=false)
	private Integer medicationId;

	@Column(name="medication_name", length=100)
	private String medicationName;

	//bi-directional many-to-one association to MedicationHistory
	@JsonIgnore
	@OneToMany(mappedBy="medication", fetch=FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST })
	private List<MedicationHistory> medicationHistories;

	//bi-directional many-to-one association to PatientMedication
	@JsonIgnore
	@OneToMany(mappedBy="medication", fetch=FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST })
	private List<PatientMedication> patientMedications;

	public Medication() {
	}

	public Integer getMedicationId() {
		return this.medicationId;
	}

	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return this.medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public List<MedicationHistory> getMedicationHistories() {
		return this.medicationHistories;
	}

	public void setMedicationHistories(List<MedicationHistory> medicationHistories) {
		this.medicationHistories = medicationHistories;
	}

	public MedicationHistory addMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().add(medicationHistory);
		medicationHistory.setMedication(this);

		return medicationHistory;
	}

	public MedicationHistory removeMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().remove(medicationHistory);
		medicationHistory.setMedication(null);

		return medicationHistory;
	}
	
	public List<PatientMedication> getPatientMedications() {
		return this.patientMedications;
	}

	public void setPatientMedications(List<PatientMedication> patientMedications) {
		this.patientMedications = patientMedications;
	}

	public PatientMedication addPatientMedication(PatientMedication patientMedication) {
		getPatientMedications().add(patientMedication);
		patientMedication.setMedication(this);

		return patientMedication;
	}

	public PatientMedication removePatientMedication(PatientMedication patientMedication) {
		getPatientMedications().remove(patientMedication);
		patientMedication.setMedication(null);

		return patientMedication;
	}


}