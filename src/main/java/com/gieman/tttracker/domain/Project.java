package com.gieman.tttracker.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Благодатских С.
 */
@Entity
@Table(name = "ttt_project")
@NamedQueries({
	@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p ORDER BY p.projectName ASC"),
	@NamedQuery(name = "Project.findByIdProject", query = "SELECT p FROM Project p WHERE p.idProject = :idProject"),
	@NamedQuery(name = "Project.findByProjectName", query = "SELECT p FROM Project p WHERE p.projectName = :projectName")})
public class Project extends AbstractEntity implements EntityItem<Integer> {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    @Basic(optional = false)
	@Column(name = "id_project")
	private Integer idProject;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "project_name")
	private String projectName;
	@JoinColumn(name = "id_company", referencedColumnName = "id_company")
	@ManyToOne(optional = false)
	private Company company;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<Task> tasks;

	public Project() {
	}

	public Project(Integer idProject) {
		this.idProject = idProject;
	}

	public Project(Integer idProject, String projectName) {
		this.idProject = idProject;
		this.projectName = projectName;
	}

	@Override
	public Integer getId() {
		return idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return 97 * 5 + Objects.hashCode(idProject);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return Objects.equals(idProject, ((Project) obj).idProject);
	}

	@Override
	public String toString() {
		return "com.gieman.tttracker.domain.Project[ idProject=" + idProject + " ]";
	}

}
