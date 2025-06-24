package SMS;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.csv";

    public StudentManagementSystem() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public boolean removeStudent(String rollNumber) {
        boolean removed = students.removeIf(s -> s.getRollNumber().equalsIgnoreCase(rollNumber));
        if (removed) saveToFile();
        return removed;
    }

    public Student searchStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) return s;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void editStudent(String rollNumber, String name, String grade, int age) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            s.setName(name);
            s.setGrade(grade);
            s.setAge(age);
            saveToFile();
        }
    }

    private void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("No data file found. Starting fresh.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}
