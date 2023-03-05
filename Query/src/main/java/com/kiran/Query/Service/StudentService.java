package com.kiran.Query.Service;

import com.kiran.Query.Model.Student;
import com.kiran.Query.Repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public Student saveStudent(Student student) {
        student.setAdmissionDate(new Date(System.currentTimeMillis()));
        return repository.save(student);
    }

    public JSONObject updateStudent(Student newStudent, Integer studentId) {
        JSONObject response = new JSONObject();
        try{
            Student oldStudent = repository.findById(studentId).get();
            if(newStudent.getAge() != null) oldStudent.setAge(newStudent.getAge());
            if(newStudent.getFirstName() != null) oldStudent.setFirstName(newStudent.getFirstName());
            if(newStudent.getLastName() != null) oldStudent.setLastName(newStudent.getLastName());
            if(newStudent.getAdmissionDate() != null) oldStudent.setAdmissionDate(newStudent.getAdmissionDate());
            if(newStudent.getActive() != null) oldStudent.setActive(newStudent.getActive());
            response.put("Updated",new JSONObject(repository.save(oldStudent)));
        }catch (Exception e){
            response.put("Error", e.toString());
        }
        return  response;
    }

    public JSONObject getStudent() {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findAll());
        response.put("Created by using query annotation", repository.getAll());
        return response;
    }

    public JSONObject getActiveStudent() {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByActiveTrue());
        response.put("Created by using query annotation", repository.getActiveStudent());
        return response;
    }

    public JSONObject getInactiveStudent() {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByActiveFalse());
        response.put("Created by using query annotation", repository.getInactiveStudent());
        return response;
    }
    public JSONObject findByLastNameAndFirstName(String lastName, String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", new JSONObject(repository.findByLastNameAndFirstName(lastName, firstName)));
        response.put("Created by using query annotation", new JSONObject(repository.getByLastNameAndLastName(lastName, firstName)));
        return response;
    }

    public JSONObject findByLastNameOrFirstName(String lastName, String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", new JSONObject(repository.findByLastNameOrFirstName(lastName, firstName)));
        response.put("Created by using query annotation", new JSONObject(repository.getByLastNameOrLastName(lastName, firstName)));
        return response;
    }

    public JSONObject findByFirstNameEquals(String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", new JSONObject(repository.findByFirstNameEquals(firstName)));
        response.put("Created by using query annotation", new JSONObject(repository.getByFirstNameEquals(firstName)));
        return response;
    }

    public JSONObject findByAgeBetween(Integer lowerLimit ,Integer upperLimit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeBetween(lowerLimit, upperLimit));
        response.put("Created by using query annotation", repository.getByAgeBetween(lowerLimit, upperLimit));
        return response;
    }

    public JSONObject findByAgeLessThan(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeLessThan(limit));
        response.put("Created by using query annotation", repository.getByAgeLessThan(limit));
        return response;
    }

    public JSONObject findByAgeLessThanEqual(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeLessThanEqual(limit));
        response.put("Created by using query annotation",repository.getByAgeLessThanEqual(limit));
        return response;
    }

    public JSONObject findByAgeGreaterThan(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeGreaterThan(limit));
        response.put("Created by using query annotation", repository.getByAgeGreaterThan(limit));
        return response;
    }

    public JSONObject findByAgeGreaterThanEqual(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeGreaterThanEqual(limit));
        response.put("Created by using query annotation", repository.getByAgeGreaterThanEqual(limit));
        return response;
    }


    public JSONObject findByFirstNameLike(String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method",repository.findByFirstNameLike("%" + firstName + "%"));
        response.put("Created by using query annotation", repository.getByFirstNameLike("%" + firstName + "%"));
        return response;
    }

    public JSONObject findByFirstNameStartingWith(String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByFirstNameStartingWith(firstName));
        response.put("Created by using query annotation", repository.getByFirstNameStartingWith(firstName));
        return response;
    }

    public JSONObject findByFirstNameContaining(String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByFirstNameContaining(firstName));
        response.put("Created by using query annotation", repository.getByFirstNameContaining(firstName));
        return response;
    }

    public JSONObject findByFirstNameEndingWith(String firstName) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByFirstNameEndingWith(firstName));
        response.put("Created by using query annotation", repository.getByFirstNameEndingWith(firstName));
        return response;
    }

    public JSONObject findByAgeGreaterThanOrderByLastNameDesc(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("Created by using custom named method", repository.findByAgeGreaterThanOrderByLastNameDesc(limit));
        response.put("Created by using query annotation", repository.getByAgeGreaterThanOrderByLastNameDesc(limit));
        return response;
    }
}