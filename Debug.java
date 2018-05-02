/**
 * @author: cs11sbm@ieng6.ucsd.edu
 * @pid: A14437143
 * @about: This program has some bugs that need to be fixed
 * 
 * @compile: javac Debug.java 
 * @run: java Debug 
 *
 **/
 public class Debug {
   public static String answer = "";

   public static void doSomething() {

     /* TODO: debugging starts from here */

//     String name = "Adam Jundt"
       String name = "Adam Jundt";
     answer += "Sample Student Name: " + name + "\n"; //DO NOT CHANGE THIS LINE    

//     int age = "18";
       int age = 18;
     answer += "Sample Student Age: " + age + "\n"; //DO NOT CHANGE THIS LINE

//     hobby = "Swimming";
       String hobby = "Swimming";
     answer += "Sample Student Hobby: " + hobby + "\n"; //DO NOT CHANGE THIS LINE

     double score = 95.5;
     String grade = ""; //inserted so that variable grade would both initialized
//     if score >= 90
       if (score >= 90)
       grade = "A";
//     if score >= 80
       if (score >= 80 && score < 90)
       grade = "B";
//     if 80 > score >= 70
       if (score >= 70 && score < 80)
       grade = "C";

     answer += "Sample Student Grade: " + grade + "\n"; //DO NOT CHANGE THIS LINE
     
     /* debugging ends here */
   }

   public static void main(String[] args) {
     doSomething();
     System.out.println(answer);
   }
 }

