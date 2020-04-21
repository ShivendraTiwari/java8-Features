package com.shivendra.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Streams {

	public static void main(String[] args)throws IOException {

		// 1.Integer Stream
		System.out.println("1. Integer Stream");		
		IntStream.range(1, 10)
		.forEach(System.out::print);
		System.out.println();
		
		//2 Integer Stream with skip
		System.out.println("2. Integer Stream with skip");
		IntStream
		.range(1,10)
		.skip(5)
		.forEach(x->System.out.print(x));
		System.out.println();
		
		//3 Integer Stream with sum
		System.out.println("3. Integer Stream with sum");
		System.out.println(
				IntStream
				.range(1,5)
				.sum());
		//System.out.println();
		
		//4  Stream.of,sorted and findFirst
		System.out.println("4. Stream.of,sorted and findFirst");
		Stream.of("Shivendra ","Shivangi ","Manas ","Ashwni ","Sankalp")
		.sorted()
		.findFirst()
		.ifPresent(System.out::print);
		System.out.println();

		//5 Stream from Array,sort,filter and print
		System.out.println("5. Stream from Array,sort,filter and print");
		String[] names= {"Ram ","Sita ","Laxman ","Bharat ","Shatrugna ","SaiNath ","Shivay "};
		Arrays.stream(names)//same as Stream.of(names)
		.filter(x->x.startsWith("S"))
				.sorted()
				.forEach(System.out::print);
		System.out.println();
		
		//6 average of squares of an int array
		System.out.println("6. average of squares of an int array");
		Arrays.stream(new int[] {2,3,6,1,9,8})
		.map(x->x*x)
		.average()
		.ifPresent(System.out::println);
		
		
		//7 Stream from List,filter and print
		System.out.println("7. Stream from List,filter and print");
		List<String> people=Arrays.asList("shivendra ","Shivangi ","Ammy ","Avengers ","Ashwni ","Sankalp ");
		people
		.stream()
		.map(String::toLowerCase)
		.filter(x->x.startsWith("a"))
		.forEach(System.out::println);
		
		//8 Stream rows from text,file,sort,filter and print
		System.out.println("8. Stream rows from text,file,sort,filter and print");
        Stream<String> bands=Files.lines(Paths.get("/home/shivendra/eclipse-workspace/Practice/src/com/shivendra/java8/bands.txt"));
        bands
        .sorted()
        .filter(x->x.length()>13)
        .forEach(System.out::println);
        bands.close();
        
        //9 Stream rows from text file and save to List
        System.out.println("9. Stream rows from text file and save to List");
        List<String> bands2=Files.lines(Paths.get("/home/shivendra/eclipse-workspace/Practice/src/com/shivendra/java8/bands.txt"))
		.filter(x->x.contains("Tiw"))
		.collect(Collectors.toList());
		bands2.forEach(x->System.out.println(x));
				 
		//10 Stream rows from CSV file and count
		System.out.println("10. Stream rows from CSV file and count");
		Stream<String> rows1=Files.lines(Paths.get("/home/shivendra/eclipse-workspace/Practice/src/com/shivendra/java8/data.txt"));
		int rowCount=(int)rows1
		.map(x->x.split(","))
		.filter(x->x.length==3)
		.count();
		System.out.println(rowCount+" rows. ");
		rows1.close();
				
		//11 Stream rows from CSV File.parse data from rows
		System.out.println("Stream rows from CSV File.parse data from rows");
		Stream<String> rows2=Files.lines(Paths.get("/home/shivendra/eclipse-workspace/Practice/src/com/shivendra/java8/data.txt"));
		rows2
		.map(x->x.split(","))
		.filter(x->x.length==3)
		.filter(x->Integer.parseInt(x[1])>15)
		.forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
		rows2.close();
		
		//12 Stream rows from CSV File,store fields in HashMap
		System.out.println("12. Stream rows from CSV File,store fields in HashMap");
		Stream<String> rows3=Files.lines(Paths.get("/home/shivendra/eclipse-workspace/Practice/src/com/shivendra/java8/data.txt"));
	    Map<String,Integer>map=new HashMap<>();
	    map=rows3
	    		.map(x->x.split(","))//0.0 is starting point,a is running total,b is new number
	    		.filter(x->x.length==3)
	    		.filter(x->Integer.parseInt(x[1])>15)
	    		.collect(Collectors.toMap(
	    				x->x[0],	
	    				x->Integer.parseInt(x[1])));
	    rows3.close();
	    for(String key:map.keySet()) {
	    	System.out.println(key+" "+map.get(key));
	    }
	    
	    //13. Reduction -sum
	    System.out.println("13. Reduction -sum");
	    double total=Stream.of(7.3, 5.6, 4.8)			
	    		.reduce(0.0,(Double a,Double b) -> a+b);  //0.0 is starting point,a is running total,b is new number
	    System.out.println("Total = " + total);
	    		
	    //14. Reduction -summary statistics
	    System.out.println("14. Reduction -summary statistics");
	    IntSummaryStatistics summary=IntStream.of(1,2,5,3,19,7)
	    		.summaryStatistics();
	    System.out.println(summary);
	}

}
