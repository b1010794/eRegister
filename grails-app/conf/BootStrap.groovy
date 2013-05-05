import uk.ac.shu.webarch.eregister.*;

class BootStrap {

    def init = { servletContext ->
      
    println("BootStrap::init");
    def ed_instructor = Instructor.findByStaffId("777777e") ?: new Instructor(staffId:"777777e",instructorName:"Ed Gunn").save();
    def steve_instructor = Instructor.findByStaffId("124354e") ?: new Instructor(staffId:"124354e",instructorName:"Steve Jones").save();

    def web_arch_course = Course.findByCourseCode("171717w") ?: new Course(courseCode:"171717w",
                                                                           courseName:"Web Architectures",
                                                                           description:"Web Architectures course").save();

    def monday_class = RegClass.findByName("WebArch-Mondays") ?: new RegClass(name:"WebArch-Mondays",classInstructor:ed_instructor, course:web_arch_course).save();


  }
    def destroy = {
    }
}
