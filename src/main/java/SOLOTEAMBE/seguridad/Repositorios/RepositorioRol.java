package SOLOTEAMBE.seguridad.Repositorios;

import SOLOTEAMBE.seguridad.Modelos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository<Rol, String> {
}
