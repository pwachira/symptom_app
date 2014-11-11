package com.wachira.symptomserver.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the checkin database table.
 * 
 */
@Entity
@NamedQuery(name="Checkin.findAll", query="SELECT c FROM Checkin c")
public class Checkin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="checkin_id")
	private Integer checkinId;

	private Timestamp checkindate;

	private String eatingimpact;

	private Boolean medicationtaken;

	private String painseverity;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

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

}