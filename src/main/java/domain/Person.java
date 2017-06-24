package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * {"firstName":"Andrzej",
 * "lastName":"Nowak",
 * "gender":"Male",
 * "birthday":"06/08/2017",
 * "email":"k@wp.pl",
 * "age":"16"}
*/

@SuppressWarnings("restriction")
@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name="person.all", query="SELECT p FROM Person p"),
	@NamedQuery(name="person.id", query="FROM Person p WHERE p.id=:personId")
})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String birthday;
	private String email;
	private int age;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Gender getGender(){
		return this.gender;
	}
	
	public void setGender(Gender gender){
		this.gender = gender;
	}
	
	public String getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
}
