<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to the eRegister</title>
		
	</head>
	<body>
      <h1>${course.courseName}</h1>
    <p>${course.description}</p>
    <hr/>
    Classes for this course: 
    <table>
      <tr>
        <td>Class Name</td>
        <td>Short Code</td>
        <td>Instructor</td>
      </tr>

      <g:each in="${course.classes}" var="cls">
        <tr>
          <td>${cls.name}</td>
          <td><g:link mapping="classHome"
                        params="${[courseCode:cls.course.courseCode,classCode:cls.classCode]}">${cls.classCode}</g:link>
</td>
          <td>${cls.classInstructor.instructorName}</td>
        </tr>
      </g:each>
    </table>
         

        </body>
</html>
