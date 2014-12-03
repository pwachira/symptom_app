package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	//@SequenceGenerator(name="MEDICATION_HISTORY_MEDICATIONHISTORYID_GENERATOR", sequenceName="MEDICATION_HISTORY_MEDICATION_HISTORY_ID_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICATION_HISTORY_MEDICATIONHISTORYID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medication_history_id", unique=true, nullable=false)
	private Integer medicationHistoryId;

	@Column(name="time_taken")
	private Timestamp timeTaken;

	//bi-directional many-to-one association to Checkin
	@ManyToOne
	@JoinColumn(name="checkin_id")
	@Cascade({ CascadeType.PERSIST })
	private Checkin checkin;

	//bi-directional many-to-one association to Medication
	@ManyToOne
	@Cascade({ CascadeType.PERSIST })
	@JoinColumn(name="medicaton_id")
	private Medication medication;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@Cascade({ CascadeType.PERSIST })
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

	public Checkin getCheckin() {
		return this.checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
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