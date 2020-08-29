package hardik.personal.ppmtool.repositories;


import hardik.personal.ppmtool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRespository extends CrudRepository<Backlog,Long> {







}
