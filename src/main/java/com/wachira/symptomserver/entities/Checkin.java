package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the checkin database table.
 * 
 */
@Entity
@Table(name="checkin")
@NamedQuery(name="Checkin.findAll", query="SELECT c FROM Checkin c")
public class Checkin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="CHECKIN_CHECKINID_GENERATOR", sequenceName="CHECKIN_CHECKIN_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHECKIN_CHECKINID_GENERATOR") 
	*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="checkin_id", unique=true, nullable=false)
	private Integer checkinId;

	@Column
	private Timestamp checkindate;

	@Column(length=100)
	private String eatingimpact;

	private Boolean medicationtaken;

	@Column(length=100)
	private String painseverity;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	//bi-directional many-to-one association to MedicationHistory
	@JsonIgnore
	@OneToMany(mappedBy="checkin", fetch=FetchType.EAGER)
	private List<MedicationHistory> medicationHistories;

	public Checkin() {
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

	public List<MedicationHistory> getMedicationHistories() {
		return this.medicationHistories;
	}

	public void setMedicationHistories(List<MedicationHistory> medicationHistories) {
		this.medicationHistories = medicationHistories;
	}

	public MedicationHistory addMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().add(medicationHistory);
		medicationHistory.setCheckin(this);

		return medicationHistory;
	}

	public MedicationHistory removeMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().remove(medicationHistory);
		medicationHistory.setCheckin(null);

		return medicationHistory;
	}

}