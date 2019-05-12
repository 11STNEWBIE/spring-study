/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.config;

import com.springrecipes.ch03.ch031.court.domain.PeriodicReservation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PeriodReservationValidator implements Validator {
    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return PeriodicReservation.class.isAssignableFrom(clazz);
    }

    /**
     * Validate the supplied {@code target} object, which must be
     * of a {@link Class} for which the {@link #supports(Class)} method
     * typically has (or would) return {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors.
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     * @see ValidationUtils
     */
    @Override
    public void validate(Object target, Errors errors) {
        validateCourt(target, errors);
        validateTime(target, errors);
        validatePlayer(target, errors);
    }

    public void validatePlayer(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "player.name", "required.playerName", "Player name is required.");
    }

    public void validateTime(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "fromDate", "required.fromDate", "From date is required.");
        ValidationUtils.rejectIfEmpty(errors, "toDate", "required.toDate", "To date is required.");
        ValidationUtils.rejectIfEmpty(errors, "period", "required.period", "Period is required.");
        ValidationUtils.rejectIfEmpty(errors, "hour", "required.hour", "Hour is required.");
    }

    public void validateCourt(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courtName",
                "required.courtName", "Court name is required.");
    }
}
