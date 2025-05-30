package ascend.group.demo.validator;

import java.util.Date;
import java.util.Calendar;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PublishedDateValidator implements ConstraintValidator<ValidPublishedDate, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        int year = cal.get(Calendar.YEAR);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return year > 1000 && year <= currentYear;
    }
}