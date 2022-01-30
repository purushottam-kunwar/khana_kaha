package myapp

class UrlMappings {

    static mappings = {
        group "/api", {
            group "/v1", {
                "/"(controller: 'application', action: 'dashboard')
                group "/user", {
                    "/create"(controller: 'user', action: 'create')
                }
            }
        }

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
