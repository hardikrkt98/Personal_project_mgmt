package hardik.personal.ppmtool.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Backlog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer PTSequence = 0;
    private String projectIdentifier;

    //Onetone with Project

    //OnetoMany projectTasks


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "project_id",nullable = false)
    @JsonIgnore
     private Project project;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setPTSequence(Integer PTSequence) {
        this.PTSequence = PTSequence;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public Long getId() {
        return id;
    }

    public Integer getPTSequence() {
        return PTSequence;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public Backlog() {
    }
}
