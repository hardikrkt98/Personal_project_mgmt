package hardik.personal.ppmtool.repositories;

import hardik.personal.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {


    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

    @Override
    <S extends Project> S save(S s);
}
