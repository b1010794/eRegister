package uk.ac.shu.webarch.eregister

 class RegClass {
 
  
   String name

 
   Instructor classInstructor
 
  static constraints = {
  }

  static mapping = {
    classInstructor column:'instructor_fk'
  }
 }
