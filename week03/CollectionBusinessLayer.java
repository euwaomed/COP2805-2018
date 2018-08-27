/**
 * 
 */
package week03;

import java.util.ArrayList;
import java.util.List;

/**
 * The CollectionBusinessLayer class uses both the DataLayer and the Employee
 * classes so we implement it after we have implemented the previous two.
 * 
 * @author eomed
 *
 */

public class CollectionBusinessLayer
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            CollectionBusinessLayer()
	 * @param override
	 *            None
	 * @param comment
	 *            Constructor
	 * @param visiblity
	 *            public
	 */
	public CollectionBusinessLayer()
	{
		List<Employee> list = new ArrayList<>();
		m_data = new DataLayer(list);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            CollectionBusinessLayer(List<Employee> list)
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
	public CollectionBusinessLayer(List<Employee> list)
	{
		m_data = new DataLayer(list);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            addEmployee(String first, String last, double salary)
	 * @param first
	 *            Parameter
	 * @param last
	 *            Parameter
	 * @param salary
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Add a new employee
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "first", "last", "salary"
	 * @return Get the return type
	 */
	public Employee addEmployee(String first, String last, double salary)
	{
		Employee emp = new Employee(first, last, salary);
		m_data.addEmployee(emp);
		return emp;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            changeEmployeeSalary(String last, double newSalary)
	 * @param last
	 *            Parameter
	 * @param newSalary
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Updates a specific employee's salary. Returns true if
	 *            successful, otherwise false
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "last", "newSalary"
	 * @return Get the return type
	 */
	public boolean changeEmployeeSalary(String last, double newSalary)
	{
		Employee emp = m_data.getEmployeeByName(last);
		if(emp == null)
		{
			return false;
		}
		else
		{
			emp.setSalary(newSalary);
			return true;
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            deleteEmployee(String last)
	 * @param last
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Delete the requested employee. Return the old Employee
	 *            instance. May be null if not found
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "last"
	 * @return Get the return type
	 */
	public Employee deleteEmployee(String last)
	{
		Employee emp = m_data.getEmployeeByName(last);
		if(emp == null)
		{
			return null;
		}

		if(m_data.deleteEmployee(emp))
		{
			return emp;
		}
		return null;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            listAllEmployees()
	 * @param override
	 *            None
	 * @param comment
	 *            Get the list of all employees
	 * @param visiblity
	 *            public
	 * @return Get the return type
	 */
	public List<Employee> listAllEmployees()
	{
		return m_data.getEmployees();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            listEmployee(String last)
	 * @param last
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Get the specified employee by their last name
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "last"
	 * @return Get the return type
	 */
	public Employee listEmployee(String last)
	{
		return m_data.getEmployeeByName(last);
	}

	private DataLayer m_data;
}