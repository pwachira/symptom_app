package com.wachira.symptomserver.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@Table(name="doctor")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="DOCTOR_DOCTORID_GENERATOR", sequenceName="DOCTOR_DOCTOR_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCTOR_DOCTORID_GENERATOR")
	*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id", unique=true, nullable=false)
	private Integer doctorId;

	@Column(name="first_name", length=100)
	private String firstName;

	@Column(name="last_name", length=100)
	private String lastName;

	@Column(name="national_provider_id", length=50)
	private String nationalProviderId;

	@Column(name="user_name", length=50)
	private String userName;

	//bi-directional many-to-one association to Alert
	@JsonIgnore
	@OneToMany(mappedBy="doctor", fetch=FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST })
	private List<Alert> alerts;

	//bi-directional many-to-one association to Patient
	@JsonIgnore
	@OneToMany(mappedBy="doctor", fetch=FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST })
	private List<Patient> patients;

	public Doctor() {
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
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

	public String getNationalProviderId() {
		return this.nationalProviderId;
	}

	public void setNationalProviderId(String nationalProviderId) {
		this.nationalProviderId = nationalProviderId;
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
		alert.setDoctor(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setDoctor(null);

		return alert;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setDoctor(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setDoctor(null);

		return patient;
	}

}