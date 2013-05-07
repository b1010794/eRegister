class UrlMappings {

	static mappings = {


                name classes: "/classes"(controller:'classes', action:'index')
                name courseHome: "/classes/$courseCode" (controller:'classes', action:'courseHome')
                name classHome: "/classes/$courseCode/$classCode" (controller:'classes', action:'classHome')
                name signInSheet: "/classes/$courseCode/$classCode/$sheetCode" (controller:'classes', action:'signInSheet')



		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
