package hardik.personal.ppmtool.repositories;

import hardik.personal.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {


    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

    @Override
    <S extends Project> S save(S s);

    Project findByProjectIdentifier(String identifier);

    @Override
    Iterable<Project> findAll();


    Project deleteByProjectIdentifier(String Id);


}
