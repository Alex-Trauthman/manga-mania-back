package mssaat.org.resources;

import org.jboss.logging.Logger;

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
import mssaat.org.DTO.AdministradorDTO;
import mssaat.org.DTO.AdministradorResponseDTO;
import mssaat.org.DTO.UsuarioDTO;
import mssaat.org.DTO.UsuarioResponseDTO;
import mssaat.org.service.AdministradorService;
import mssaat.org.service.UsuarioService;
import mssaat.org.validation.BeanValidationExceptionMapper;

@Path("/administradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdministradorResource {
    @Inject
    public AdministradorService administradorService;

    @Inject
    public UsuarioService usuarioService;

    private static final Logger LOG = Logger.getLogger(BeanValidationExceptionMapper.class);

    @GET
    @RolesAllowed("Administrador")
    public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        LOG.info("Listando todos os administradores.");
        return Response.ok(administradorService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("Administrador")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Obtendo administrador por id.");
        AdministradorResponseDTO user = administradorService.findById(id);
        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed("Administrador")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Listando administradores por nome.");
        return Response.ok(administradorService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/email/{email}")
    @RolesAllowed("Administrador")
    public Response findByEmail(@PathParam("email") String email) {
        LOG.info("Listando administradores por email.");
        return Response.ok(administradorService.findByEmail(email)).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    @RolesAllowed("Administrador")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.info("Listando administradores por cpf.");
        return Response.ok(administradorService.findByCpf(cpf)).build();
    }

    @POST
    @Path("/create")
    @RolesAllowed("Administrador")
    @Transactional
    public Response create(AdministradorDTO adminDto) {
        LOG.info("Criando administrador.");
        LOG.debugf("%s", adminDto);
        return Response.status(Status.CREATED).entity(administradorService.create(adminDto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Administrador")
    @Transactional
    public Response update(@PathParam("id") Long id, AdministradorDTO adminDto) {
        LOG.info("Atualizando administrador.");
        LOG.debugf("%s", adminDto);
        AdministradorResponseDTO adminBanco = administradorService.findById(id);
        if (adminBanco == null)
            return Response.status(Status.NOT_FOUND).build();
        administradorService.update(id, adminDto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PUT
    @RolesAllowed("Administrador")
    @Path("/usuarios/edit/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, UsuarioDTO userDto) {
        LOG.info("Atualizando usuário.");
        LOG.debugf("DTO: %s", userDto);
        UsuarioResponseDTO usuarioBanco = usuarioService.findById(id);
        if (usuarioBanco == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        usuarioService.update(id, userDto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Administrador")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        LOG.info("Apagando administrador");
        administradorService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}