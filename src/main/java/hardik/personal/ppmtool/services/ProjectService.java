package hardik.personal.ppmtool.services;

import hardik.personal.ppmtool.domain.Backlog;
import hardik.personal.ppmtool.domain.Project;
import hardik.personal.ppmtool.repositories.BacklogRespository;
import hardik.personal.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ProjectService {

      @Autowired
    ProjectRepository projectRepository;

@Autowired
    BacklogRespository backlogRespository;


    public Project saveOrUpdateProject(Project project)
      {

          if(project.getId()==null)
          {
              Backlog backlog = new Backlog();
              project.setBacklog(backlog);
              backlog.setProject(project);
              backlog.setProjectIdentifier(project.getProjectIdentifier());
          }

          if(project.getId()!=null)
          {

             project.setBacklog(backlogRespository.findByProjectIdentifier(project.getProjectIdentifier()));


          }

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
