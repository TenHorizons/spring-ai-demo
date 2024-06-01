package com.example.springaidemo;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.function.Function;

public class MockWeatherService implements Function<MockWeatherService.Request, MockWeatherService.Response> {

    @JsonClassDescription("Get the weather of a city")
    public record Request(
            @JsonPropertyDescription("The city name") String city,
            @JsonPropertyDescription("The temperature unit") Unit unit) {}

    public record Response(double temperature, Unit unit){}

    enum Unit {
        C("Metric Celsius"), F("Imperial Fahrenheit");
        public final String unitName;

        Unit(String text) {this.unitName = text;}
    }

    @Override
    public Response apply(Request request) {
        double temperature = switch(request.city) {
            case "London" -> 15;
            case "Tokyo" -> 25;
            case "Kuala Lumpur" -> 35;
            default -> 0;
        };

        temperature = (request.unit == Unit.F) ? (temperature * 9 / 5) + 32 : temperature;

        return new Response(temperature, request.unit);
    }
}
