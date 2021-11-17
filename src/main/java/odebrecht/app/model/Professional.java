package odebrecht.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "professional", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Professional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long id;
	
	private String email;//
	
	@Column(name = "first_name")//
	private String firstName;
	
	@Column(name = "last_name")//
	private String lastName;
	
	@Column(name = "local_number")//
	private int number;
	
	private String licensed;//
	
	private String address;//
	
	private String image;//
	
	private String description;//
	
	private String type;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLicensed() {
		return licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Professional() {
		
	}

	public Professional(Long id, String email, String firstName, String lastName, int number, String licensed,
			String address, String image, String description, String type) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.licensed = licensed;
		this.address = address;
		this.image = image;
		this.description = description;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", number=" + number + ", licensed=" + licensed + ", address=" + address + ", image=" + image
				+ ", description=" + description + ", type=" + type + "]";
	}
	
}