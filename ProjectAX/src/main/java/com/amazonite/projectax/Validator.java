package com.amazonite.projectax;

import android.util.Log;
import android.widget.EditText;
import java.util.regex.Pattern;

public class Validator {
    private static final String TAG = Validator.class.getSimpleName();
    // \w = [a-zA-Z_0-9] || \d = [0-9] || \s = whitespace[\t\n\x0B\f\r] || \Q : Quote all characters up to \E
    private static final String FORMAT_USER_NAME = "[\\w_ -'.,@]+";
    private static final String FORMAT_PERSON_NAME = "^[a-zA-Z '.,]*$";
    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );


    public static boolean isEmptyString(String stringValue){
        return stringValue == null || stringValue.trim().isEmpty();
    }

    public static String getStringValue(String stringValue){
        return (stringValue == null || stringValue.trim().isEmpty())? "" : stringValue.trim();
    }

    /**
     * Check if email string is valid format.
     *
     * @param email input string
     * @return boolean email format validation
     */
    public static boolean isValidEmail(String email) {
        return EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Person name limit character alphabet and some punctuations.
     *
     * @param name input string
     * @return boolean
     */
    public static boolean isPersonName(String name) {
        return name.matches(FORMAT_PERSON_NAME);
    }

    /**
     * Person name limit character alphabet and some punctuations.
     *
     * @param userName input string
     * @return boolean
     */
    public static boolean isUserName(String userName) {
        return userName.matches(FORMAT_USER_NAME);
    }

    public static boolean isValidField(EditText editText) {

        if(isEmptyString(getStringValue(editText.getText().toString()))){
            editText.setError("⚠ This field is required!");
            return false;
        }
        editText.setError(null);
        return true;
    }


    private static boolean isValidEmailField(EditText editText) {
        String value = getStringValue(editText.getText().toString());

        if(isEmptyString(value)){
            editText.setError("⚠ Email address field is empty!");
            return false;
        }

        if(!isValidEmail(value)){
            editText.setError("⚠ Please enter a valid email address!");
            return false;
        }
        else {
            editText.setError(null);
            return true;
        }
    }

    /**
     * Validate user name
     *
     * @param editText : UserName's EditText
     * @return Valid Format = true || Invalid = false
     */
    public static boolean isValidUserNameField(EditText editText) {
        String value = getStringValue(editText.getText().toString());

        if (isEmptyString(value)) {
            editText.setError("⚠ User Name field is empty!");
            return false;
        }
        if (!isUserName(value)) {
            editText.setError("⚠ Invalid user name!");
            return false;
        }
        else {
            editText.setError(null);
            return true;
        }
    }

    /**
     * Validate Person name
     *
     * @param editText : PersonName's EditText
     * @return Valid Format = true || Invalid = false
     */
    public static boolean isValidPersonNameField(EditText editText) {
        String value = getStringValue(editText.getText().toString());

        if (isEmptyString(value)) {
            editText.setError("⚠ Name field is empty!");
            return false;
        }
        if (!isPersonName(value)) {
            editText.setError("⚠ Invalid name!");
            return false;
        }
        else {
            editText.setError(null);
            return true;
        }
    }


    public static boolean isValidPasswordField(EditText editText)  {
        String value = getStringValue(editText.getText().toString());

        if (isEmptyString(value)) {
            editText.setError("⚠ Please enter a valid password!");
            return false;
        }

        if (value.length() < 8) {
            editText.setError("⚠ Password must contain at least 8 characters");
            return false;
        }

        if (value.length() > 30) {
            editText.setError( "⚠ Password should not be greater than 30 characters");
            return false;
        }
        else {
            editText.setError(null);
            return true;
        }
    }


    public static boolean isBothEmailPasswordValid(EditText email, EditText password) {
        if(!isValidEmailField(email)) return false;
        return isValidPasswordField(password);
    }


    public static boolean isBothPasswordsValid(EditText password, EditText confirmPassword) {
        if(!isValidPasswordField(password)) return false;
        if(!isValidPasswordField(confirmPassword)) return false;


        if (!getStringValue(password.getText().toString()).equals(getStringValue(confirmPassword.getText().toString()))) {
            confirmPassword.setError( "⚠ Entered password is mismatched!");
            return false;
        }
        else {
            confirmPassword.setError(null);
            return true;
        }
    }


    public static boolean isValidNumberField(EditText editText) {
        String value = getStringValue(editText.getText().toString());

        if (isEmptyString(value)) {
            editText.setError("⚠ This field is required!");
            return false;
        }

        try {
            if (Integer.parseInt(value) < 0) {
                editText.setError("⚠ Invalid input!");
                return false;
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, "isValidNumberField: ", e);
            editText.setError("⚠ Invalid input!");
        }
        editText.setError(null);
        return true;
    }


    public static boolean isValidFloatNumberField(EditText editText) {
        String value = getStringValue(editText.getText().toString());

        if (isEmptyString(value)) {
            editText.setError("⚠ This field is required!");
            return false;
        }

        try {
            if (Float.parseFloat(value) < 0) {
                editText.setError("⚠ Invalid input!");
                return false;
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, "isValidFloatNumberField: ", e);
            editText.setError("⚠ Invalid input!");
        }
        editText.setError(null);
        return true;
    }
}