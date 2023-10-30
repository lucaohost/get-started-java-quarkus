package org.motorcycles.controller;

import com.google.gson.Gson;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.service.MotorcyclesService;

@Path("/motorcycles")
@RequestScoped
public class MotorcyclesController {

    private final Gson gson = new Gson();

    @Inject
    private MotorcyclesService motorcyclesService;

    public MotorcyclesController(MotorcyclesService motorcyclesService) {
        this.motorcyclesService = motorcyclesService;
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
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMotorcycle(@PathParam("id") Long id) {
        motorcyclesService.delete(id);
        return gson.toJson(Response.ok("success").build());
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createMotorcycle(String newMotorcycleJson) {
        Motorcycle newMotorcycle = getFromJson(newMotorcycleJson);
        motorcyclesService.save(newMotorcycle);
        return gson.toJson(newMotorcycle);
    }

    @PUT
    @Path("/{id}")
    public String updateMotorcycle(@PathParam("id") Long id, String updatedMotorcycleJson) {
        Motorcycle updatedMotorcycle = motorcyclesService.update(id, getFromJson(updatedMotorcycleJson));
        return gson.toJson(updatedMotorcycle);
    }

    private Motorcycle getFromJson(String updatedMotorcycleJson) {
        return gson.fromJson(updatedMotorcycleJson, Motorcycle.class);
    }
}
