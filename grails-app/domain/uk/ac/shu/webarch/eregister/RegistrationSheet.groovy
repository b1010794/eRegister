package uk.ac.shu.webarch.eregister

class RegistrationSheet {

  
  Course course

  
  Date sheetDate

  Set signatories
  static hasMany = [signatories: RegisterEntry]
  static mappedBy = [signatories: 'regSheet']
  

String notes

  

  static constraints = {
    course(nullable:false, blank:false);
    sheetDate(nullable:false, blank:false);
    notes(nullable:true, blank:true);
  }

  static mapping = {
    notes column: 'course_desc', type:'text'
  }
}
