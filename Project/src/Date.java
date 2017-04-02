/**
 * 
 * @author Brendon
 * Stores a date
 */
public class Date {
private Integer day;
private Integer month;
private Integer year;

public Date(Integer d, Integer m, Integer y)
{
	day = d;
	month = m;
	year = y;
}

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

public Integer getDay()
{
	return day;
}

public Integer getMonth()
{
	return month;
}

public Integer getYear()
{
	return year;
}
}
