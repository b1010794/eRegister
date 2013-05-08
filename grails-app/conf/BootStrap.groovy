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
   def student_1 = Student.findByStudentNumber('a232') ?:
                  new Student(studentNumber:'a232', studentFullName:'Jack Lamb', notes:'Top student').save();

   def student_2 = Student.findByStudentNumber('a777') ?:
                  new Student(studentNumber:'a777', studentFullName:'Brian Gold', notes:'Poor attendance').save();


   def student_3 = Student.findByStudentNumber('a999') ?:
                  new Student(studentNumber:'a999', studentFullName:'Harry Bing', notes:'BING').save();


   def student_4 = Student.findByStudentNumber('a000') ?:
                  new Student(studentNumber:'a000', studentFullName:'Lewis Heart', notes:'n/a').save();


   def student_5 = Student.findByStudentNumber('a007') ?:
                  new Student(studentNumber:'a007', studentFullName:'Alad Hughes', notes:'n/a').save();

   def student_6 = Student.findByStudentNumber('a565') ?:
                  new Student(studentNumber:'a565', studentFullName:'Richard Cran', notes:'Slightly slow').save();



  
   

   println("Find or create ")

 //Enrolling students on classes 
   def student_1_web_arch = Enrollment.findOrCreateByStudentAndRegClass(student_1,monday_class).save();

   def student_2_web_arch = Enrollment.findOrCreateByStudentAndRegClass(student_2,monday_class).save();

   def student_3_web_arch = Enrollment.findOrCreateByStudentAndRegClass(student_3,monday_class).save();

   def student_4_web_app = Enrollment.findOrCreateByStudentAndRegClass(student_4,webApp_class).save();

   def student_5_web_app = Enrollment.findOrCreateByStudentAndRegClass(student_5,webApp_class).save();

   def student_6_web_app = Enrollment.findOrCreateByStudentAndRegClass(student_6,webApp_class).save();

   


   println("enrolled")

  }
    def destroy = {
    }
}
