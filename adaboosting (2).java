package adaboosting;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
import java.io.IOException;
import java.util.*;

public class adaboosting {
//	String filename1 = "src/myfiles1/file1.txt";
//	 FileReader fr = new FileReader(filename1)  ;
//	  BufferedReader textReader = new BufferedReader(fr);



  public static void main(String[] args) throws IOException 
    {
	  String filename = "src/myfiles1/file2.txt";
	  int numberoflines = 0;
	  int maxvalue;
	  int counter1;
      int error = 0;
      int error1 = 0;
      int error2 = 0;
      int numbers = 0;
      double probabilty = 0;double probabilty1 = 0;
      double epsilon1 = 0;
      double BoundonError = 1;
      String lessorgreater1 = "";
	  String plus1 = "1";
	  String minus1 = "-1";
	  int noofiterations = 0;
	  ArrayList xvalue = new ArrayList();
	  ArrayList yvalue = new ArrayList();
	  ArrayList zvalue1 = new ArrayList();
	  ArrayList pvalue = new ArrayList();
	  ArrayList newpvalue = new ArrayList();
	  ArrayList error3 = new ArrayList();
	  ArrayList epsilon2 = new ArrayList();
	  ArrayList threshold = new ArrayList();
	  ArrayList lessorgreater = new ArrayList();
	  ArrayList qvalue1 = new ArrayList();
	  ArrayList prenormalpvalue = new ArrayList();
		 FileReader fr = new FileReader(filename)  ;
         BufferedReader textReader = new BufferedReader(fr);
         while((textReader.readLine()) != null){
        	  numberoflines = numberoflines + 1; }
        	  System.out.println("numberoflines :"+numberoflines);
        	  String[] textData = new String[numberoflines];
       //    	System.out.println("numberoflines latest:"+numberoflines);
        //  	  try{
          		  FileReader fr3 = new FileReader(filename)  ;
          		  BufferedReader textReader3 = new BufferedReader(fr3);

          	  //String [] crossvldn = new String[textData[i].length];
          	  for(int i=0;i<numberoflines;i++) {
          		  textData[i] = textReader3.readLine();
//          		  String [] crossvldn = new String[textData[i].length()];
          		  System.out.println("textData :"+textData[i] );
          		  if (i ==0){
          		     String [] frstrow = new String[textData[i].length()];
          			 frstrow = textData[i].split(" ");	 
//          			 System.out.println("crossvldn :"+crossvldn);
          			 int lnoffrstrec = frstrow.length;
          			  for (int j=0;j<lnoffrstrec ;j++){
          				  if (j==0) {
          		              noofiterations = Integer.parseInt(frstrow[j]);
         			        System.out.println("noofiterations :"+noofiterations );
          			             
          				  } 
          				  if (j==1){  
          			         numbers = Integer.parseInt(frstrow[j]);
          			        System.out.println(numbers);
          				  }
          				  if (j==2){
          					 double epsilon = Double.parseDouble(frstrow[j]);
          					System.out.println("epsilon :"+epsilon);
                           }
                       }
          		  }
          		 // else {
          			 String [] rowdata = new String[textData[i].length()];
          			rowdata = textData[i].split(" ");	
          			int lnofrec = rowdata.length;
          	//		  Map Trainingset = new HashMap(); 
          //			ArrayList yandp = new ArrayList();
          		if (i ==1){
          //			ArrayList xvalue = new ArrayList();
          			for (int k=0;k<lnofrec ;k++){
          			 xvalue.add(Double.parseDouble(rowdata[k]));
          			  //maxvalue= (int)xvalue.get(lnofrec);
          			}	 
          		}	
          		if (i ==2){
          		//	ArrayList yvalue = new ArrayList();
          			for (int l=0;l<lnofrec ;l++)
          			 yvalue.add(rowdata[l]);
          		}	
          		if (i ==3){
            //  			ArrayList pvalue = new ArrayList();
              			for (int counter=0;counter<lnofrec ;counter++)
              			 pvalue.add(Double.parseDouble(rowdata[counter]));
              	}		
          		
          		}
            	  
  //   int err}}or;
     double threshold1 = 0;
    // String plus1 = "1";
    // String minus1 = "-1";
     int counter3;
     int counter2;int counter4;
  for (int iteration = 0; iteration < noofiterations ;iteration++)
  {     
	  System.out.println("|testing 3|");
	  for (counter1 = 0; counter1 < xvalue.size() - 1;counter1 ++){
    	   error = 0;
    	   error1 = 0;
    	   probabilty = 0;
    	   probabilty1 = 0;BoundonError = 1;
           // counter1 = 0;
	       threshold1 = ((double)xvalue.get(counter1)+(double)xvalue.get(counter1 + 1))/2 ;
	       System.out.println("threshold "+threshold1);
	     for ( counter2 = 0 ;counter2 < threshold1 ;counter2++ ){
	         if (yvalue.get(counter2).equals(plus1))
	         {
	    	   System.out.println("yvalue equal");
	         }
	         else{
		      error = error + 1;
	          probabilty  += (double)pvalue.get(counter2);
	          System.out.println("counter2 "+counter2);  
	          System.out.println("probabilty inside loop"+probabilty);   
             }
	            counter3 = counter2;
	      }   
          for ( counter3 = counter2;counter3 < yvalue.size() ;counter3++ ){
              if (yvalue.get(counter3).equals(minus1)){
            	  System.out.println("counter3 "+counter3);
            	 System.out.println("yvalue equal");
              }
           	 else{
         	 error = error + 1;
              probabilty  += (double)pvalue.get(counter3);
              System.out.println("counter3 "+counter3);  
              System.out.println("probabilty inside loop1"+probabilty);
         	  }
           } 		
          
       	  for ( counter4 = 0 ;counter4 < threshold1 ;counter4++ ){
   	         if (yvalue.get(counter4).equals(minus1))
   	         {
  	    	   System.out.println("yvalue equal");
  	         }
    	       else{
    		    error1 = error1 + 1;
   	            probabilty1  += (double)pvalue.get(counter4);
    	       }
          			   
           }
          
           for (int counter5 = counter4 ;counter5 < yvalue.size() ;counter5++ ){
              if (yvalue.get(counter5).equals(plus1))
              {
   	    	   System.out.println("yvalue equal");
   	          }
                else{
          		 error1 = error1 + 1;
                 probabilty1  += (double)pvalue.get(counter5); 
                }
            } 		
            System.out.println("error "+error);
            System.out.println("error1 "+error1);
            System.out.println("probabilty "+probabilty);
            System.out.println("probabilty1 "+probabilty1);
         
           if (probabilty1 < probabilty){
        	  epsilon1 =probabilty1;
        	  lessorgreater1 = ">"; 
  		      error2 = error2/numbers;
  		    }
  		   else{ 
  			epsilon1 =probabilty;
  			lessorgreater1 = "<";
  			 error2 = error2/numbers;
  		    }  		
           System.out.println("probabilty1 "+probabilty1);
           //    		 if (error1 < error){
           //    			 error2 =error1; 
           //    		     error2 = error2/numbers;
           //    		 }
           //    		 else{ 
           //    		      error2 =error;
           //    			 error2 = error2/numbers;
           //    		 }
                     epsilon2.add(epsilon1);
          			threshold.add(threshold1);
          			lessorgreater.add(lessorgreater1);
          			System.out.println("epsilon1 "+epsilon1);
          			System.out.println("threshold "+threshold.get(counter1));
          			System.out.println("epsilon "+epsilon2.get(counter1));
          			System.out.println("function "+lessorgreater.get(counter1));
          	  
      } // counter1    		
	   for(int counter13 = 0;counter13 < epsilon2.size();counter13++){
		   System.out.println("epsilon "+epsilon2.get(counter13));
	   }
	   int  index = epsilon2.indexOf (Collections.min(epsilon2)); 
	   System.out.println("index "+index);
	   double  epsilonval =  (Double)epsilon2.get(index);
	   double qvalue ;double zvalue = 0 ;
	   int counter8 = 0;
	   int counter9 = 0;
         double alpha = 0.5 *( Math.log((1 - epsilonval)/epsilonval) / Math.log(2.718));
         
           // double qvalue = (double)pvalue.get(counter7);
        	   
            if (lessorgreater.get(index).equals("<")){
                for ( counter2 = 0 ;counter2 < (double)threshold.get(index) ;counter2++ ){
   	              if (yvalue.get(counter2).equals(plus1))
   	              {
   	    	      System.out.println("yvalue equal");
   	    	      qvalue = Math.pow(2.718,-alpha);
   	    	      qvalue1.add(qvalue);   
   	              }
   	              else{
   		          qvalue = Math.pow(2.718,alpha);
   		          qvalue1.add(qvalue);
   		          
                  }
   	       //        counter8  =counter2;
                } 
   	        
   	        	
   	        
                for ( counter3 = counter2 ;counter3 < yvalue.size() ;counter3++ ){
                  if (yvalue.get(counter3).equals(minus1)){
               	 
                	 qvalue = Math.pow(2.718,-alpha);
      	    	     qvalue1.add(qvalue); 
                	 System.out.println("yvalue equal");
                  }
              	  else{
            	   
               		 qvalue = Math.pow(2.718,alpha);
     	    	     qvalue1.add(qvalue);
              		
            	  }
                 }
            }   
          else{
        	  
          	    for ( counter4 = 0 ;counter4 < (double)threshold.get(index) ;counter4++ ){
      	         if (yvalue.get(counter4).equals(minus1))
      	         {
      	        	qvalue = Math.pow(2.718,-alpha);
     	    	     qvalue1.add(qvalue); 
               	 
      	        	 //System.out.println("yvalue equal");
     	         }
       	       else{
       	    	  qvalue = Math.pow(2.718,alpha);
	    	      qvalue1.add(qvalue); 
          	 
       	       }
      	       // counter9 = counter4;	   
              }
              
              for (int counter5 = counter4 ;counter5 < yvalue.size() ;counter5++ ){
                 if (yvalue.get(counter5).equals(plus1))
                 {
                	 qvalue = Math.pow(2.718,-alpha);
     	    	     qvalue1.add(qvalue); 
               	 
                	 
                	 System.out.println("yvalue equal");
      	          }
                   else{
             		 
                	 qvalue = Math.pow(2.718,alpha);
       	    	     qvalue1.add(qvalue); 
                	 //  error1 = error1 + 1;
                    //probabilty1  += (double)pvalue.get(counter5); 
                   }
               } 		
       
           }
          
            for (int counter10 = 0;counter10 <pvalue.size();counter10++){
            	System.out.println("qvalue1 :"+qvalue1.get(counter10));
            }
          
            for (int counter11 = 0;counter11 <pvalue.size();counter11++){
            	//System.out.println("qvalue1 :"+qvalue1.get(counter11));
            	double prenormalpvalue1 = ((double)qvalue1.get(counter11))*((double)pvalue.get(counter11));
            	prenormalpvalue.add(prenormalpvalue1);
            }
            
            for (int counter12 = 0;counter12 <pvalue.size();counter12++){
            	//System.out.println("qvalue1 :"+qvalue1.get(counter11));
            	 zvalue += (double)prenormalpvalue.get(counter12);
            	
            }
            zvalue1.add(zvalue);
            for (int counter13 = 0;counter13 <pvalue.size();counter13++){
            	//System.out.println("qvalue1 :"+qvalue1.get(counter11));
            	 double newpvalue1 = 
            	  ((double)(prenormalpvalue.get(counter13)))/zvalue;
            	 newpvalue.add(newpvalue1);
            }
            
            
      //  int  index = epsilon2.indexOf (Collections.min(epsilon2)); 
 //       System.out.println("iteration number :"+iteration);
        System.out.println("---------------------------------------------");
//        System.out.println("|----index----------- :"+index+"-----------------|");
        System.out.println("|----iteration number :"+iteration+"-----------------|");
        System.out.println("|----The selected weak classifier h "+"x"+lessorgreater.get(index)+threshold.get(index)+"|");
        System.out.println("|----The error of h:epsilon-------:"+epsilon2.get(index)+"-----------------|");
//        System.out.println("|----The error epsilonval-------:"+epsilonval+"-----------------|");
        System.out.println("|----The weight of h:alpha --------"+alpha+"-----------------|");
        System.out.println("|----The probability normalisation factor Z :"+zvalue+"-----------------|");
        System.out.println("|----The probabilities after normalisation p------------------------------|");
        for (int counter10 = 0;counter10 <pvalue.size();counter10++){
        System.out.println("|----newpvalue-------- :"+newpvalue.get(counter10)+"-----------------------");
        }
        for (int counter10 = 0;counter10 <zvalue1.size();counter10++){
      	  BoundonError *= (double)zvalue1.get(counter10);
      	  
      }	  
	    System.out.println("|----the bound on E(t)-------- :"+BoundonError+"-----------------------");
        
//        System.out.println("|-----------threshold :"+threshold.get(index)+"-----------------|");
//        System.out.println("|--------------function "+lessorgreater.get(index)+"-----------------|");
        System.out.println("|---------------------------------------------|");
        //   
        pvalue.clear();
        
        for (int counter13 = 0;counter13 <newpvalue.size();counter13++){
        	//System.out.println("qvalue1 :"+qvalue1.get(counter11));
        	 pvalue.add(newpvalue.get(counter13));
        	 System.out.println("pvalue : "+pvalue.get(counter13));
        	 	
        }
        System.out.println("|testing 1|");
        prenormalpvalue.clear();
        qvalue1.clear();
        epsilon2.clear();
        lessorgreater.clear();
        threshold.clear();
  //      xvalue.clear();
  //      yvalue.clear();
       // error3.clear();
        newpvalue.clear();
        System.out.println("|testing 2|");
        
    }//iteration
    
          		
          		
          	  
          			  
      }		  	  
          		
          	  

   }

