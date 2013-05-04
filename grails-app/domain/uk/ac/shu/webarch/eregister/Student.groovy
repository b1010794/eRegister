package uk.ac.shu.webarch.eregister

class Student {

   String studentFullName
   String studentNumber

      static constraints = {
    studentFullName(nullable:false, blank:false,maxSize:256);
    studentNumber(nullable:false, blank:false,maxSize:256);
  }
 }
