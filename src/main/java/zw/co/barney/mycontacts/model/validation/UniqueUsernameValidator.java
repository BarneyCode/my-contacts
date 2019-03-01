package zw.co.barney.mycontacts.model.validation;

import org.springframework.stereotype.Component;
import zw.co.barney.mycontacts.repository.UserRepository;
import zw.co.barney.mycontacts.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/22/2019 7:32 PM
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

   private UserService userService;

   public UniqueUsernameValidator(UserService userService) {
      this.userService = userService;
   }
   @Override
   public void initialize(UniqueUsername constraintAnnotation) {

   }

   @Override
   public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
      //return username != null && this.userService.getUserByUsername(username) == null;
      boolean valid = true;
      try {
         valid = username != null && userService.getUserByUsername(username) == null;
      } catch (Exception e) {

      }
      if (!valid) {
         constraintValidatorContext
                 .buildConstraintViolationWithTemplate("i do not know what it means")
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
      }
      return valid;
   }
}
