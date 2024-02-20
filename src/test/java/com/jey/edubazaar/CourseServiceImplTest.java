// package com.jey.edubazaar;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.jey.edubazaar.entity.Course;
// import com.jey.edubazaar.entity.User;
// import com.jey.edubazaar.exception.CourseNotFoundException;
// import com.jey.edubazaar.exception.UserNotFoundException;
// import com.jey.edubazaar.repository.CourseRepository;
// import com.jey.edubazaar.repository.UserRepository;
// import com.jey.edubazaar.service.CourseServiceImpl;

// public class CourseServiceImplTest {

//     @Mock
//     private CourseRepository courseRepository;

//     @Mock
//     private UserRepository userRepository;

//     @InjectMocks
//     private CourseServiceImpl courseService;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     public void testCreateCourse() {
//         Course course = new Course();
//         Long adminId = 1L;

//         String expectedMessage = "Course deleted successfully";

//         String actualMessage = courseService.createCourse(adminId, course);

//         assertEquals(expectedMessage, actualMessage);
//     }

//     @Test
//     public void testGetCourse() {
//         Long courseId = 1L;
//         Course course = new Course();
//         when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

//         Course actualCourse = courseService.getCourse(courseId);

//         assertEquals(course, actualCourse);
//     }

//     @Test
//     public void testGetCourse_CourseNotFoundException() {
//         Long courseId = 1L;
//         when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

//         assertThrows(CourseNotFoundException.class, () -> {
//             courseService.getCourse(courseId);
//         });
//     }

//     @Test
//     public void testGetAllCourses() {
//         List<Course> courses = new ArrayList<>();
//         when(courseRepository.findAll()).thenReturn(courses);

//         List<Course> actualCourses = courseService.getAllCourses();

//         assertEquals(courses, actualCourses);
//     }

//     @Test
//     public void testGetPublishedCourses() {
//         List<Course> courses = new ArrayList<>();
//         courses.add(new Course());
//         courses.add(new Course());
//         courses.get(0).setPublished(true);

//         when(courseRepository.findAll()).thenReturn(courses);

//         List<Course> actualCourses = courseService.getPublishedCourses();

//         assertEquals(1, actualCourses.size());
//         assertEquals(courses.get(0), actualCourses.get(0));
//     }

//     @Test
//     public void testPurchaseCourse() {
//         Long userId = 1L;
//         Long courseId = 1L;
//         User user = new User();
//         Course course = new Course();

//         when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//         when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

//         String expectedMessage = "Course purchased successfully";

//         String actualMessage = courseService.purchaseCourse(userId, courseId);

//         assertEquals(expectedMessage, actualMessage);
//         assertEquals(1, course.getUsers().size());
//         assertEquals(user, course.getUsers().iterator().next());
//     }

//     @Test
//     public void testPurchaseCourse_UserNotFoundException() {
//         Long userId = 1L;
//         Long courseId = 1L;

//         when(userRepository.findById(userId)).thenReturn(Optional.empty());

//         assertThrows(UserNotFoundException.class, () -> {
//             courseService.purchaseCourse(userId, courseId);
//         });
//     }

//     @Test
//     public void testPurchaseCourse_CourseNotFoundException() {
//         Long userId = 1L;
//         Long courseId = 1L;
//         User user = new User();

//         when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//         when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

//         assertThrows(CourseNotFoundException.class, () -> {
//             courseService.purchaseCourse(userId, courseId);
//         });
//     }

//     @Test
//     public void testGetPurchasedCourses() {
//         Long userId = 1L;
//         User user = new User();
//         user.setCourses(new HashSet<>());

//         when(userRepository.findById(userId)).thenReturn(Optional.of(user));

//         Set<Course> purchasedCourses = courseService.getPurchasedCourses(userId);

//         assertEquals(user.getCourses(), purchasedCourses);
//     }

//     @Test
//     public void testGetPurchasedCourses_UserNotFoundException() {
//         Long userId = 1L;

//         when(userRepository.findById(userId)).thenReturn(Optional.empty());

//         assertThrows(UserNotFoundException.class, () -> {
//             courseService.getPurchasedCourses(userId);
//         });
//     }

//     @Test
//     public void testUpdateCourse() {
//         Long courseId = 1L;
//         Course course = new Course();
//         Course updatedCourse = new Course();
//         updatedCourse.setTitle("Updated Title");
//         updatedCourse.setDescription("Updated Description");
//         updatedCourse.setPrice(100.0);
//         updatedCourse.setPublished(true);

//         when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
//         when(courseRepository.save(ArgumentMatchers.any(Course.class))).thenReturn(updatedCourse);

//         String expectedMessage = "Course updated successfully";

//         String actualMessage = courseService.updateCourse(courseId, updatedCourse);

//         assertEquals(expectedMessage, actualMessage);
//         assertEquals(updatedCourse.getTitle(), course.getTitle());
//         assertEquals(updatedCourse.getDescription(), course.getDescription());
//         assertEquals(updatedCourse.getPrice(), course.getPrice());
//         assertEquals(updatedCourse.isPublished(), course.isPublished());
//     }

//     @Test
//     public void testUpdateCourse_CourseNotFoundException() {
//         Long courseId = 1L;
//         Course course = new Course();

//         when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

//         assertThrows(CourseNotFoundException.class, () -> {
//             courseService.updateCourse(courseId, course);
//         });
//     }

//     @Test
//     public void testDeleteCourse() {
//         Long courseId = 1L;
//         Course course = new Course();

//         when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

//         String expectedMessage = "Course deleted successfully";

//         String actualMessage = courseService.deleteCourse(courseId);

//         assertEquals(expectedMessage, actualMessage);
//     }

//     @Test
//     public void testDeleteCourse_CourseNotFoundException() {
//         Long courseId = 1L;

//         when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

//         assertThrows(CourseNotFoundException.class, () -> {
//             courseService.deleteCourse(courseId);
//         });
//     }
// }