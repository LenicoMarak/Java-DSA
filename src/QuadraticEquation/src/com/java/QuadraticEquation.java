package com.java;
import java.lang.Math;
import java.util.*;

 public  class QuadraticEquation
{
   double root1,root2;
    private static  void Quadratic(double a,double b,double c){
     double d=b*b-4*a*c;
     double sqrt=Math.sqrt(d);
     if(d>0){
      root1=-b+sqrt/2*a;
      root2=-b-sqrt/2*a;
        System.out.println("root1="+root1+"and"+"root2= "+root2);
      }
      else if(d==0){
        root1=this.root2=-b/2*a;
        System.out.println("root are="+root1);
        }
       else{
         System.out.println("Root are different i,e.,="+(-b)/2*a+"and"+(-b)/2*a);
       }
      }

      
    public static void main(String[] args)
	{
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter cofficient a: ");
	  double x=input.nextDouble();
	  System.out.println("Enter confficient b: ");
	  double y=input.nextDouble();
	  System.out.println("Enter cofficient c: ");
	  double z=input.nextDouble();
	  
	    
	      Quadratic(x,y,z);
		//TODO: place you code here
	}
}
