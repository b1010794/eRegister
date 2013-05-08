# eRegister
=========

## Overview

This project is a case study I created for the 12/13 web architectures module at Sheffield Hallam uni.

It's used to explore various aspects of web application including

* Configuration management - how the web dev process interacts with git
* Domain modelling - Transitioning from class models to MVC database structures
* Controller developmnet
* RESTful web services


## Cloning Running the project

In order to get and run my project simply:
* Open terminal
* Type in "git clone https://github.com/b1010794/eRegister.git"
* Then type "cd eRegister"
* Finally type "grails runn-app" and navigate to the link that will appear in terminal

### What is needed to run this app? 

* You will need s a running local mysql database called eregister and by default connects to the database using a user called webarch and a password of webarch. Obviously this should be changed in a production environment.
* Use the mysql "create database [database_name]" command to create database called "eregister" with default charset utf8 and  default collate utf8_bin;.
* The project is a groovy/grails project and needs an installed Java7 JDK and installed grails SDK, preferably grails 2.1.3 (http://www.grails.org)


## What I have learned

* The main thing I learned during this project was how to trouble shoot in grails and the importance of "println". Using "pritln" helped me to narrow down the possible location of errors in code numerous times and really helped to speed up the process of finding and fixig errors.


