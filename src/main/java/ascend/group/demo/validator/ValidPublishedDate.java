package ascend.group.demo.validator;

import java.lang.annotation.*;
import jakarta.validation.Payload;
import jakarta.validation.Constraint;

@Documented
@Constraint(validatedBy = PublishedDateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPublishedDate {
    String message() default "Invalid published date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}