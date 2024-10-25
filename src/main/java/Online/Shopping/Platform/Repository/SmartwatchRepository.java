package Online.Shopping.Platform.Repository;

import Online.Shopping.Platform.Entity.Smartwatch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SmartwatchRepository extends MongoRepository<Smartwatch, String> {}
