package org.acme;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/motorcycles")
public class MotorcyclesController {
    Map<Long, Motorcycle> motorcyclesList = new HashMap<>();

    public MotorcyclesController() {
        this.motorcyclesList.put(1L, new Motorcycle(1L, "Harley-Davidson", "Sportster Iron 883", 2022, 53, "68 Nm", "Cruiser-style motorcycle with a classic look."));
        this.motorcyclesList.put(2L, new Motorcycle(2L, "Honda", "CBR600RR", 2021, 120, "66 Nm", "Sportbike known for its performance and agility."));
        this.motorcyclesList.put(3L, new Motorcycle(3L, "Ducati", "Panigale V4", 2023, 214, "124 Nm", "High-performance sportbike with cutting-edge technology."));
        this.motorcyclesList.put(4L, new Motorcycle(4L, "Yamaha", "YZF-R3", 2022, 42, "29.6 Nm", "Lightweight sportbike suitable for beginners."));
        this.motorcyclesList.put(5L, new Motorcycle(5L, "Kawasaki", "Ninja 400", 2021, 49, "38 Nm", "Versatile and learner-friendly sportbike."));
        this.motorcyclesList.put(6L, new Motorcycle(6L, "BMW", "S1000RR", 2023, 205, "113 Nm", "Superbike with advanced electronics and performance."));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMotorcycles() {
        return new Gson().toJson(this.motorcyclesList);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMotorcycleById(@PathParam("id") Long id) {
        return new Gson().toJson(this.motorcyclesList.get(id));
    }

}
