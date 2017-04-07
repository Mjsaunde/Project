/**
 * 
 * @author Mark
 * @author Brendon
 * Class for time
 */
public class Time {
	private Integer hour, minute, second;
	
	/**
	 * Constructor for Time
	 * @param Hour value for hour of type Integer
	 * @param Minute value for minute of type Integer
	 * @param Second value for second of type Integer
	 */
	public Time(Integer Hour, Integer Minute, Integer Second){
		 
		if(Hour>=0 && Hour<=23)
			hour = Hour;
		else
			System.out.println("You have entered an incorrect value for Hour. Try again.");
		if(Minute>=0 && Minute<=59)
			minute = Minute;
		else
			System.out.println("You have entered an incorrect value for minute.Try again.");
		if(Second>=0 && Second<=59)
			second = Second;
		else
			System.out.println("You have entered an incorrect value for second. Try again.");
	}
	
	/**
	 * Parse time from string
	 * @param strTime
	 */
	public Time(String strTime)
	{
		Integer offset = strTime.indexOf(':');
		hour = Integer.parseInt(strTime.substring(0,offset-1));
		minute = Integer.parseInt(strTime.substring(offset+1,offset+2));
		second = Integer.parseInt(strTime.substring(offset+4,offset+5));
	}
	
	/**
	 * Default constructor
	 */
	public Time(){
		new Time(0,0,0);
	}
	
	/**
	 * Getter for hour
	 * @return value for hour of type Integer
	 */
	public int getHour(){
		return hour;
	}
	
	/**
	 * Getter for minute
	 * @return value of minute of type Integer
	 */
	public int getMinute(){
		return minute;
	}
	
	/**
	 * Getter for second
	 * @return value of second of type Integer
	 */
	public int getSecond(){
		return second;
	}
	
	/**
	 * Setter for hour
	 * @param Hour value for hour of type Integer
	 */
	public void setHour(int Hour){
		if(Hour>=0 && Hour<=23)
			hour = Hour;
		else
			System.out.println("You have entered an incorrect value for Hour. Try again.");
	}
	
	/**
	 * Setter for minute
	 * @param Minute value for minute of type Integer
	 */
	public void setMinute(int Minute){
		if(Minute>=0 && Minute<=59)
			minute = Minute;
		else
			System.out.println("You have entered an incorrect value for minute.Try again.");
	}
	
	/**
	 * Setter for second
	 * @param Second value for second of type Integer
	 */
	public void setSecond(int Second){
		if(Second>=0 && Second<=59)
			second = Second;
		else
			System.out.println("You have entered an incorrect value for second. Try again.");
	}
	
	public String toString()
	{
		return String.format("%2d:%2d:%2d", hour, minute, second);
	}
}
