/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.websecurity;

public class SecurityConstant {
	public static final long EXPIRATION_TIME  = 864000000;  				// Experation date of the token
	public static final String TOKEN_PREFIX  = "Bearer ";					// Prefix of the token
	public static final String HEADER_STRING ="Authorization" ;   			// Header name
	public static final String SINGN_UP_URL = "/users/signUp"  ;
	public static final String SINGN_IN_URL = "/users/signIn"  ;

	public static final String TOKEN_SECRET  = "hnada$wxctaqjhsuamxt$q";	// Secret key for encryption
}
