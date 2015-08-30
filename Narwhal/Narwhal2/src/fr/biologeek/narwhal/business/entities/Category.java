package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
@ManagedBean
public class Category implements Serializable {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String label;
	private String description;
	private int parent;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="operationId")
	private List<Operation> operations;
	
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", label=" + label
				+ ", description=" + description + ", parent=" + parent
				+ "]";
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
