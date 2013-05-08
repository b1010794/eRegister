package uk.ac.shu.webarch.eregister

import grails.converters.*


class ClassesController {

  def index() {

        println(request)

    def result=[:]

    // get all classes
    result.classList = []

    RegClass.findAll().each {cls ->
       result.classList.add([instructorName:cls.classInstructor.instructorName,
                            courseName:cls.course.courseName,
                            courseCode:cls.course.courseCode,
                            classCode:cls.classCode,
                            className:cls.name])
     }

    withFormat {
      html result
      xml { render result as XML }
      json { render result as JSON }
     }
}

    //declaring courseHome actions
    def courseHome() {
    println("ClassesController::courseHome ${params}");
    def result = [:]
    result.course = Course.findByCourseCode(params.courseCode)
    if ( result.course == null ) {
      response.sendError(404)
    }
  
    result
  }


   //declaring classHome actions
    def classHome() {
    
    def result = [:]
    result.cls = RegClass.findByClassCode( params.classCode)
    if ( result.cls == null ) {
      response.sendError(404)   
    }

    result.sheetsSoFar = result.cls.registrationSheets.size();

    println("classHome - method was ${request.method} shortcode=${params.shortcode}");
    println(result.cls);
    println("ClassesController::classHome ${params}");
    switch ( request.method ) {
      case 'POST':
        println("Creating new sheet");
        def new_sheet = new RegistrationSheet(regClass:result.cls,
                                              shortcode:params.shortcode,
                                              course:params.courseCode,
                                              sheetDate:new Date()).save();
        redirect(mapping:'signInSheet', params:[courseCode:params.courseCode,classCode:params.classCode,sheetCode:params.shortcode])

        break;
      case 'GET':
        println("Create new sheet");
        break;
    }

    result.studentStats = generateStudentStats(result.cls, result.sheetsSoFar)
 
    result
  }


 def generateStudentStats(class_info, possible) {
    // Creating a list containing each student and their attendance for the class
    def result = []
    class_info.enrolledStudents.each { es ->
      def student_info = [:]
      student_info.student = es.student;
      def student_attendance_query = RegisterEntry.where { student == es.student && regSheet.regClass == class_info };      
      student_info.classesAttended = student_attendance_query.list().size()
      println("classes attended: ${student_info.classesAttended} / ${possible}");
      if ( possible > 0 )
        student_info.attendance = student_info.classesAttended / possible * 100

      result.add(student_info)
    }
    return result;
  }


  //declaring signInSheet actions
  def signInSheet() {
    def result = [:]
    result.sheet = RegistrationSheet.findByShortcode(params.sheetCode)
    println(result.sheet);
    if ( result.sheet == null ) {
      response.sendError(404)   
    }

    println("signInSheet ${params.studentNumber}");

    switch ( request.method ) {
      case 'POST':
        if ( params.regAction=='sign' ) {
          println("Sign register for \"${params.studentNumber}\"");
          Student s = Student.findByStudentNumber(params.studentNumber)
          if ( s ) {
            RegisterEntry re = new RegisterEntry(regSheet:result.sheet,student:s,timestamp:System.currentTimeMillis()).save();
          }
          else {
            println("Unknown student");
            flash.message = "Unknown student";
          }
        }
        break;
      case 'GET': println("Create new sheet");
       
        break;
    } 

    result
  }
}   
