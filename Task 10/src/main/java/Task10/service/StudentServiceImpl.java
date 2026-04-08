package Task10.service;

import Task10.entity.Student;
import Task10.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	@Override
	public Student getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Student create(Student student) {
		return repository.save(student);
	}

	@Override
	public Student update(Long id, Student student) {
		Student existing = repository.findById(id).orElse(null);

		if(existing != null) {
			existing.setName(student.getName());
			existing.setEmail(student.getEmail());
//			existing.setCourse(student.getCourse());
			return repository.save(existing);
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}