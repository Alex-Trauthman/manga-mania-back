package mssaat.org.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mssaat.org.DTO.MangaDTO;
import mssaat.org.service.MangaServiceImpl;

@Path("/manga")
public class MangaResource {
    
    @Inject MangaServiceImpl mangaService;

    @GET
     public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(mangaService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(mangaService.findById(id)).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name")String name) {
        return Response.ok(mangaService.findByName(name)).build();
    }

    @GET
    @Path("/autor/{autorId}")
    public Response findByAutor(@PathParam("autorId") long autorId) {
        return Response.ok(mangaService.findByAutor(autorId)).build();
    }

    @GET
    @Path("/genero/{genreId}")
    public Response findByGenre(@PathParam("genreId")int genreId) {
        return Response.ok(mangaService.findByGenre(genreId)).build();
    }

    @POST
    public Response create(MangaDTO manga) {
        return Response.status(Status.CREATED).entity(mangaService.create(manga)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, MangaDTO manga) {
        mangaService.update(id, manga);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        mangaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
