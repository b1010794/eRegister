package uk.ac.shu.webarch.eregister

 class RegClass {
 
  
   String name

   //code used to enable cool URLS
   String classCode

 
   Instructor classInstructor
 
  
  Course course

  
  Set enrolledStudents

  Set registrationSheets

  

  static hasMany = [enrolledStudents: Enrollment, registrationSheets: RegistrationSheet]

  static mappedBy = [enrolledStudents: 'regclass', registrationSheets:'regClass']

   static constraints = {
   }
 
   static mapping = {
     classInstructor column:'instructor_fk'
    course column:'course_fk'
  }
 }
