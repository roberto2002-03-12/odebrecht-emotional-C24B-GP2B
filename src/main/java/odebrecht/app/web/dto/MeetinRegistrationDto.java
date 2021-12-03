package odebrecht.app.web.dto;

import java.sql.Date;

import odebrecht.app.model.Professional;
import odebrecht.app.model.User;

public class MeetinRegistrationDto {
	
	private Date date;
	
	private String message;
	
	private Professional professionals;
	
	private User users;
	
	public MeetinRegistrationDto() {
		
	}

	public MeetinRegistrationDto(Date date, String message, Professional professionals, User users) {
		super();
		this.date = date;
		this.message = message;
		this.professionals = professionals;
		this.users = users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Professional getProfessionals() {
		return professionals;
	}

	public void setProfessionals(Professional professionals) {
		this.professionals = professionals;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
}