package zw.co.barney.mycontacts.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/22/2019 4:39 PM
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordPolicyValidator.class)
public @interface PasswordPolicy  {

    String message() default "Password is not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
