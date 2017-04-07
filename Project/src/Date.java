/**
 * 
 * @author Brendon
 * Stores a date
 */
public class Date {
private Integer day;
private Integer month;
private Integer year;

/**
 * Constructor for Date
 * @param d value for day of type Integer
 * @param m value for month of type Integer
 * @param y value for year of type Integer
 */
public Date(Integer d, Integer m, Integer y)
{
	if (d > 0 && d < 32)
	{
		day = d;
	}
	else
	{
		throw new java.lang.Error("day out of bounds");
	}
	if (m > 0 && m < 13)
	{
		month = m;
	}
	else
	{
		throw new java.lang.Error("month out of bounds");
	}
	if (y > 2000 && y < 9999)
	{
		year = y;
	}
	else
	{
		throw new java.lang.Error("year out of bounds");
	}
}

/**
 * empty constructor for date
 * Defaults to January 1, 2017
 */
public Date()
{
	day = 1;
	month = 1;
	year = 2017;
}

/**
 * 
 * @param d value for day of type Integer
 */
public void setDay(Integer d)
{
	if (d > 0 && d < 32)
	{
		day = d;
	}
	else
	{
		throw new java.lang.Error("day out of bounds");
	}
}

/**
 * 
 * @param m value for month of type Integer
 */
public void setMonth(Integer m)
{
	if (m > 0 && m < 13)
	{
		month = m;
	}
	else
	{
		throw new java.lang.Error("month out of bounds");
	}
}

/**
 * 
 * @param y value for year of type Integer
 */
public void setYear(Integer y)
{
	if (y > 2000 && y < 9999)
	{
		year = y;
	}
	else
	{
		throw new java.lang.Error("year out of bounds");
	}
}

/**
 * 
 * @return day value of type Integer
 */
public Integer getDay()
{
	return day;
}

/**
 * 
 * @return month value of type Integer
 */
public Integer getMonth()
{
	return month;
}

/**
 * 
 * @return year value of type Integer
 */
public Integer getYear()
{
	return year;
}

public boolean equals(String str)
{
	String strCurrent1 =  (year.toString() + "/" + month.toString() + "/" + day.toString());
	String strCurrent2 = (year.toString() + month.toString() + day.toString());
	if (str == strCurrent1 || str == strCurrent2)
	{
		return true;
	}
	else
	{
		return false;
	}
}

}
