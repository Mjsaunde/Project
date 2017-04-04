/**
 * 
 * @author Mark Saunderson
 * Class to store Passenger information,
 * first and last names along with birthday
 */
public class Passenger {
private String firstName = "";  //stores value for passenger's first name
private String lastName = "";   //stores value for passenger's last name
private Date birthday ;         //stores value for passenger's birthday

/**
 * Constructor for class Passenger
 * @param f value for passenger's first name
 * @param l value for passenger's last name
 * @param b value for passenger's birthday
 */
public Passenger(String f, String l, Date b){
	this.firstName = f;
	this.lastName = l;
	this.birthday = b;
}

/**
 * Default constuctor for class Passenger
 */
public Passenger(){}

/**
 * Getter for first name
 * @return returns first name of type String
 */
public String getFirstName(){
	return this.firstName;
}

/**
 * Getter for last name
 * @return returns last name of type string
 */
public String getLastName(){
	return this.lastName;
}

/**
 * Getter for birthday
 * @return return's birthday of type Date
 */
public Date getBirthday(){
	return this.birthday;
}

/**
 * Setter for first name
 * @param f value for passenger's first name of type String
 */
public void setFirstName(String f){
	this.firstName = f;
}

/**
 * Setter for last name
 * @param l value for passenger's last name of type String
 */
public void setLastName(String l){
	this.lastName = l;
}

/**
 * Setter for birthday
 * @param b value for passenger's birthday of type Date
 */
public void setBirthday(Date b){
	this.birthday = b;
}

}
