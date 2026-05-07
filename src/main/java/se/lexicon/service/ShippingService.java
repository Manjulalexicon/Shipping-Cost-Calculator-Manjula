package se.lexicon.service;

import org.springframework.stereotype.Service;
import se.lexicon.model.ShippingRequest;

import java.math.BigDecimal;

@Service
public class ShippingService {
    private final ShippingCalculatorFactory factory;

    public ShippingService(ShippingCalculatorFactory factory) {
        this.factory = factory;
    }

    public BigDecimal quote(ShippingRequest req) {
        ShippingCostCalculator calc = factory.getCalculator(req);
        return calc.calculate(req);
    }
}
