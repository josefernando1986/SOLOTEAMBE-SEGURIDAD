package SOLOTEAMBE.seguridad.Repositorios;

import SOLOTEAMBE.seguridad.Modelos.PermisoRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermisosRoles extends MongoRepository<PermisoRol, String> {
}
