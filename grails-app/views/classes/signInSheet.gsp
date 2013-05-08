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
                               <li> <g:link mapping="courseHome"
                        params="${[courseCode:params.courseCode]}">>Course Home</g:link></li>

                                <li> <g:link mapping="classHome"
                        params="${[courseCode:params.courseCode, classCode:params.classCode]}">>Class Home</g:link></li>
			<li> <g:link mapping="signInSheet"
                        params="${[courseCode:params.courseCode, classCode:params.classCode, sheetCode:params.sheetCode]}">>Sign In Sheets</g:link></li>				
			</ul>
		</div>


      <h1>${sheet.regClass.name} - ${sheet.shortcode} - <g:formatDate format="dd-MMM-yyyy HH:mm" date="${sheet.sheetDate}"/></h1>
    <hr/>

    <g:form mapping="signInSheet" params="${[courseCode:params.courseCode,
                                           classCode:params.classCode,
                                           sheetCode:params.sheetCode]}"method="POST">
    

      <!--form to sign in-->
    <h1> <input type="hidden" name="regAction" value="sign"/>
      Enter student number to sign in: <input type="text" name="studentNumber"/> 
      <input type="submit"/></h1>
    </g:form>

    <br/>

     <!--Students thaat have signed in-->

   <h1> Present Students</h1> 
    <table>
      <tr>
        <th>Student Number</th>
        <th>Student Name</th>
        <th>Timestamp</th>
      </tr>

      <g:each in="${sheet.signatories}" var="sig">
        <tr>
          <td>${sig.student.studentNumber}</td>
          <td>${sig.student.studentFullName}</td>
          <td><g:formatDate format="dd-MMM-yyyy HH:mm" date="${new Date(sig.timestamp)}"/></td>
        </tr>
      </g:each>
    </table>
         

        </body>
</html>
