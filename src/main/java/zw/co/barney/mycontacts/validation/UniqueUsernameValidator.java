package zw.co.barney.mycontacts.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import zw.co.barney.mycontacts.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/22/2019 7:32 PM
 */
@Slf4j
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

   private UserService userService;
   private String message;

   @Autowired
   public UniqueUsernameValidator(UserService userService) {
      this.userService = userService;
   }



   @Override
   public void initialize(UniqueUsername constraintAnnotation) {
      this.message = constraintAnnotation.message();

   }

   @Override
   public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
      boolean valid = true;
      log.debug("trying to validate =>" + username);
      try{
         valid = username != null && this.userService.getUserByUsername(username) == null;
      }catch (Exception e){
         log.debug("an exception was caught trying to validate =>" + username);
      }
      if (!valid){
         constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
      }
      return valid;
   }
}
