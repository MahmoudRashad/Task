package com.rashad.app.utils


import java.util.regex.Pattern



//Email Pattern
private const val EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
//Email Pattern
//Minimum eight characters, at least one letter and one number:
//
//"^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
//Minimum eight characters, at least one letter, one number and one special character:
//
//"^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"
//Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:
//
//"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
//Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:
//
//"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"

private const val PASSWORD_PATTERN = ("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")

private const val FULL_NAME =
    "^[a-zA-Z\\s-ءاأإآؤئبتثجحخدذرزسشصضطظعغفقكلمنهويةى]{4,}(?: [a-zA-Z\\s-ءاأإآؤئبتثجحخدذرزسشصضطظعغفقكلمنهويةى]+){1,3}$"


/**
 * Validate Email with regular expression
 *
 * @ email
 * Return true for Valid Email and false for Invalid Email
 */
fun String.isValidFullName(): Boolean {
    return Pattern.compile(FULL_NAME).matcher(this).matches()
}

fun String.isValidMail(): Boolean {
    return Pattern.compile(EMAIL_PATTERN).matcher(this).matches()
}

fun String.isValidPhone(): Boolean {
    return !Pattern.matches("^\\+[0-9]$", this) && this.length > 6

}

fun String.isValidPassword(): Boolean {
    return this.length > 5
//    return Pattern.compile(PASSWORD_PATTERN).matcher(this).matches()
}



/**
 * Checks for Null String object
 *
 * @ txt
 * return true for not null and false for null String object
 */
fun isNotNull(txt: String?): Boolean {
    return txt != null && txt.trim { it <= ' ' }.isNotEmpty()
}


