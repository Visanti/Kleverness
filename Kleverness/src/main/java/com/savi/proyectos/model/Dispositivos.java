package com.savi.proyectos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Dispositivos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="ID del Dispositivo", dataType="Integer",  example="1", position=1)
	private Integer id;
	private String type;
	private String macAddress;
	private String qrCode;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Dispositivos [id=" + id + ", type=" + type + ", macAddress=" + macAddress + ", qrCode=" + qrCode
				+ ", status=" + status + "]";
	}
	

	/*
	 * Id Type Mac address QR Code Status 1. Assigned 2. Unassigned 3. Revoked
	 */


}
