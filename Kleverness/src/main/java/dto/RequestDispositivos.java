package dto;

public class RequestDispositivos {

	private String macAddress;
	private Integer status;

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestDispositivos [ macAddress=" + macAddress + ", status=" + status + "]";
	}

}
