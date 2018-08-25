package demo.internal.contacts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "name", length = 128)
	private String name;
	
	@Column(name = "lastname", length = 128)
	private String lastname;

	@Column(name = "email", length = 128)
	private String email;
	
	@Column(name = "telephone")
	private int telephone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", telephone="
				+ telephone + "]";
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastname, String email, int telephone) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
	}
}