package se.lexicon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingService;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShippingService shippingService;

    public ConsoleRunner(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public void run(String... args) {

        ShippingRequest request =
                new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10);

        System.out.println("Cost: " + shippingService.quote(request));
    }
}