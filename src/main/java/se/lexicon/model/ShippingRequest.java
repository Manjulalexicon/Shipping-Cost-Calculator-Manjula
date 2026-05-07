package se.lexicon.model;


import java.math.BigDecimal;

public record ShippingRequest(Destination destination, Speed speed, BigDecimal weightKg) {
}
