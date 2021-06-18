package leo.repository;

import leo.model.VagasOrgao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasOrgaoRepository extends MongoRepository<VagasOrgao, String> {
}
