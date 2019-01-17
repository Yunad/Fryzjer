package com.auth.validator;

import com.fryzjerappbackend.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Name cannot be empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Last name cannot be empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email cannot be empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password cannot be empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleId", "role id cannot be empty");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 64) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
}
