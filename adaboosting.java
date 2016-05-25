package adaboosting;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
import java.io.IOException;
import java.util.*;
import java.lang.Math.*;
//import java.lang.Math.l;
public class realadaboosting {
	
	
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
      double Prplus = 0;double Prminus = 0;double Pwplus = 0;double Pwminus = 0;
      double Prplus1 = 0;double Prminus1 = 0;double Pwplus1 = 0;double Pwminus1 = 0;
      double Geevalue;double Geevalue1;
      double Ctplus;double Ctminus;
      double epsilon1 = 0;double epsilon = 0;
      double BoundonError = 1;
      String lessorgreater1 = "";
      String plus1 = "1";
      String minus1 = "-1";
      int noofiterations = 0; 
      ArrayList xvalue = new ArrayList();
      ArrayList zvalue1 = new ArrayList();
      ArrayList yvalue = new ArrayList();
      ArrayList pvalue = new ArrayList();
      ArrayList newpvalue = new ArrayList();
      ArrayList error3 = new ArrayList();
      ArrayList epsilon2 = new ArrayList();
      ArrayList threshold = new ArrayList();
      ArrayList lessorgreater = new ArrayList();
      ArrayList qvalue1 = new ArrayList();
      ArrayList prenormalpvalue = new ArrayList();
      ArrayList Gvalue = new ArrayList();
      ArrayList PRplus = new ArrayList();
      ArrayList PRminus = new ArrayList();
      ArrayList PWminus = new ArrayList();
      ArrayList PWplus = new ArrayList(); 
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
          					  epsilon = Double.parseDouble(frstrow[j]);
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
   	   Prplus = 0;Prminus = 0;Pwplus = 0;Pwminus = 0;
   	   Prplus1 = 0;Prminus1 = 0;Pwplus1 = 0;Pwminus1 = 0;
   	   BoundonError = 1;
   	 //  probabilty = 0;
   	 //  probabilty1 = 0;
          // counter1 = 0;
	       threshold1 = ((double)xvalue.get(counter1)+(double)xvalue.get(counter1 + 1))/2 ;
	       System.out.println("threshold "+threshold1);
	     for ( counter2 = 0 ;counter2 < threshold1 ;counter2++ ){
	         if (yvalue.get(counter2).equals(plus1))
	         {
	    	   System.out.println("yvalue equal");
	    	   Prplus += (double)pvalue.get(counter2);
	    	   System.out.println("Prplus "+Prplus);
	//    			   probabilty  += (double)pvalue.get(counter2);
	         }
	         else{
		      error = error + 1;
		      Pwminus += (double)pvalue.get(counter2);
	//          probabilty  += (double)pvalue.get(counter2);
	          System.out.println("counter2 "+counter2);  
	          System.out.println("Pwminus "+Prplus);
	    //      System.out.println("probabilty inside loop"+probabilty);   
            }
	            counter3 = counter2;
	      }   
         for ( counter3 = counter2;counter3 < yvalue.size() ;counter3++ ){
             if (yvalue.get(counter3).equals(minus1)){
           	  System.out.println("counter3 "+counter3);
           	 System.out.println("yvalue equal");
           	 Prminus += (double)pvalue.get(counter3);
           	System.out.println("Prminus "+Prminus);
             }
          	 else{
  //      	 error = error + 1;
        	 Pwplus  += (double)pvalue.get(counter3);
//             probabilty  += (double)pvalue.get(counter3);
             System.out.println("counter3 "+counter3);  
             System.out.println("Pwplus "+Pwplus);
//             System.out.println("probabilty inside loop1"+probabilty);
        	  }
          } 		
           Geevalue = Math.sqrt(Prplus * Pwminus) + Math.sqrt( Pwplus * Prminus); 
           System.out.println("Geevalue :"+Geevalue);
      	  for ( counter4 = 0 ;counter4 < threshold1 ;counter4++ ){
  	         if (yvalue.get(counter4).equals(minus1))
  	         {
 	    	   System.out.println("yvalue equal");
 	    	  System.out.println("counter4 "+counter4);  
 	    	  Prminus1 += (double)pvalue.get(counter4); 
 	    	 System.out.println("Prminus1 "+Prminus1);
  	         }
   	       else{
   		    error1 = error1 + 1;
   		 System.out.println("threshold "+threshold1);
   		 System.out.println("counter4 "+counter4);  
  //	            probabilty1  += (double)pvalue.get(counter4);
   		    Pwplus1  += (double)pvalue.get(counter4);
   		    System.out.println("Pwplus1 "+Pwplus1);
   	       }
         			   
          }
         
