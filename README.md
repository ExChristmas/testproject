# testproject
<div>Spring Boot 2.5.0</div><br/>
<div>MongoDB 4.4,6</div><br/>

<div>The application is a small REST service. It is possible to query 
for all columns of an entity and get an ID, and you can also contact
a resource ID and get an entity</div><br/>
<div>Before starting the project, you should start your mongo server.</div>
<div>For running this project use maven.</div>
<div>For build the project,go to directory with the project and run this command:</div>

```
mvn compile
```

<div>And for runing the project, run the command:</div>

```
mvn exec:java -Dexec.mainClass="tasks.rest.testproject.TestprojectApplication"
```

<div>Results HTTP requests:</div>

![Alt-текст](https://github.com/ExChristmas/testproject/blob/master/GETBYID.jpg?raw=true
"query results by id")

![Alt-текст](https://github.com/ExChristmas/testproject/blob/master/GETBYQUERY.jpg?raw=true
"query results by parameters")