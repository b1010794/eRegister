<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to the eRegister</title>
		
	</head>
	<body>

                 <div class="nav" role="navigation">
			<ul>
				<li> </li>
							
			</ul>
		</div>

         <h1>Classes - All classes are listed below</h1> <br>


            <table>
            <thead>
            <tr>
            <th>Course Name</th>
            <th>Course Code</th>
            <th>Class Name</th>
            <th>Instructor</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${classList}" var="c"> 
            <tr>
            <td><g:link mapping="courseHome"
                        params="${[courseCode:c.courseCode]}">${c.courseName}</g:link></td>
            <td><g:link mapping="courseHome"
                        params="${[courseCode:c.courseCode]}">${c.courseCode}</g:link></td>
            <td><g:link mapping="classHome"
                        params="${[courseCode:c.courseCode,classCode:c.classCode]}">${c.className}</g:link></td>
            <td>${c.instructorName}</td>
            </tr>
            </g:each>
            </tbody>
            </table>
       
         

        </body>
</html>
