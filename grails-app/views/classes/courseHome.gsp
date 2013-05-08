<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to the eRegister</title>
		
	</head>
	<body>
              <!--Nav Bar-->

                <div class="nav" role="navigation">
			<ul>
				 <li> <g:link mapping="classes">>Classes</g:link></li>
							
			</ul>
		</div>
       <!--showing classes for course-->
      <h1>${course.courseName}</h1>
    <h4>${course.description}</h4>
    <hr/>
    <h1>Classes for this course: </h1>
    <table>
      <tr>
        <th>Class Name</th>
        <th>Short Code</th>
        <th>Instructor</th>
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
