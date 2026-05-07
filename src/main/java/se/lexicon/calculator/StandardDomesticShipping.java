package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import java.math.BigDecimal;

@Component
public class StandardDomesticShipping implements ShippingCostCalculator {

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " initialized");
    }
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD;
    }

    @Override
    public BigDecimal calculate(ShippingRequest r) {

        BigDecimal base = BigDecimal.valueOf(5);
        BigDecimal perKg = BigDecimal.valueOf(1.2);

        return base.add(perKg.multiply(r.weightKg()));
    }
}