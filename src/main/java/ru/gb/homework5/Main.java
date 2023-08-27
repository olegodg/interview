package ru.gb.homework5;

import lombok.extern.java.Log;

import java.util.List;

@Log
public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("Student " + (i + 1));
            student.setMark((int) (Math.random() * 6));
            studentDAO.saveStudent(student);

        }
        List<Student> list = studentDAO.getAllStudents();
        for (Student s:list){
            log.info("ИМЯ: "+s.getName()+"\nОЦЕНКА: "+s.getMark());
        }

        studentDAO.deleteStudent(2);


        Student newStudent =studentDAO.getStudent(1);
        newStudent.setName("BOB");
        newStudent.setMark(5);
        studentDAO.updateStudent(newStudent);

        Student s =studentDAO.getStudent(1);
        log.info("ИМЯ: "+s.getName()+"\nОЦЕНКА: "+s.getMark());

    }
}
