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
import mssaat.org.DTO.UsuarioDTO;
import mssaat.org.DTO.UsuarioResponseDTO;
import mssaat.org.service.UsuarioService;
import mssaat.org.validation.BeanValidationExceptionMapper;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    public UsuarioService usuarioService;

    private static final Logger LOG = Logger.getLogger(BeanValidationExceptionMapper.class);

    @GET
    @RolesAllowed({ "Usuario" })
    public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        LOG.info("Listando todos os usuários.");
        return Response.ok(usuarioService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Pesquisando usuário por Id.");
        UsuarioResponseDTO user = usuarioService.findById(id);
        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Pesquisando usuário por nome.");
        return Response.ok(usuarioService.findByNome(nome)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/email/{email}")
    public Response findByEmail(@PathParam("email") String email) {
        LOG.info("Pesquisando usuário por email.");
        return Response.ok(usuarioService.findByEmail(email)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.info("Pesquisando usuário por cpf.");
        return Response.ok(usuarioService.findByCpf(cpf)).build();
    }

    @GET
    @RolesAllowed({ "Usuario" })
    @Path("/search/endereco/{endereco}")
    public Response findByEndereco(@PathParam("endereco") String endereco) {
        LOG.info("Pesquisando usuário por endereço.");
        return Response.ok(usuarioService.findByEndereco(endereco)).build();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response create(UsuarioDTO userDto) {
        LOG.info("Criando usuário.");
        LOG.debugf("DTO: %s", userDto);
        return Response.status(Status.CREATED).entity(usuarioService.create(userDto)).build();
    }

    @PUT
    @RolesAllowed({ "Usuario" })
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, UsuarioDTO userDto) {
        LOG.info("Atualizando usuário.");
        LOG.debugf("DTO: %s", userDto);
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
        LOG.info("Deletando usuário.");
        usuarioService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}