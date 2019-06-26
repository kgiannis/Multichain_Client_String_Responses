package gr.yk.apacheHttp4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Class which contains static helper methods
 * 
 * @author Karavasilis Ioannis
 *
 */
public class CustomUtils {

	/**
	 * Take an array of objects and return 
	 * a single string with comma separated object items
	 * 
	 * @param params: the array of object parameters
	 * @return a single string with array items separated with commas
	 */
	protected static String separateParamsWithCommas(Object[] params) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (int counter = 0; counter < params.length; counter++) {
			
			if(params[counter] instanceof String) {
				sb.append("\"" + params[counter] + "\"");
			}
			
			if(params[counter] instanceof Boolean) {
				sb.append(params[counter]);
			}
			
			if(nextParamExist(counter, params)) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Check if array contains more items (parameters) or reached to its end.
	 * Use a counter to indicate the current position to start from. 
	 * 
	 * @param counter: the counter as starting point
	 * @param params: the array of object parameters
	 * @return if array contains more items or not
	 */
	private static boolean nextParamExist(int counter, Object[] params) {
		return counter - params.length != -1;
	}
	
	/**
	 * Pretty print a string representing a JSON
	 * @param uglyString: the string representation of the JSON
	 * @return the string as pretty printed
	 */
	private static String prettyPrintString(String uglyString) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Object obj = gson.fromJson(uglyString, Object.class);
		return gson.toJson(obj);
	}
	
	/**
	 * Print string on console
	 * @param response: the string 
	 */
	protected static void showResponse(String response) {
		System.out.println(prettyPrintString(response));
	}
}
