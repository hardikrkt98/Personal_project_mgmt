package hardik.personal.ppmtool.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Project {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotBlank(message="Project Name is required")
   private String projectName;

   @Size(max=5,min=4,
           message = "Should be minimum 4 length")
   @Column(updatable=false,unique = true)
   private String projectIdentifier;

    @NotBlank(message="Project description is required")
   private String description;

   @JsonFormat(pattern = "yyyy-mm-dd")
   private Date startDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_At;

   @PrePersist
    protected void onCreate()
   {
       this.created_At  = new Date();
   }
   @PreUpdate
    protected void onUpdate()
   {
       this.update_At = new Date();
   }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public Date getUpdate_At() {
        return update_At;
    }

    public Project() {
    }
}
