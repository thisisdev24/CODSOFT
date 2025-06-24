package SMS;

import javax.swing.*;
import java.awt.*;

public class UI {
    private StudentManagementSystem sms = new StudentManagementSystem();

    public UI() {
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton addBtn = new JButton("Add Student");
        JButton editBtn = new JButton("Edit Student");
        JButton deleteBtn = new JButton("Delete Student");
        JButton searchBtn = new JButton("Search Student");
        JButton viewAllBtn = new JButton("View All Students");

        JTextArea outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);

        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            String roll = JOptionPane.showInputDialog("Enter Roll Number:");
            String grade = JOptionPane.showInputDialog("Enter Grade:");
            String ageStr = JOptionPane.showInputDialog("Enter Age:");
            try {
                int age = Integer.parseInt(ageStr);
                if (name.isEmpty() || roll.isEmpty() || grade.isEmpty() || age <= 0) {
                    JOptionPane.showMessageDialog(frame, "Invalid Input!");
                    return;
                }
                sms.addStudent(new Student(name, roll, grade, age));
                outputArea.setText("Student Added Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Age.");
            }
        });

        editBtn.addActionListener(e -> {
            String roll = JOptionPane.showInputDialog("Enter Roll Number to Edit:");
            Student s = sms.searchStudent(roll);
            if (s == null) {
                outputArea.setText("Student Not Found!");
                return;
            }
            String name = JOptionPane.showInputDialog("Enter New Name:", s.getName());
            String grade = JOptionPane.showInputDialog("Enter New Grade:", s.getGrade());
            String ageStr = JOptionPane.showInputDialog("Enter New Age:", s.getAge());
            try {
                int age = Integer.parseInt(ageStr);
                sms.editStudent(roll, name, grade, age);
                outputArea.setText("Student Updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input.");
            }
        });

        deleteBtn.addActionListener(e -> {
            String roll = JOptionPane.showInputDialog("Enter Roll Number to Delete:");
            boolean removed = sms.removeStudent(roll);
            outputArea.setText(removed ? "Student Deleted." : "Student Not Found.");
        });

        searchBtn.addActionListener(e -> {
            String roll = JOptionPane.showInputDialog("Enter Roll Number to Search:");
            Student s = sms.searchStudent(roll);
            outputArea.setText(s != null ? s.toString() : "Student Not Found.");
        });

        viewAllBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("All Students:\n\n");
            for (Student s : sms.getAllStudents()) {
                sb.append(s).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        frame.add(addBtn);
        frame.add(editBtn);
        frame.add(deleteBtn);
        frame.add(searchBtn);
        frame.add(viewAllBtn);
        frame.add(scroll);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}

