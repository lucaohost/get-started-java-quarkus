package org.motorcycles.controller;

import com.google.gson.Gson;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.service.MotorcyclesService;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Path("/motorcycles")
@RequestScoped
public class MotorcyclesController {

    private final Map<Long, Motorcycle> motorcyclesList = new HashMap<>();

    private final Gson gson = new Gson();

    @Inject
    private MotorcyclesService motorcyclesService;

    public MotorcyclesController(MotorcyclesService motorcyclesService) {
        this.motorcyclesService = motorcyclesService;
        this.populate();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMotorcycles() {
        return gson.toJson(motorcyclesService.getAll());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMotorcycleById(@PathParam("id") Long id) {
        return gson.toJson(motorcyclesService.getById(id));
    }

    @DELETE
    @Path("/{id}")
    public String deleteMotorcycle(@PathParam("id") Long id) {
        if (motorcyclesList.containsKey(id)) {
            Motorcycle deletedMotorcycle = motorcyclesList.remove(id);
            return gson.toJson(deletedMotorcycle);
        } else {
            throw new NotFoundException("Motorcycle with ID " + id + " not found");
        }
    }
//
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createMotorcycle(String newMotorcycleJson) {
        Motorcycle newMotorcycle = gson.fromJson(newMotorcycleJson, Motorcycle.class);
        motorcyclesService.saveMotorcycle(newMotorcycle);
        return gson.toJson(newMotorcycle);
    }

    @PUT
    @Path("/{id}")
    public String updateMotorcycle(@PathParam("id") Long id, String updatedMotorcycleJson) {
        Motorcycle updatedMotorcycle = gson.fromJson(updatedMotorcycleJson, Motorcycle.class);
        if (motorcyclesList.containsKey(id)) {
            motorcyclesList.put(id, updatedMotorcycle);
            return gson.toJson(updatedMotorcycle);
        } else {
            throw new NotFoundException("Motorcycle with ID " + id + " not found");
        }
    }


    private Long generateUniqueId() {
        return motorcyclesList.size() + 1L;
    }


    private void populate() {
        motorcyclesList.put(1L, new Motorcycle(1L, "Harley-Davidson", "Sportster Iron 883",
                2022, 53, "68 Nm", "Cruiser-style motorcycle with a classic look."));
        motorcyclesList.put(2L, new Motorcycle(2L, "Honda", "CBR600RR",
                2021, 120, "66 Nm", "Sportbike known for its performance and agility."));
        motorcyclesList.put(3L, new Motorcycle(3L, "Ducati", "Panigale V4",
                2023, 214, "124 Nm", "High-performance sportbike with cutting-edge technology."));
        motorcyclesList.put(4L, new Motorcycle(4L, "Yamaha", "YZF-R3",
                2022, 42, "29.6 Nm", "Lightweight sportbike suitable for beginners."));
        motorcyclesList.put(5L, new Motorcycle(5L, "Kawasaki", "Ninja 400",
                2021, 49, "38 Nm", "Versatile and learner-friendly sportbike."));
        motorcyclesList.put(6L, new Motorcycle(6L, "BMW", "S1000RR",
                2023, 205, "113 Nm", "Superbike with advanced electronics and performance."));
    }

    public Map<Long, Motorcycle> getMotorcyclesList() {
        return motorcyclesList;
    }
}
