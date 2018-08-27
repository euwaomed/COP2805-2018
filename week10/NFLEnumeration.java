/**
 * 
 */
package week10;

/**
 * @author eomed
 * 
 *         Description: This assignment exercises the enum type. Create an
 *         enumeration of NFL teams that provides some extended functionality.
 *         Use the text, references and reference code to learn and understand
 *         about the enum. Also, check out how the test harness uses your class
 *         to clearly understand what you need to provide.
 *
 */
public enum NFLEnumeration
{

	PACKERS("Green Bay"), PATRIOTS("Boston"), SEAHAWKS("Seattle"), COWBOYS(
			"Dallas"), BILLS("Buffalo"), BEARS(
					"Chicago"), STEELERS("Pittsburgh"), CARDINALS(
							"Phoenix"), BROWNS("Cleveland"), GIANTS(
									"New York"), JETS("New York"), FORTYNINERS(
											"San Francisco"), RAIDERS(
													"Oakland"), JAGUARS(
															"Jacksonville"), DOLPHINS(
																	"Miami"), BRONCOS(
																			"Denver"), TEXANS(
																					"Houston"), RAVENS(
																							"Baltimore"), REDSKINS(
																									"Washington"), RAMS(
																											"Los Angeles"), TITANS(
																													"Tennessee"), VIKINGS(
																															"Minneapolis"), LIONS(
																																	"Detroit"), COLTS(
																																			"Indianapolis"), BENGALS(
																																					"Cincinnati"), EAGLES(
																																							"Philadelphia"), CHIEFS(
																																									"Kansas City"), PANTHERS(
																																											"Charlotte"), BUCCANEERS(
																																													"Tampa Bay"), FALCONS(
																																															"Atlanta"), CHARGERS(
																																																	"San Diego"), SAINTS(
																																																			"New Orleans");

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            m_city
	 * @param override
	 *            None
	 * @param comment
	 *            readOnly
	 * @param visiblity
	 *            private
	 */
	private final String m_city;

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            city()
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public String city()
	{
		return m_city;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            NFLEnumeration(String city)
	 * @param city
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Helper method
	 * @param visiblity
	 *            private
	 */
	private NFLEnumeration(String city)
	{
		m_city = city;
	}

}