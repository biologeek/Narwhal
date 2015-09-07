package fr.biologeek.narwhal.presentation.jsf.beans.converters;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.service.ISpecificCategoryService;

@ManagedBean(name = "categoryConverterBean") 
@FacesConverter(value = "categoryConverter")
@Controller
public class CategoryConverter implements Converter, Serializable {


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1036723190198538580L;
	@Qualifier("categoryService")
	private ISpecificCategoryService catService ;  

	public CategoryConverter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
      // This will return the actual object representation
      // of your Category using the value (in your case 52) 
      // returned from the client side
    	System.out.println("Bla " +catService);
    	System.out.println("Bla " +value);
    	
    	try {
    	  
    		if (value == ""){
    			return catService.getCategories();
    		}
    		else {
    			return catService.getSubCategories(Integer.parseInt(value));
    		}
		
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
			return new Category();
    	} 
      
    }

	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        //This will return view-friendly output for the dropdown menu
        return o.toString(); 
    }

	public ISpecificCategoryService getCatService() {
		return catService;
	}

	public void setCatService(ISpecificCategoryService catService) {
		this.catService = catService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catService == null) ? 0 : catService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryConverter other = (CategoryConverter) obj;
		if (catService == null) {
			if (other.catService != null)
				return false;
		} else if (!catService.equals(other.catService))
			return false;
		return true;
	}

}
