package uk.ac.shu.webarch.eregister

class Course {
  
  String courseName
  String courseCode
  String description

  static constraints = {
    courseCode maxSize: 20
  }

  
  static mapping = {
    table 'course'
    courseName column: 'course_name'
    courseCode column: 'mapped_course_code'
    description column: 'course_desc', type:'text'
  }
}
