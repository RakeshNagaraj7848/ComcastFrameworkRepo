package com.practise3;

import org.testng.annotations.Test;

/* class java doc*/
/**
 * This class contains login method
 * 
 * @author Rakesh
 *
 */

public class JavaDocumentCreationTest {

	/* method java doc */
	/**
	 * login method it taking username password and url
	 * 
	 * @param username
	 * @param password
	 * @param url
	 */
  
	@Test
	public void loginToApplicationTest(String username, String password, String url) {
		/* entering username */
		System.out.println(" entering username");
		/* entering password */ /* single line comment */
		System.out.println(" enterning password");
		/* clicking on login button */
		System.out.println("  click on login button");
		System.out.println(" login to application");

		/**
		 * this is login method ---------------multi line code entering url entering
		 * password entering passwor
		 **/

	}

}
