import uk.ac.shu.webarch.eregister.*;

class BootStrap {

    def init = { servletContext ->
      
    println("BootStrap::init");
    def ed_instructor = Instructor.findByStaffId("777777e");

  if(ed_instructor == null){
    println("Instructor not found, create..");
    ed_instructor = new Instructor();
    ed_instructor.staffId = "777777e";
    ed_instructor.instructorName = "Ed Gunn";
    ed_instructor.save();
    }

    else{
    println("Result of find by staffId for ed: ${ed_instructor}");
    }
  }
    def destroy = {
    }
}
