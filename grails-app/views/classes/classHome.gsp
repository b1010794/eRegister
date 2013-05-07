<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to the eRegister</title>
		
	</head>
	<body>

 <div class="nav" role="navigation">
			<ul>
                        <li> <g:link mapping="classes">>Classes</g:link></li>

				<li> <g:link mapping="courseHome"
                        params="${[courseCode:cls.course.courseCode]}">>Course Home</g:link></li>

                                <li> <g:link mapping="classHome"
                        params="${[courseCode:cls.course.courseCode, classCode:cls.classCode]}">>Class Home</g:link></li><br>
			<br><hr/><br>	
				<li><p> Class Name : ${cls.name},
    Course : ${cls.course.courseName},
    Class code : ${cls.classCode},
    Taught By : ${cls.classInstructor?.instructorName},
    Number of sheets to date : ${sheetsSoFar}</p>
     </li>
							
			</ul>
		</div>

    
   
    <br>
    <br/>
    <h1>Sign In Sheets Available</h1>
    <table>
      <tr><th>Code</th><th>Date</th><th>Attendance</th></tr>
      <g:each in="${cls.registrationSheets}" var="sheet">
        <tr>
          <td><g:link mapping="signInSheet" params="${[courseCode:cls.course.courseCode,classCode:cls.classCode,sheetCode:sheet.shortcode, ]}">${sheet.shortcode}</g:link></td>
          <td><g:link mapping="signInSheet" params="${[courseCode:cls.course.courseCode,classCode:cls.classCode,sheetCode:sheet.shortcode]}">${sheet.sheetDate}</g:link></td>
          <td>${sheet.signatories?.size()}</td>
        </tr>
      </g:each>    
    </table>
    
    <hr/>
    <h1>Students</h1>
    <table>
      <tr> 
        <th>Student Number</th>
        <th>Name</th>
        <th>Classes Present</th>
        <th>Possible</th>
        <th>%</th>
      </tr>
      <g:each in="${studentStats}" var="student">
        <tr>
          <td>${student.student.studentNumber}</td>
          <td>${student.student.studentFullName}</td>
          <td>${student.classesAttended}</td>
          <td>${sheetsSoFar}</td>
          <td>${student.attendance}</td>
        </tr>
      </g:each>    
    </table>
<hr/>
    <h1>  <g:form mapping="classHome" params="${[courseCode:cls.course.courseCode,classCode:cls.classCode]}" method="POST">
      New Sign In Sheet - Enter Shortcode: <input type="text" name="shortcode"/> 
      <input type="submit"/>
    </g:form></h1><br>

         

        </body>
</html>
