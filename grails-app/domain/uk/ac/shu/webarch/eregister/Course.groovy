package uk.ac.shu.webarch.eregister

class Course {
  //name  
  String courseName

  //course code
  String courseCode

  //description
  String description

  // new set called classes
  Set classes

  
  static constraints = {
    courseCode maxSize: 20
  }


    static hasMany = [classes: RegClass]
    static mappedBy = [classes: 'course']

  
  static mapping = {
    table 'course'
    courseName column: 'course_name'
    courseCode column: 'mapped_course_code'
    description column: 'course_desc', type:'text'
  }
}
