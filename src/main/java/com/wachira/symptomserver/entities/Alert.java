package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the alert database table.
 * 
 */
@Entity
@Table(name="alert")
@NamedQuery(name="Alert.findAll", query="SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALERT_ALERTID_GENERATOR", sequenceName="ALERT_ALERT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERT_ALERTID_GENERATOR")
	@Column(name="alert_id", unique=true, nullable=false)
	private Integer alertId;

	@Column(name="alert_description", length=255)
	private String alertDescription;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Alert() {
	}

	public Integer getAlertId() {
		return this.alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}

	public String getAlertDescription() {
		return this.alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}