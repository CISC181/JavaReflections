package pkgShape;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

 

public class cMain {

	public static void main(String[] args) {

		Rectangle rec1 = CreateRectangleUsingReflections(5,10);

		System.out.println(rec1.area());
		
	}
	
	private static void CreateRectangle(int iWidth, int iLength)
	{
		Rectangle rec1 = new Rectangle(5,10);
		
		System.out.println("Area of Rectangle: " + rec1.area());
	}

	
	private static Rectangle CreateRectangleUsingReflections(int iWidth, int iLength)
	{
		
		Rectangle rec = null; 
		try {
			
			/**
			 * I'm going to 'consume' the entire class, pkgShape.Rectangle.  This class has a name, attributes
			 * and method.  I can call the constructor, call static methods, create an instance and call instance methods.
			 */
			Class<?> c = Class.forName("pkgShape.Rectangle");
			
			/**
			 * The constructor for Rectangle has two parameters- I have to set up an array that has two parameters, making
			 * sure to match their datatypes (int, int) in this case.
			 */
			Class[] cArg = new Class[2]; //Our constructor has 2 arguments
			cArg[0] = int.class;
			cArg[1] = int.class; 
			
			/**
			 * I'm going to call the (int, int) constructor in the Rectangle class
			 * Java reflections will automatically cast this instance of the class as an object, as everything
			 * that could be instantiated fits into object.
			 * 
			 * It's up to you to deal with the object that's created
			 */
			
			Object obj = c.getDeclaredConstructor(cArg).newInstance(new Object[] { iWidth,iLength });
			

			/**
			 * I know 'obj' is *really* a Rectangle.  This is me casting the obj into a Rectangle.
			 */
			rec =  (Rectangle)obj;			
			
			
			/**
			 * I can invoke instance methods!  Here, I'm invoking 'area' from an instance of Rectangle.  It just so
			 * happens that 'area' doesn't have any parameters
			 * 
			 * The first statement will consume the method into 'meth' variable
			 * The second statement will actually invoke the method
			 * 
			 * The return of the method is an object, as anything that's returned can fit into an object.  It's
			 * up to me to cast it into something else.  
			 */
			
			Method meth = c.getMethod("area", null);					
			Object oArea = meth.invoke(obj, null);
					
			Method methNbrOfRecs = c.getMethod("getINbrOfRecs", null);
			
			//	This is how you invoke a static method.  Notice the first parameter is null.  That means
			//	you're invoking static.  The second parameter is null, meaning you're not passing anything into 
			//	the static method.
			Object oNbrOfRecs = methNbrOfRecs.invoke(null,null);
			
			System.out.println("Area of this rectangle: " + (Double)oArea);
			System.out.println("Nbr of Recs: " + (Integer)oNbrOfRecs);
			
			

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		return rec;
	}
}
