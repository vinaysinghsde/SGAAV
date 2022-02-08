package SGAAV.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import SGAAV.DAO.CategoryDAO;
import SGAAV.model.Category;

public class CategoryJunitTest {

	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst() 
	{
		

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("SGAAV");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	
	public void addCategoryTest() 
	{
		
		Category category = new Category();
		
		category.setCategoryName("T-Shirt");
		category.setCategoryDesc("All variety of Tshirts");
		
		assertTrue("Problem in adding category",categoryDAO.addCategory(category));
		
	}

}
