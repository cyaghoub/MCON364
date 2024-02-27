package sortingHw;

public class Student implements Comparable<Student>
{
	
	String name;
	int grade;
	
	public Student(String name, int grade) 
	{
        this.name = name;
        this.grade = grade;
    }
	
	public int getGrade()
	{
		return grade;
	}
	

	@Override
	public int compareTo(Student o) 
	{
		return Integer.compare(this.grade, o.grade);
	}

	
}
