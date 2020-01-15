package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.form.UserRegisterCredentials;
import ru.itmo.wp.service.UserService;

@Component
public class UserRegisterCredentialsValidator implements Validator {
    private UserService userService;

    public UserRegisterCredentialsValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return UserRegisterCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserRegisterCredentials registerForm = (UserRegisterCredentials) target;
            if (userService.findByLogin(registerForm.getLogin()) != null) {
                errors.reject("login.login_is_used", "Login is used");
            }
        }
    }
}
