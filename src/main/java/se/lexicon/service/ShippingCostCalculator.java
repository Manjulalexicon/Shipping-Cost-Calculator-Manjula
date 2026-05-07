package se.lexicon.service;

import se.lexicon.model.ShippingRequest;

import java.math.BigDecimal;

public interface ShippingCostCalculator {
    boolean supports(ShippingRequest req);

    BigDecimal calculate(ShippingRequest req);
}



