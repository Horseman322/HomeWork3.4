package com.example.homework33.component;

import com.example.homework33.model.Faculty;
import com.example.homework33.model.Student;
import com.example.homework33.record.FacultyRecord;
import com.example.homework33.record.StudentRecord;
import org.springframework.stereotype.Component;

@Component
public class RecordMapper {

    public StudentRecord toRecord(Student student) {
        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setId(student.getId());
        studentRecord.setName(student.getName());
        studentRecord.setAge(student.getAge());
        return studentRecord;
    }

    public FacultyRecord toRecord(Faculty faculty) {
        FacultyRecord facultyRecord = new FacultyRecord();
        facultyRecord.setId(faculty.getId());
        facultyRecord.setName(faculty.getName());
        facultyRecord.setColor(faculty.getColor());
        return facultyRecord;
    }

    public Student toEntity(StudentRecord studentRecord){
        Student student = new Student();
        student.setName(studentRecord.getName());
        student.setAge(studentRecord.getAge());
        return student;
    }

    public Faculty toEntity(FacultyRecord facultyRecord){
        Faculty faculty = new Faculty();
        faculty.setName(facultyRecord.getName());
        faculty.setColor(facultyRecord.getColor());
        return faculty;
    }

}
