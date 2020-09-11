package app

import demo.RandomPersonService
import grails.validation.Validateable
import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus

@CompileStatic
class PersonController {
    RandomPersonService randomPersonService
    def index() {
        PersonCommand cmd = new PersonCommand()
        cmd.name = randomPersonService.randomOciPersonName()
        cmd.title = "Grand Architect"
        respond cmd, [view: 'index', status: HttpStatus.OK]
    }
}

class PersonCommand implements Validateable {
    String name
    String title

    static constraints = {
        name(nullable: false)
    }

    static boolean defaultNullable() {
        true
    }
}

