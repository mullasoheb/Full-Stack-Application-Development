package Task10.controller;

import Task10.entity.Student;
import Task10.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // root URL
    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/students";
    }

    // list students
    @GetMapping
    public String viewStudents(Model model) {
        model.addAttribute("students", service.getAll());
        return "List";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "Form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.create(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "Form";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}