package uk.ac.shu.webarch.eregister

class Instructor {

    static constraints = {



    }

static mappedBy = [classes: 'instructor']

static hasMany = [classes: RegClass]
}
