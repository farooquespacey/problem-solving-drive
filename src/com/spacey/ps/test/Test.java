package com.spacey.ps.test;
/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
  public static void main(String args[] ) throws Exception {
      // Sample code to perform I/O:
      // * Use either of these methods for input

      //BufferedReader
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // String name = br.readLine();                // Reading input from STDIN
      // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

      //Scanner
      Scanner s = new Scanner(System.in);
      int len = Integer.parseInt(s.nextLine());                 // Reading input from STDIN
      String input = s.nextLine();
      
      HashSet<String> substrings = new HashSet<>();
      int[] result = new int[len];
      for(int i=0; i<input.length(); i++){
          String temp = "";

          HashSet<Character> distinctChars = new HashSet<>();
          for(int j=i; j<input.length(); j++){
              char thisChar = input.charAt(j);
              temp = temp + thisChar;
              distinctChars.add(thisChar);

              if(!substrings.contains(temp)){
            	  System.out.println("adding " + temp);
                  substrings.add(temp);
                  // if(temp.length() - 1 < 26){
                      result[temp.length() - 1]++;
                  // }
                  
              }
          }
      }
  

      // Write your code here
      for(int i=0; i<26; i++){
          int sum = 0;
          for(int j=i; j<result.length; j++){
              sum += result[j];
          }
          System.out.print(sum + " ");
      }
  }
}
