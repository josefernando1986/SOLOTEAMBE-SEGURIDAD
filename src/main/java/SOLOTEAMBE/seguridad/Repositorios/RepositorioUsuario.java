package SOLOTEAMBE.seguridad.Repositorios;
import SOLOTEAMBE.seguridad.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
}
