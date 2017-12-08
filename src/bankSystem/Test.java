package bankSystem;

import java.lang.reflect.Method;

class Test{  
  public static void main(String args[]) throws ClassNotFoundException{  
   Class<?> refCls = Class.forName("bankSystem.Account");
		   //   String className= refCls.getName();
//   System.out.println(className);
//   
   Method[]	clsMethods= refCls.getMethods();
		   for(Method m : clsMethods){
			   System.out.print("Method: " + m.getName()+"\n");
		   }
 }  
}  