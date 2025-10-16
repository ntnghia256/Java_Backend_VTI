package com.vti.ProductManagement.utils;

public class EmailUtils {
	public static boolean isValidEmail(String email) {
		String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(regex);
	}

	public static boolean isValidLocalPartInEmail(String localPart) {

		if (localPart == null) {
			return false;
		} else {
			if (localPart.contains(".")) {
				return false;
			} else {
				if (isContainSpecialSymbol(localPart)) {
					return false;
				} else {
					return true;
				}
			}
		}

	}

	public static boolean isValidDomainInEmail(String domain) {

		if (isContainSpecialSymbol(domain)) {
			return false;
		} else {
			return true;
		}

	}

	public static String[] splitEmail(String email) {
		while (true) {
			if (email == null || !email.contains("@")) {
				System.err.println("Re-enter!");
			} else {
				String[] part = email.split("@", 2);

				if (part.length != 2) {
					System.err.println("Re-enter!");
				} else {
					return part;
				}
			}
		}
	}

	public static boolean isContainSpecialSymbol(String input) {
		String regex = "^[^!#$%&‘*+–/=\\?^_`\\{\\|\\}~]*$";
		return !input.matches(regex);
	}
}
