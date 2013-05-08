package uk.ac.shu.webarch.eregister

class Instructor {
 
   //name
   String instructorName

   //staffId
   String staffId
 
  //new set called classes
  Set classes



  
   static hasMany = [classes: RegClass]
 
 
   static mappedBy = [classes: 'classInstructor']
  
  
   static constraints = {
    instructorName(nullable:false, blank:false,maxSize:256);
    staffId(nullable:false, blank:false,maxSize:20);
   }
 }
