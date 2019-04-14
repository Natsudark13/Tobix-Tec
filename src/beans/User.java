package beans;
import javax.faces.bean.*;
//import javax.annotation.ManagedBean;


//@SuppressWarnings("deprecation")
@ManagedBean 
public class User {

	private String firstName;
	private String lastName;
	
	public User(){
		//firstName = "Shadd";
		//lastName = "Rodri";
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
	
}
