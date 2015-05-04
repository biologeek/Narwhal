package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.stereotype.Component;
@Entity
@Component
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator")
@DiscriminatorValue(value="discriminator")
public class SubCategory extends Category implements Serializable{

	private int parent;


	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getParent() {
		return parent;
	}


	public void setParent(int parent) {
		this.parent = parent;
	}

	
}
