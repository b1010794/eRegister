package uk.ac.shu.webarch.eregister

class RegistrationSheet {

  
  
  RegClass regClass

  // Shortcode
  String shortcode

  
  Date sheetDate


  //new set called signatories
  Set signatories
  static hasMany = [signatories: RegisterEntry]
  static mappedBy = [signatories: 'regSheet']
  
   //notes
   String notes

  

  static constraints = {
    regClass(nullable:false, blank:false);
    shortcode(nullable:false, blank:false);
    sheetDate(nullable:false, blank:false);
    notes(nullable:true, blank:true);
  }

 
}
