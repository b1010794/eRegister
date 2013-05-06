import uk.ac.shu.webarch.eregister.*;

class BootStrap {

    def init = { servletContext ->
      
    println("BootStrap::init");

    //Declaring Instructors
    def ed_instructor = Instructor.findByStaffId("777777e") ?: new Instructor(staffId:"777777e",instructorName:"Ed Gunn").save();
    def steve_instructor = Instructor.findByStaffId("124354e") ?: new Instructor(staffId:"124354e",instructorName:"Steve Jones").save();


    //Declaring Courses
    def web_arch_course = Course.findByCourseCode("171717w") ?: new Course(courseCode:"171717w",
                                                                           courseName:"Web Architectures",
                                                                           description:"Web Architectures course").save();

    def web_app_course = Course.findByCourseCode("271728w") ?: new Course(courseCode:"271728w",
                                                                           courseName:"Web Application Development",
                                                                           description:"Design and implementation of Web Apps").save();



    //Declaring classes for each course
    def monday_class = RegClass.findByCourseAndClassCode(web_arch_course,"WA1") ?: new RegClass(name:"WebArch-Mondays",
                                                                              classInstructor:ed_instructor,
                                                                              classCode:"WA1", 
                                                                              course:web_arch_course).save();

    def webApp_class = RegClass.findByCourseAndClassCode(web_app_course,"WAD1") ?: new RegClass(name:"WebApp-Tuesdays",
                                                                              classInstructor:steve_instructor,
                                                                              classCode:"WAD1", 
                                                                              course:web_app_course).save();
   //declaring students
   def student_1 = Student.findByStudentNumber('a123') ?:
                  new Student(studentNumber:'a123', studentFullName:'Jim Jones', notes:'aka Jimbob').save();

  
   //declaring reg sheets 
   def testsheet = RegistrationSheet.findByShortcode("777") ?:
                            new RegistrationSheet(regClass: monday_class,
                                                  shortcode: "777",
                                                  sheetDate:new Date(),
                                                  course: web_arch_course).save();



 //Enrolling students on classes
 //  def student_1_web_arch = Enrollment.findByRegClassAndStudent(monday_class, student_1) ?: new Enrollment(student: student_1,
 //                                                                                                          regclass: monday_class,
 //                                                                                                          course: web_arch_course)
  //                                                                                                         .save();

  }
    def destroy = {
    }
}
