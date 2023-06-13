package entity;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class acountentity {
    @NotEmpty(message = "tên không để rỗng")
	private String fullName;
    @NotEmpty(message = "email không để rỗng")
    @Email(message = "email sai định dạng")
	private String email;
    @NotEmpty(message = "pass không để rỗng")
	private String password;
    @NotEmpty(message = "phone không để rỗng")
	private String phone;
    @NotNull(message = "birthday không để rỗng")
	private Date birthday;
	public acountentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public acountentity(@NotEmpty(message = "tên không để rỗng") String fullName,
			@NotEmpty(message = "email không để rỗng") @Email(message = "email sai định dạng") String email,
			@NotEmpty(message = "pass không để rỗng") String password,
			@NotEmpty(message = "phone không để rỗng") String phone,
			@NotNull(message = "birthday không để rỗng") Date birthday) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	 
}
