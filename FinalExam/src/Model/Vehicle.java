package Model;

public class Vehicle {
	private String type; // Loai phuong tien
	private String ownerName; // Ten chu so huu
	private int identityCard; // CCCD
	private String chassisNumber; // So khung
	private String engineNumber; // So may
	private String brand; // Nhan hieu
	private String licensePlate; // Bien so
	
	public Vehicle() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(int identityCard) {
		this.identityCard = identityCard;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", ownerName=" + ownerName + ", identityCard=" + identityCard
				+ ", chassisNumber=" + chassisNumber + ", engineNumber=" + engineNumber + ", brand=" + brand
				+ ", licensePlate=" + licensePlate + "]";
	}
	
}
