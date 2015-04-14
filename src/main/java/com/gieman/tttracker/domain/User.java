package com.gieman.tttracker.domain;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Благодатских С.
 */
@Entity
@Table(name = "ttt_user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = "User.findByUsernamePassword", query = "SELECT u FROM User "
			+ "u WHERE (u.username = :username OR u.email = :username) AND u.password = :password"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User extends AbstractEntity implements EntityItem<String> {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "username")
	private String username;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "first_name")
	private String firstName;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}"
			+ "~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?"
			+ ":[a-z0-9-]*[a-z0-9])?",
			message = "Недопустимый адрес электронной почты")
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String email;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@NotNull
	@Column(name = "admin_role")
	private Character adminRole;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String firstName, String lastName, String email, String password, Character adminRole) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.adminRole = adminRole;
	}

	@Override
	public String getId() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Character getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(Character adminRole) {
		this.adminRole = adminRole;
	}

	@Override
	public int hashCode() {
		return 97 * 3 + Objects.hashCode(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return Objects.equals(username, ((User) obj).username);
	}

	@Override
	public String toString() {
		return "com.gieman.tttracker.domain.User[ username=" + username + " ]";
	}

}
