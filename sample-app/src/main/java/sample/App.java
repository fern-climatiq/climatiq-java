package sample;

import java.lang.String;
import java.util.List;

import com.climatiq.api.ClimatiqApiClient;
import com.climatiq.api.client.emission.factor.types.EmissionFactor;
import com.climatiq.api.client.estimation.endpoints.Estimate;
import com.climatiq.api.client.flights.endpoints.TravelFlights;
import com.climatiq.api.client.flights.exceptions.TravelFlightsException;
import com.climatiq.api.client.flights.types.TravelFlightsRequest;
import com.climatiq.api.client.flights.types.TravelLeg;
import com.climatiq.api.core.BearerAuth;

public final class App {
  public static void main(String[] args) {
    String token = System.getenv("CLIMATIQ_API_KEY");

    BearerAuth auth = BearerAuth.of(token);

    ClimatiqApiClient climatiqApiClient =
            new ClimatiqApiClient("https://beta3.api.climatiq.io/", auth);

    try {
      TravelLeg travelLeg = TravelLeg.builder()
              .from("SEA")
              .to("SFO")
              ._class("business")
              .passengers(2)
              .build();

      TravelFlights travelFlights = climatiqApiClient.flights().travelFlights(TravelFlights.Request.builder()
              .body(TravelFlightsRequest.builder()
                      .legs(List.of(travelLeg))
                      .build())
              .build());

    } catch (TravelFlightsException e) {
      System.out.println("Failed to get an estimate" + e.getMessage());
    }
      )
    }
  }
}
