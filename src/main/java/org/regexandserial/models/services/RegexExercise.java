package org.regexandserial.models.services;

import org.springframework.stereotype.Service;

@Service
public class RegexExercise {

    public boolean isProperName(String name){
        String nameVerification = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
        return name.matches(nameVerification);
    }

    public boolean isProperSurname(String name){
        String surNameVerification = "([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})";
        return false;
    }

    public boolean isEmailAddress(String potentialEmail){
        String email_verification = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
        return potentialEmail.matches(email_verification);
    }

    public boolean isStreetCorrected(String potentialStreet){
        String streetVerification = "/ \\d*[a-zA-Z]?(\\/\\d+)?;$/";
        return potentialStreet.matches(streetVerification);
    }

    public boolean isPasswordSecure(String potentialPassword){
        String passwordValidation = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return potentialPassword.matches(passwordValidation);
    }

}
