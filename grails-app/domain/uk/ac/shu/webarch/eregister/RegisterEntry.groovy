package uk.ac.shu.webarch.eregister

class RegisterEntry {

  
  Student student

 
  RegistrationSheet regSheet


 
  Long timestamp

  
  static constraints = {
    timestamp(nullable:false, blank:false);
  }

  
  static mapping = {
    table 'student_register_entry'
    student column: 'student_fk'
    regSheet column: 'reg_sheet_fk'
  }
}
