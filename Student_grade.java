package codsoft;

import java.util.Scanner;

public class Student_grade {
   public Student_grade() {
   }

   public static void calculation(String name, int[] arr, int n, int total) {
      for(int i = 0; i < n; ++i) {
         total += arr[i];
      }

      float percent = (float)(total / n);
      String grade;
      if ((double)percent > 90.0) {
         grade = "A++";
      } else if ((double)percent > 80.0) {
         grade = "A";
      } else if ((double)percent > 70.0) {
         grade = "B++";
      } else if ((double)percent > 60.0) {
         grade = "B";
      } else if ((double)percent > 50.0) {
         grade = "c";
      } else {
         grade = "u";
      }

      System.out.println(" Name : " + name);
      System.out.println(" total mark :" + total);
      System.out.println(" percentage : " + percent);
      System.out.println(" grade :" + grade);
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int choice;
      do {
         System.out.println("enter the name of student:");
         String name = input.next();
         System.out.println("enter the number of subject:");
         int n = input.nextInt();
         int[] arr = new int[n];
         System.out.println("enter the mark: ");

         for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
         }

         int total = 0;
         double percent = 0.0;
         calculation(name, arr, n, total);
         System.out.println(" enter 1 to continue 0 to exist");
         choice = input.nextInt();
      } while(choice == 1);

   }
}
