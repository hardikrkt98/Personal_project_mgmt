package hardik.personal.ppmtool.services;

import hardik.personal.ppmtool.domain.Project;
import hardik.personal.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ProjectService {

      @Autowired
    ProjectRepository projectRepository;



    public Project saveOrUpdateProject(Project project)
      {


          return projectRepository.save(project);


      }

     public Project findByProjectIdentifier(String id)
     {
         return  projectRepository.findByProjectIdentifier(id);

     }

     public Iterable<Project> findAll()
     {
         return projectRepository.findAll();



     }

     public  void  deleteById(Project project)
     {
        projectRepository.delete(project);

     }



}
