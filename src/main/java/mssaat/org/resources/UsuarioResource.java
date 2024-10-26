package mssaat.org.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mssaat.org.DTO.UsuarioDTO;
import mssaat.org.DTO.UsuarioResponseDTO;
import mssaat.org.service.UsuarioService;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    public UsuarioService usuarioService;

    @GET
    @RolesAllowed({ "Usuario" })
    public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(usuarioService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return usuarioService.count();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        UsuarioResponseDTO user = usuarioService.findById(id);
        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/username/{content}")
    public Response findByUsername(@PathParam("content") String content, @QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(usuarioService.findByUsername(content, page, pageSize)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/email/{email}")
    public Response findByEmail(@PathParam("email") String email, @QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(usuarioService.findByEmail(email, page, pageSize)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf, @QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(usuarioService.findByCpf(cpf, page, pageSize)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/endereco/{endereco}")
    public Response findByEndereco(@PathParam("endereco") String endereco, @QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(usuarioService.findByEndereco(endereco, page,pageSize)).build();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response create(UsuarioDTO userDto) {
        return Response.status(Status.CREATED).entity(usuarioService.create(userDto)).build();
    }

    @PUT
    @RolesAllowed({ "Usuario" })
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, UsuarioDTO userDto) {
        UsuarioResponseDTO usuarioBanco = usuarioService.findById(id);
        if (usuarioBanco == null)
            return Response.status(Status.NOT_FOUND).build();
        usuarioService.update(id, userDto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed({ "Usuario" })
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        usuarioService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}