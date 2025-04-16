package practice_jdbc;

import java.util.Collection;
import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JdbcStudDao<Student, Integer> dao = new StudentDao();
		int ch;
		do {
			System.out.println("1.display All Students");
			System.out.println("2.display one Student");
			System.out.println("3.Add one Student");
			
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				
				Collection<Student> studList = dao.getAll();
				for(Student stud : studList)
					System.out.println(stud);
				break;
				
			case 2:
				
				System.out.println("Enter roll no ");
				
				Student stud = dao.getOne(sc.nextInt());
				if(stud!= null)
					System.out.println(stud);
				else
					System.out.println("Student with given Id does not Exist");
				break;
				
			case 3:
				System.out.println("Enter rollNo, name, city");
				Student s1 = new Student(sc.nextInt(),sc.next(),sc.next());
				dao.add(s1);
				break;
				
				
			}
		}while(ch!=3);
	}
}
