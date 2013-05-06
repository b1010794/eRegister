package uk.ac.shu.webarch.eregister

class RegistrationSheet {

  
  Course course
  RegClass regClass

  // Shortcode
  String shortcode

  
  Date sheetDate

  Set signatories
  static hasMany = [signatories: RegisterEntry]
  static mappedBy = [signatories: 'regSheet']
  

String notes

  

  static constraints = {
    regClass(nullable:false, blank:false);
    shortcode(nullable:false, blank:false);
    sheetDate(nullable:false, blank:false);
    course(nullable:false, blank:false);
    notes(nullable:true, blank:true);
    version(nullable:true, blank:true);
  }

  static mapping = {
    notes column: 'course_desc', type:'text'

  }
}
