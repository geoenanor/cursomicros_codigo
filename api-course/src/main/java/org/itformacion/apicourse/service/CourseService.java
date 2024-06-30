package org.itformacion.apicourse.service;


import org.itformacion.apicourse.client.StudentClient;
import org.itformacion.apicourse.model.Course;
import org.itformacion.apicourse.model.CourseStudent;
import org.itformacion.apicourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;


    private final StudentClient studentClient;

    public CourseService(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }


    public void save(Course course) {
        courseRepository.save(course);
    }


    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }


    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public void update(Course course) {
        if (courseRepository.existsById(course.getCourseId())) {
            courseRepository.save(course);
        }
    }

    public void addStudent(Long idCourse, Long idStudent) throws Exception {
        var course = courseRepository.findById(idCourse);
        if (course.isPresent()) {

            //course.get().getStudents().add(new CourseStudent(null, course.get(),idStudent));
            StudentClient.Student student = studentClient.getById(idStudent);

            if (student == null)
                throw new Exception("Student not found");
            else
                course.get().getStudents().add(new CourseStudent(null, course.get() , student.getStudentId()));

            courseRepository.save(course.get());
        }else{
            throw new Exception("Course not found");
        }
    }
}
