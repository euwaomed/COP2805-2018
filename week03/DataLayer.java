/**
 * 
 */
package week03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The data layer is the persistence layer where data is read and stored. In
 * this assignment, the data layer will only store data in memory (no files or
 * database).
 * 
 * @author eomed
 *
 */
public class DataLayer
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            DataLayer(List<Employee> list)
	 * @param list
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Constructor
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "list"
	 */
	public DataLayer(List<Employee> list)
	{
		this.m_map = new HashMap<>();
		if(list != null)
		{
			for(Employee e : list)
			{
				m_map.put(e.getLastName(), e);
			}
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            addEmployee(Employee emp)
	 * @param emp
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Adds an employee
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "emp"
	 */
	public void addEmployee(Employee emp)
	{
		m_map.put(emp.getLastName(), emp);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            deleteEmployee(Employee emp)
	 * @param emp
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Removes an employee. Returns true on successful removal,
	 *            otherwise false.
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "emp"
	 * @return the return type minus the qualified name
	 */
	public boolean deleteEmployee(Employee emp)
	{
		if(m_map.containsKey(emp.getLastName()))
		{
			m_map.remove(emp.getLastName());
			return true;
		}
		return false;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getEmployeeByName(String lastname)
	 * @param lastname
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Retrieve an employee by their last name
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "lastname"
	 * @return the return type minus the qualified name
	 */
	public Employee getEmployeeByName(String lastname)
	{
		return m_map.get(lastname);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getEmployees()
	 * @param override
	 *            None
	 * @param comment
	 *            Returns the full list of employees
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public List<Employee> getEmployees()
	{
		return m_map.values().stream().collect(Collectors.toList());
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getSize()
	 * @param override
	 *            None
	 * @param comment
	 *            Returns the number of employees
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public int getSize()
	{
		return m_map.size();
	}

	private HashMap<String, Employee> m_map;

}
