package com.example.homework33.service;


import com.example.homework33.component.RecordMapper;
import com.example.homework33.exception.FacultyNotFoundException;
import com.example.homework33.exception.StudentNotFoundException;
import com.example.homework33.model.Faculty;
import com.example.homework33.model.Student;
import com.example.homework33.record.FacultyRecord;
import com.example.homework33.record.StudentRecord;
import com.example.homework33.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RecordMapper recordMapper;


    public  StudentService(StudentRepository studentRepository,
                          RecordMapper recordMapper) {
        this.studentRepository = studentRepository;
        this.recordMapper = recordMapper;
    }

    public StudentRecord create(StudentRecord studentRecord){
        return recordMapper.toRecord(studentRepository.save(recordMapper.toEntity(studentRecord)));
    }

    public StudentRecord read(long id){
        return recordMapper.toRecord(studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }

    public StudentRecord update(long id,
                                StudentRecord studentRecord){
        Student oldStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        oldStudent.setAge(studentRecord.getAge());
        oldStudent.setName(studentRecord.getName());
        return recordMapper.toRecord(studentRepository.save(oldStudent));
    }

    public StudentRecord delete(long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
        return recordMapper.toRecord(student);
    }

    public Collection<StudentRecord> findByAge(int age){
        return studentRepository.findAllByAge(age).stream()
                .map(recordMapper: :toRecord)
                .collect(Collectors.toList());
    }


}
