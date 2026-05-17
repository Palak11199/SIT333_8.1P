package web.service;

public class LoginService {

	public static boolean login(
	        String username,
	        String password,
	        String dob) {

	    String validUsername = "palak";
	    String validPassword = "palak_pass";
	    String validDob = "1990-01-01";

	    if(username == null ||
	       password == null ||
	       dob == null) {

	        return false;
	    }

	    return username.equals(validUsername)
	            && password.equals(validPassword)
	            && dob.equals(validDob);
	}
}