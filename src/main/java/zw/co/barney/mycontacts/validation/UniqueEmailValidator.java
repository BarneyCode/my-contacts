package zw.co.barney.mycontacts.validation;

import zw.co.barney.mycontacts.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/22/2019 4:57 PM
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && this.userService.getUserByEmail(email) == null;


    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }
}
