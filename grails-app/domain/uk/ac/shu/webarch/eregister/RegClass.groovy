package uk.ac.shu.webarch.eregister

 class RegClass {
 
   //name
   String name

   //code used to enable cool URLS
   String classCode

   //setting link to instructor
   Instructor classInstructor
 
  //setting link to course
  Course course

  //new set called enrolled students  
  Set enrolledStudents


  //new set called registration sheets
  Set registrationSheets

  

  static hasMany = [enrolledStudents: Enrollment,  
                    registrationSheets: RegistrationSheet]

  static mappedBy = [enrolledStudents: 'regClass', 
                     registrationSheets:'regClass']

   static constraints = {
   }
 
   static mapping = {
     classInstructor column:'instructor_fk'
    course column:'course_fk'
  }
 }
