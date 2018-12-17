/**
 * 
 */
package br.com.juliogriebeler.imdbsearcher.utils;

/**
 * @author Julio
 *
 */
public class ValidationUtils {
	
	public static boolean isEmptyField(String value){
		return value==null || value.isEmpty() || value.equals(Constants.EMPTY_FIELD);
	}

}
