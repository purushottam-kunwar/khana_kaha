package myapp

import grails.converters.JSON
import grails.core.GrailsApplication
import grails.plugins.*
import org.grails.web.json.JSONObject

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    static responseFormats = ['json', 'xml']
    static allowedMethods = [dashboard: "GET"]

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def dashboard() {
        JSONObject response = new JSONObject()
        response.put("message", "Welcome")

        render response as JSON
    }
}
