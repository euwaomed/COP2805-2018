/**
 * 
 */
package week03;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Requirements: The system shall display the name of the user using the
 * following format: <last, first> The system shall display the full account
 * information n the following format: <DisplayName> Salary $XXX,XX0.00. For
 * example: LaChance, Scott Salary: $20,000.00
 * 
 * @author Efosa Uwa-Omede
 *
 */
public class Employee
{
	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            Employee()
	 * @param override
	 *            None
	 * @param comment
	 *            Default Constructor for Employee class
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "New First", "New Last", "0.00"
	 */
	public Employee()
	{
		m_first = "New First";
		m_last = "New Last";
		m_salary = 0.00;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            Employee(String expectedFirst, String expectedLast)
	 * @param expectedFirst
	 *            Parameter
	 * @param expectedLast
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Second Constructor for Employee class
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "expectedFirst", "expectedLast"
	 */
	public Employee(String expectedFirst, String expectedLast)
	{
		m_first = expectedFirst;
		m_last = expectedLast;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param name
	 *            Employee(String expectedFirst, String expectedLast, double
	 *            salary)
	 * @param expectedFirst
	 *            parameter
	 * @param expectedLast
	 *            parameter
	 * @param salary
	 *            parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Third Constructor for Employee class
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "expectedFirst", "expectedLast", "salary"
	 */
	public Employee(String expectedFirst, String expectedLast, double salary)
	{
		m_first = expectedFirst;
		m_last = expectedLast;
		m_salary = salary;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            equals(Object obj)
	 * @param override
	 *            Yes
	 * @param comment
	 *            Returns true or false when determining whether different
	 *            pieces of info are equal.
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 * 
	 * @param obj
	 *            Parameter
	 * 
	 * @return The return type minus the qualified name
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Employee other = (Employee)obj;
		if(MONEY_PATTERN == null)
		{
			if(other.MONEY_PATTERN != null)
				return false;
		}
		else if(!MONEY_PATTERN.equals(other.MONEY_PATTERN))
			return false;
		if(m_first == null)
		{
			if(other.m_first != null)
				return false;
		}
		else if(!m_first.equals(other.m_first))
			return false;
		if(m_last == null)
		{
			if(other.m_last != null)
				return false;
		}
		else if(!m_last.equals(other.m_last))
			return false;
		if(Double.doubleToLongBits(m_salary) != Double
				.doubleToLongBits(other.m_salary))
			return false;
		return true;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getFirstName()
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieves first name
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public String getFirstName()
	{
		return m_first;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getLastName()
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieves last name
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public String getLastName()
	{
		return m_last;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getFortmattedSalary()
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieves the salary in a "$XXX,XX0.00" format
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public String getFormattedSalary()
	{
		DecimalFormat m_decimalFormatter = new DecimalFormat(MONEY_PATTERN);
		return String.format("%s", m_decimalFormatter.format(m_salary));
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getSalary()
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieves the salary
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public double getSalary()
	{
		return m_salary;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getDisplayName()
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieves the display the name of the user using the following
	 *            format: <last, first>
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public String getDisplayName()
	{
		return String.format("%s, %s", m_last, m_first);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            setFirstName()
	 * @param expectedFirst
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Sets First Name
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "expectedFirst"
	 */
	public void setFirstName(String expectedFirst)
	{
		m_first = expectedFirst;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            setLastName()
	 * @param expectedLast
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Sets Last Name
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "expectedLirst"
	 */
	public void setLastName(String expectedLast)
	{
		m_last = expectedLast;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            setSalary()
	 * @param salary
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Sets Salary
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "salary"
	 */
	public void setSalary(double salary)
	{
		m_salary = salary;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            toString()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Retrieves the full account information n the following format:
	 *            <DisplayName> Salary $XXX,XX0.00 For example: LaChance, Scott
	 *            Salary: $20,000.00
	 * @param visiblity
	 *            public
	 * 
	 *            Override the toString
	 * 
	 * @return formatted string
	 */
	@Override
	public String toString()
	{
		return String.format("%s Salary: $%s", this.getDisplayName(),
				this.getFormattedSalary());
	}

	private String m_first;
	private String m_last;
	private double m_salary;
	private String MONEY_PATTERN = "###,##0.00";

}
