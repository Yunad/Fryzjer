package com.auth.validator;

import com.fryzjerappbackend.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
//
//    @Autowired
//    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","NotEmpty");
        if(user.getPassword().length()<8 || user.getPassword().length()>32){
            errors.rejectValue("password","Size.userForm.password");
        }

        if(!user.getPassword().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");
        }
    }
}
