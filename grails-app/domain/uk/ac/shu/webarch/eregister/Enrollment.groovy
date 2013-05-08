package uk.ac.shu.webarch.eregister

class Enrollment {


  //setting link to student
  Student student

  //setting link to regclass
  RegClass regClass

  static constraints = {
  }

  static mapping = {
    table 'course_student'
    student column: 'student_fk'
    course column: 'course_fk'
  }
}
