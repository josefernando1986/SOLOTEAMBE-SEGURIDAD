package SOLOTEAMBE.seguridad.Repositorios;

import SOLOTEAMBE.seguridad.Modelos.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermiso extends MongoRepository<Permiso, String> {
}
