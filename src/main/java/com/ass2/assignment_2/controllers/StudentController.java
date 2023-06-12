package com.ass2.assignment_2.controllers;

import com.ass2.assignment_2.models.Student;
import com.ass2.assignment_2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
// @RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studRepo;

    @GetMapping("/students/view")
    public String getAllStudents(Model model){
        System.out.println("getting students");
        List<Student> students = studRepo.findAll();
        Collections.sort(students, Comparator.comparing(Student::getName));
   
        model.addAttribute("st", students);
        return "students/index";
    }

    @GetMapping("/students/add")
    public String showAddPage() {
        return "students/add";
    }

    @GetMapping("/students/display")
    public String showHistogram(Model model){
        System.out.println("getting students for histo");
        List<Student> students = studRepo.findAll();
        Collections.sort(students, Comparator.comparing(Student::getName));
        model.addAttribute("st", students);
        return "students/display";
    }


    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam Map<String, String> newstudent, Model model) {
        // Student student = studRepo.findById(id).get();
        int sid = Integer.parseInt(newstudent.get("id"));
        System.out.println("delete student: " + sid);
        // int id = Integer.parseInt(sid);
        Student student = studRepo.findById(sid).get();
        studRepo.delete(student);
        List<Student> students = studRepo.findAll();
        model.addAttribute("st", students);
        return "redirect:/students/view";
    }

    @PostMapping("/students/deleteHisto")
    public String deleteStudentHisto(@RequestParam Map<String, String> newstudent, Model model) {
        // Student student = studRepo.findById(id).get();
        int sid = Integer.parseInt(newstudent.get("id"));
        System.out.println("delete student: " + sid);
        // int id = Integer.parseInt(sid);
        Student student = studRepo.findById(sid).get();
        studRepo.delete(student);
        List<Student> students = studRepo.findAll();
        model.addAttribute("st", students);
        return "redirect:/students/display";
    }

    @PostMapping("/students/edit")
    public String editStudent(@RequestParam Map<String, String> newstudent, Model model) {
        // Student student = studRepo.findById(id).get();
        int sid = Integer.parseInt(newstudent.get("id"));
        System.out.println("get student: " + sid);
        // int id = Integer.parseInt(sid);
        Student student = studRepo.findById(sid).get();
        String newName = newstudent.get("name");
        String newLast = newstudent.get("last_name");
        int newHeight = Integer.parseInt(newstudent.get("height")); 
        int newWeight = Integer.parseInt(newstudent.get("weight")); 
        String newHair = newstudent.get("hair_color");
        float newGPA = Float.parseFloat(newstudent.get("GPA")); 
        if (student != null) {
            student.setName(newName);
            student.setLast_name(newLast);
            student.setHeight(newHeight);
            student.setWeight(newWeight);
            student.setHair_color(newHair);
            student.setGPA(newGPA);
            // Update other attributes if needed
            studRepo.save(student);
        }
        return "redirect:/students/view";
    }
    @PostMapping("/students/editHisto")
    public String editHisto(@RequestParam Map<String, String> newstudent, Model model) {
        // Student student = studRepo.findById(id).get();
        int sid = Integer.parseInt(newstudent.get("id"));
        System.out.println("get student: " + sid);
        // int id = Integer.parseInt(sid);
        Student student = studRepo.findById(sid).get();
        String newName = newstudent.get("name");
        String newLast = newstudent.get("last_name");
        int newHeight = Integer.parseInt(newstudent.get("height")); 
        int newWeight = Integer.parseInt(newstudent.get("weight")); 
        String newHair = newstudent.get("hair_color");
        float newGPA = Float.parseFloat(newstudent.get("GPA")); 
        if (student != null) {
            student.setName(newName);
            student.setLast_name(newLast);
            student.setHeight(newHeight);
            student.setWeight(newWeight);
            student.setHair_color(newHair);
            student.setGPA(newGPA);

            studRepo.save(student);
        }
        return "redirect:/students/display";
    }


//     @GetMapping("/students/edit/{sid}")
// public String editStudent(@PathVariable String sid, @ModelAttribute Student updatedStudent, Model model) {
    
//     int id = Integer.parseInt(sid);
//     Student student = studRepo.findById(id).orElse(null);
//     if (student != null) {
//         student.setName(updatedStudent.getName());
//         student.setLast_name(updatedStudent.getLast_name());
//         student.setHeight(updatedStudent.getHeight());
//         student.setWeight(updatedStudent.getWeight());
//         student.setHair_color(updatedStudent.getHair_color());
//         student.setGPA(updatedStudent.getGPA());
//         // Update other attributes if needed
//         studRepo.save(student);
//     }
//     // List<Student> students = studRepo.findAll();
//     // model.addAttribute("st", students);
//     return "redirect:/students/view"; // or the appropriate view name
// }



    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String, String> newstudent,HttpServletResponse response){
        System.out.println("Add student");
        String newName = newstudent.get("name");
        String newLast = newstudent.get("last_name");
        int newHeight = Integer.parseInt(newstudent.get("height")); 
        int newWeight = Integer.parseInt(newstudent.get("weight")); 
        String newHair = newstudent.get("hair_color");
        float newGPA = Float.parseFloat(newstudent.get("GPA")); 
        studRepo.save(new Student(newWeight, newName, newLast,newHeight, newWeight, newHair, newGPA));
        response.setStatus(201);
        return "redirect:/students/view";
    }

}
