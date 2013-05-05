package uk.ac.shu.webarch.eregister

class RegisterController {

 def index() { 
    
    
    def result = [:]
    log.debug("name parameter was ${params.name}")
    
   
    result.nameparam = params.name
    
    
    return result
  }

}
