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
public class ExpressDomesticShipping implements ShippingCostCalculator {

    @Value("${shipping.domestic.express.base}")
    private BigDecimal base;

    @Value("${shipping.domestic.express.perkg}")
    private BigDecimal perKg;

    @PostConstruct
    public void init() {
        System.out.println("ExpressDomesticShipping bean created");
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC &&
                r.speed() == Speed.EXPRESS;
    }

    @Override
    public BigDecimal calculate(ShippingRequest r) {
        return base.add(perKg.multiply(r.weightKg()));
    }
}

