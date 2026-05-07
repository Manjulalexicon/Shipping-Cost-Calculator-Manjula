package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import java.math.BigDecimal;

@Component
public class StandardInternationalShipping implements ShippingCostCalculator {

    @Value("${shipping.international.standard.base}")
    private BigDecimal base;

    @Value("${shipping.international.standard.perkg}")
    private BigDecimal perKg;

    @PostConstruct
    public void init() {
        System.out.println("StandardInternationalShipping bean created");
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL &&
                r.speed() == Speed.STANDARD;
    }

    @Override
    public BigDecimal calculate(ShippingRequest r) {
        return base.add(perKg.multiply(r.weightKg()));
    }
}