          for (int counter5 = counter4 ;counter5 < yvalue.size() ;counter5++ ){
             if (yvalue.get(counter5).equals(plus1))
             {
  	    	   System.out.println("yvalue equal");
  	    	 System.out.println("counter5 "+counter5); 
  	    	 Prplus1 += (double)pvalue.get(counter5);
  	    	 System.out.println("Prplus1 "+Prplus1);
             }
               else{
         		 error1 = error1 + 1;
 //               probabilty1  += (double)pvalue.get(counter5); 
         		System.out.println("counter5 "+counter5); 
                Pwminus1 += (double)pvalue.get(counter5);
                System.out.println("Pwminus1 "+Pwminus1);
               }
           }
          Geevalue1 = Math.sqrt(Prplus1 * Pwminus1) + Math.sqrt( Pwplus1 * Prminus1); 
          System.out.println("Geevalue1 :"+Geevalue1);
    //       System.out.println("error "+error);
    //       System.out.println("error1 "+error1);
    //       System.out.println("probabilty "+probabilty);
    //       System.out.println("probabilty1 "+probabilty1);
        
          if (Geevalue1 < Geevalue){
       	  epsilon1 =probabilty1;
       	  lessorgreater1 = ">"; 
 		      error2 = error2/numbers;
 		     Gvalue.add(Geevalue1);
 		    System.out.println("Sumit :Pwminus1 "+Pwminus1);
 		     PRplus.add(Prplus1);PRminus.add(Prminus1);PWminus.add(Pwminus1);PWplus.add(Pwplus1);
 		    }
 		   else{ 
 			epsilon1 =probabilty;
 			lessorgreater1 = "<";
 			 error2 = error2/numbers;
 			Gvalue.add(Geevalue);
 			System.out.println("Sumit :Pwminus "+Pwminus);
 			 PRplus.add(Prplus);PRminus.add(Prminus);PWminus.add(Pwminus);PWplus.add(Pwplus);
 		    }  		
      //    System.out.println("probabilty1 "+probabilty1);
          //    		 if (error1 < error){
          //    			 error2 =error1; 
          //    		     error2 = error2/numbers;
          //    		 }
          //    		 else{ 
          //    		      error2 =error;
          //    			 error2 = error2/numbers;
          //    		 }
        //            epsilon2.add(epsilon1);
         			threshold.add(threshold1);
         			lessorgreater.add(lessorgreater1);
        // 			System.out.println("epsilon1 "+epsilon1);
         			System.out.println("threshold "+threshold.get(counter1));
       //  			System.out.println("epsilon "+epsilon2.get(counter1));
         			System.out.println("function "+lessorgreater.get(counter1));
         			System.out.println("Gvalue "+Gvalue.get(counter1));
         			System.out.println("function "+lessorgreater.get(counter1));
         	  
     } // counter1    		
	//  for(int counter13 = 0;counter13 < epsilon2.size();counter13++){
	//	   System.out.println("epsilon "+epsilon2.get(counter13));
	 //  }
	   int  index = Gvalue.indexOf (Collections.min(Gvalue)); 
	   System.out.println("index "+index);
	   System.out.println("epsilon "+epsilon);
	   System.out.println("roundedepsilon "+Math.round(epsilon));
	   System.out.println("PRplus.get(index)"+PRplus.get(index));
	   System.out.println("PWminus.get(index)"+PWminus.get(index));
	   System.out.println("PWplus.get(index)"+PWplus.get(index));
	   System.out.println("PRminus.get(index)"+PRminus.get(index));
	   //epsilon=Math.round(epsilon * 100.0)/100.0;
	   double valuetest = (double)PRplus.get(index) + epsilon;
	   System.out.println("index test "+index);
