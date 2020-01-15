package ru.itmo.wp.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.exception.ValidationException;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.form.UserRegisterCredentials;
import ru.itmo.wp.form.validator.UserCredentialsEnterValidator;
import ru.itmo.wp.form.validator.UserRegisterCredentialsValidator;
import ru.itmo.wp.service.JwtService;
import ru.itmo.wp.util.BindingResultUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1")
public class JwtController extends ApiController {
    private final JwtService jwtService;
    private final UserCredentialsEnterValidator userCredentialsEnterValidator;
    private final UserRegisterCredentialsValidator userRegisterCredentialsValidator;

    public JwtController(JwtService jwtService, UserCredentialsEnterValidator userCredentialsEnterValidator, UserRegisterCredentialsValidator userRegisterCredentialsValidator) {
        this.jwtService = jwtService;
        this.userCredentialsEnterValidator = userCredentialsEnterValidator;
        this.userRegisterCredentialsValidator = userRegisterCredentialsValidator;
    }

    @InitBinder("userCredentials")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCredentialsEnterValidator);
    }

    @InitBinder("userRegisterCredentials")
    public void intBinder(WebDataBinder binder) {binder.addValidators(userRegisterCredentialsValidator);}

    @PostMapping("jwt_register")
    public String createJwtRegister(@RequestBody @Valid UserRegisterCredentials userRegisterCredentials, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(BindingResultUtils.getErrorMessage(bindingResult));
        }

        return jwtService.register(userRegisterCredentials);
    }

    @PostMapping("jwt")
    public String createJwt(@RequestBody @Valid UserCredentials userCredentials, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(BindingResultUtils.getErrorMessage(bindingResult));
        }

        return jwtService.create(userCredentials.getLogin(), userCredentials.getPassword());
    }
}
