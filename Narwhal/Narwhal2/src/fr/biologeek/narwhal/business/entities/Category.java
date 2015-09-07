package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

@Entity
@Component
@ManagedBean
public class Category implements Serializable {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer category_id;
	private String category_label;
	private String category_description;

	@ManyToOne
	private Category category_parent;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category_parent")
	private List<Category> category_children;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="operation_category")
	private List<Operation> category_operations;

	public Integer getCategory_id() {
		return category_id;
	}

	public Category getCategory_parent() {
		return category_parent;
	}

	public void setCategory_parent(Category category_parent) {
		this.category_parent = category_parent;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_label() {
		return category_label;
	}

	public void setCategory_label(String category_label) {
		this.category_label = category_label;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}



	public List<Category> getCategory_children() {
		return category_children;
	}

	public void setCategory_children(List<Category> category_children) {
		this.category_children = category_children;
	}

	public List<Operation> getCategory_operations() {
		return category_operations;
	}

	public void setCategory_operations(List<Operation> category_operations) {
		this.category_operations = category_operations;
	}
	
	
	
}
