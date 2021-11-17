package odebrecht.app.web.dto;
import java.sql.Date;
public class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String password;
	private int cellphone;
	private String email;
	private Date birth;
	
	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String firstName, String lastName, String password, int cellphone, String email,
			Date birth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.birth = birth;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCellphone() {
		return cellphone;
	}
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}