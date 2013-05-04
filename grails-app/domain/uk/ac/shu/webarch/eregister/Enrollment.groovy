package uk.ac.shu.webarch.eregister

class Enrollment {

  Student student
  Course course
  RegClass regclass

  static constraints = {
  }

  static mapping = {
    table 'course_student'
    student column: 'student_fk'
    course column: 'course_fk'
  }
}
