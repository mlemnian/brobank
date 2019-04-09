package net.brobank.user.boundary;

import net.brobank.user.entity.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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

    @PersistenceContext(unitName = "brobank-db")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return em.createNativeQuery("select * from user", User.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void insert(User newUser) {
        logger.warning(newUser.toString());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        for (ConstraintViolation<User> violation : violations) {
            logger.severe(violation.getMessage());
        }

        em.persist(newUser);
    }
}
