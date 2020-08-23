package hardik.personal.ppmtool.Controller;

import hardik.personal.ppmtool.domain.Project;
import hardik.personal.ppmtool.services.MapValidationErrorService;
import hardik.personal.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    private Validator validator;

    @PostMapping("")
    public ResponseEntity<?> createProject( @Valid  @RequestBody Project project , BindingResult bindingResult)
    {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(bindingResult);
        if(errorMap!=null)
            return errorMap;
        projectService.saveOrUpdateProject(project);
         return new ResponseEntity<Project>(project,HttpStatus.OK);

    }

}