//	   valuetest += epsilon;
	   System.out.println("valuetst"+valuetest);
	 //  Math.log((PRplus.get(index) + epsilon)/(PWminus.get(index) + epsilon))/Math.log(2.718));
	   Ctplus = Math.log(((double)(PRplus.get(index)) + epsilon)/((double)PWminus.get(index) + epsilon));
//	   Ctplus = (Ctplus /(Math.log(2.71)))*0.5;
	   Ctplus = Ctplus * 0.5;
	   Ctminus = Math.log(((double)PWplus.get(index) + epsilon)/((double)PRminus.get(index) + epsilon));
	   Ctminus = Ctminus *0.5;
	   Ctplus=(Ctplus * 10000.0)/10000.0;
	   Ctminus=(Ctminus * 10000.0)/10000.0;
	   System.out.println("Ctplus "+Ctplus);
       System.out.println("Ctminus "+Ctminus);
//	   double  epsilonval =  (Double)epsilon2.get(index);
	   double qvalue ;double zvalue = 0 ;
	   int counter8 = 0;
	   int counter9 = 0;
 //       double alpha = 0.5 *( Math.log((1 - epsilonval)/epsilonval) / Math.log(2.718));
        
          // double qvalue = (double)pvalue.get(counter7);
	     System.out.println("index test"+index);
           if (lessorgreater.get(index).equals("<")){
        	   System.out.println("index test"+index);
              for ( counter2 = 0 ;counter2 < (double)threshold.get(index) ;counter2++ ){
   	              if (yvalue.get(counter2).equals(plus1))
  	              {
  	    	      System.out.println("yvalue equal");
  	    	      qvalue = Math.pow(2.71828,-Ctplus);
  	    	      qvalue1.add(qvalue);   
  	              }
  	              else{
  		          qvalue = Math.pow(2.71828,Ctplus);
  		          qvalue1.add(qvalue);
  		          
                 }
  	               counter8  =counter2;
             } 
  	        
  	        	
  	        
               for ( counter3 = counter2 ;counter3 < yvalue.size() ;counter3++ ){
                 if (yvalue.get(counter3).equals(minus1)){
              	 
               	 qvalue = Math.pow(2.71828,Ctminus);
     	    	     qvalue1.add(qvalue); 
               	 System.out.println("yvalue equal");
                 }
             	  else{
           	   
              		 qvalue = Math.pow(2.71828,-Ctminus);
    	    	     qvalue1.add(qvalue);
             		
           	  }
                }
           }   
         else{
       	  
         	    for ( counter4 = 0 ;counter4 < (double)threshold.get(index) ;counter4++ ){
     	         if (yvalue.get(counter4).equals(minus1))
     	         {
     	        	qvalue = Math.pow(2.71828,Ctminus);
    	    	     qvalue1.add(qvalue); 
              	 
     	        	 //System.out.println("yvalue equal");
    	         }
      	       else{
      	    	  qvalue = Math.pow(2.71828,-Ctminus);
	    	      qvalue1.add(qvalue); 
         	 
      	       }
     	        counter9 = counter4;	   
             }
             
             for (int counter5 = counter4 ;counter5 < yvalue.size() ;counter5++ ){
                if (yvalue.get(counter5).equals(plus1))
                {
               	 qvalue = Math.pow(2.71828,-Ctplus);
    	    	     qvalue1.add(qvalue); 
              	 
               	 
               	 System.out.println("yvalue equal");
     	          }
                  else{
            		 
               	 qvalue = Math.pow(2.71828,Ctplus);
      	    	     qvalue1.add(qvalue); 
               	 //  error1 = error1 + 1;
                   //probabilty1  += (double)pvalue.get(counter5); 
                 }
              } 		
      
          }
         
