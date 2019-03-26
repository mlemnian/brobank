package net.brobank.user.boundary;

import net.brobank.user.entity.User;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Stateless
@Path("/users")
public class UserService {

    private static Logger logger = Logger.getLogger(UserService.class.getName());

    @PersistenceContext(unitName = "brobank")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return Arrays.asList(new User(1L, "nob", "iafgWEIZGFEWIUFIWEUOGFWEODIHWQDSJBhhbferbifb",
                "lemmi", "test", "martin.lemnian@gmail.com", "",
                ZonedDateTime.now(), ZonedDateTime.now()));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Counted(monotonic = true)
    public void insert(User newUser) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        for (ConstraintViolation<User> violation : violations) {
            logger.severe(violation.getMessage());
        }
    }
}
