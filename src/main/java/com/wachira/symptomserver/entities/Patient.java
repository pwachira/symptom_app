package com.wachira.symptomserver.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="patient_id")
	private Integer patientId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to Alert
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
	private List<Alert> alerts;

	//bi-directional many-to-one association to Checkin
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
	private List<Checkin> checkins;

	//bi-directional many-to-one association to MedicationHistory
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
	private List<MedicationHistory> medicationHistories;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

	public Patient() {
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Alert addAlert(Alert alert) {
		getAlerts().add(alert);
		alert.setPatient(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setPatient(null);

		return alert;
	}

	public List<Checkin> getCheckins() {
		return this.checkins;
	}

	public void setCheckins(List<Checkin> checkins) {
		this.checkins = checkins;
	}

	public Checkin addCheckin(Checkin checkin) {
		getCheckins().add(checkin);
		checkin.setPatient(this);

		return checkin;
	}

	public Checkin removeCheckin(Checkin checkin) {
		getCheckins().remove(checkin);
		checkin.setPatient(null);

		return checkin;
	}

	public List<MedicationHistory> getMedicationHistories() {
		return this.medicationHistories;
	}

	public void setMedicationHistories(List<MedicationHistory> medicationHistories) {
		this.medicationHistories = medicationHistories;
	}

	public MedicationHistory addMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().add(medicationHistory);
		medicationHistory.setPatient(this);

		return medicationHistory;
	}

	public MedicationHistory removeMedicationHistory(MedicationHistory medicationHistory) {
		getMedicationHistories().remove(medicationHistory);
		medicationHistory.setPatient(null);

		return medicationHistory;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}