//           for (int counter10 = 0;counter10 <pvalue.size();counter10++){
//           	System.out.println("qvalue1 :"+qvalue1.get(counter10));
//           }
         
           for (int counter11 = 0;counter11 <pvalue.size();counter11++){
           	System.out.println("qvalue1 :"+qvalue1.get(counter11));
           	double prenormalpvalue1 = ((double)qvalue1.get(counter11))*((double)pvalue.get(counter11));
           	prenormalpvalue.add(prenormalpvalue1);
           }
           
           for (int counter12 = 0;counter12 <pvalue.size();counter12++){
         	System.out.println("qvalue1 :"+qvalue1.get(counter12));
           	 zvalue += (double)prenormalpvalue.get(counter12);
           	
           }
             zvalue1.add(zvalue);
           for (int counter13 = 0;counter13 <pvalue.size();counter13++){
           	//System.out.println("qvalue1 :"+qvalue1.get(counter11));
        	   zvalue = (zvalue * Math.pow(10 , 4)); 
             	 zvalue=zvalue/Math.pow(10 , 4);
             	 
           	 double newpvalue1 = 
           	  ((double)(prenormalpvalue.get(counter13)))/zvalue;
           	 newpvalue1=(newpvalue1 * 10000.0)/10000.0;
  //         	 newpvalue1 = (newpvalue1 * Math.pow(10 , 4)); 
  //         	 newpvalue1=newpvalue1/Math.pow(10 , 4);
           	 newpvalue.add(newpvalue1);
           }
//	     System.out.println("iteration number :"+iteration);
	        System.out.println("---------------------------------------------");
//	        System.out.println("|----index----------- :"+index+"-----------------|");
	        System.out.println("|----iteration number :"+iteration+"-----------------|");
	        System.out.println("|----The selected weak classifier h "+"x"+lessorgreater.get(index)+threshold.get(index)+"|");
	 //       System.out.println("|----The error-------:"+epsilon2.get(index)+"-----------------|");
	 //       System.out.println("|----The error epsilonval-------:"+epsilonval+"-----------------|");
	 //       System.out.println("|----The weight of h(t):"+alpha+"-----------------|");
	        
	        
	 //       System.out.println("|-----------threshold :"+threshold.get(index)+"-----------------|");
	 //       System.out.println("|--------------function "+lessorgreater.get(index)+"-----------------|");
	        System.out.println("|----G error value of h "+Gvalue.get(index)+"-----------------|");
	        System.out.println("|----Ctplus "+Ctplus+"-----------------|");
	        System.out.println("|----Ctminus "+Ctminus+"-----------------|");
	        System.out.println("|----The probabilities normalisation factor Z :"+zvalue1.get(iteration)+"-----------------|");
	        System.out.println("|----The probabilities after normalisation p------------------------------|");
	        for (int counter10 = 0;counter10 <pvalue.size();counter10++){
	        System.out.println("|----newpvalue-------- :"+newpvalue.get(counter10)+"-----------------------");
	        }
	        for (int counter10 = 0;counter10 <zvalue1.size();counter10++){
	        	  BoundonError *= (double)zvalue1.get(counter10);
	        	  
	        }	  
		    System.out.println("|----the bound on E(t)-------- :"+BoundonError+"-----------------------");
		       
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
	        Gvalue.clear();
	        PRplus.clear();PWplus.clear();PWplus.clear();PRminus.clear();
	      //  PRplus1.clear();PWplus1.clear();PWplus1.clear();PRminus1.clear();
	        System.out.println("|testing 2|");
	        
	    }//iteration
	    
	          		
	          		
	          	  
	          			  
	      }		  	 
	          		
	          	  

	   }          
