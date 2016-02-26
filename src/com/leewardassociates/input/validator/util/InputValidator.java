package com.leewardassociates.input.validator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class InputValidator {

    public static boolean validateRequired(String value) {
	return StringUtils.isNotBlank(value);
    }

    public static boolean validateInt(String value) {
	return StringUtils.isNumeric(value);
    }

    public static boolean validateLength(String value, int minLength,
	    int maxLength) {
	String validatedValue = value;
	if (!validateRequired(value)) {
	    validatedValue = "";
	}
	int length = StringUtils.length(validatedValue);
	return length >= minLength && length <= maxLength;
    }

    public static boolean validateRange(int value, int min, int max) {
	return (value >= min && value <= max);
    }

    public static boolean validateOption(Object[] options, Object value) {
	boolean isValidValue = false;
	try {
	    List<Object> list = Arrays.asList(options);
	    if (list != null) {
		isValidValue = list.contains(value);
	    }
	} catch (Exception e) {
	}
	return isValidValue;
    }

    public static boolean matchPattern(String value, String expression) {
	boolean match = false;
	if (validateRequired(expression)) {
	    match = Pattern.matches(expression, value);
	}
	return match;
    }

    public static String filter(String value) {
	if (StringUtils.isBlank(value)) {
	    return "";
	}
	StringBuffer result = new StringBuffer(value.length());
	for (int i = 0; i < value.length(); ++i) {
	    switch (value.charAt(i)) {
	    case '<':
		result.append("&lt;");
		break;
	    case '>':
		result.append("&gt;");
		break;
	    case '"':
		result.append("&quot;");
		break;
	    case '\'':
		result.append("&#39;");
		break;
	    case '%':
		result.append("&#37;");
		break;
	    case ';':
		result.append("&#59;");
		break;
	    case '(':
		result.append("&#40;");
		break;
	    case ')':
		result.append("&#41;");
		break;
	    case '&':
		result.append("&amp;");
		break;
	    case '+':
		result.append("&#43;");
		break;
	    default:
		result.append(value.charAt(i));
		break;
	    }
	}
	return result.toString();
    }
    
    /**
     * Tests if a specific input can be converted to a specific type
     * 
     * @param input The input to test. Accepts String, int, double, or float.
     * @param type Which type to test against.  Accepts 'int', 'float', or 'double'.
     * @return True if can be transformed to requested type. False otherwise.
     */
    public boolean isType(String input, String type) {
	try {
	    switch (type) {
                case "float":
                Float.parseFloat(input);
                break;
                case "int":
                Integer.parseInt(input);
                break;
                case "double":
                Double.parseDouble(input);
                break;
                default:
                    return false;
	    }
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

}
