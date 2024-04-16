package practiseJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractise {

	public static void main(String[] args) {
		  ArrayList<Integer> al = new ArrayList<Integer>(); 
	        al.add(2); 
	        al.add(2); 
	        al.add(2); 
	        al.add(3); 
	        al.add(20); 
	        
	    Integer num=   al.stream().filter(i-> i==2 || i==3).findFirst().orElse(null);
	    List<Integer> num2=   al.stream().map(i-> i+1).collect(Collectors.toList());
	    System.out.println(num2);
	    
//	    al.stream()
//	      .peek(e -> e.salaryIncrement(10.0))
//	      .peek(System.out::println)
//	      .collect(Collectors.toList());
	      System.out.println(al.stream().distinct().count());
	      
	      String loki="llllllllllllllllllllllllllllllllllllllllllllllllllllllllla";
	      
	      
	      String loki1="deqmo , demo1, demo2, demo3dsdfs";
	      
	      String[] string=loki1.split(",");
	      
	      for (String dev:string) {
			
	    	  if(dev.length()>5) {
	    		  System.err.println(dev);
	    	  }
			
		}
	     
	      
	      
	      IntStream lo=loki.chars();
     
//        for(int i=0;i<=10;i++) {
//        	System.out.println("loki");
//        }
//        
        IntStream.range(0, 10).mapToObj(i->"lsdoki").forEach(System.out::println);
        
	        lo.distinct().forEach(i-> {
	        	System.out.print((char)i);
	        });
	      
	   
		System.out.println();
		
		List number = Arrays.asList(2,3,4,5);
		//int even = (int) number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	}
}
