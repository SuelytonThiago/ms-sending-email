<h1>Email sending microservice</h1>

<h2>About this project</h2>

<p>It is a micro-service for sending emails through the smtp tool of Google chrome</p>

<h1>Technologies used</h1>
<ul>
<li>Java</li>
<li>Spring boot</li>
<li>Maven</li>
<li>Jpa/Hibernate</li>
<li>Spring Security</li>
<li>RabbitMQ</li>
<li>PostgreSQL Database</li>
</ul>

<h1>How to run the project</h1>

<h2>Clone repository</h2>
<p><code>git clone https://github.com/SuelytonThiago/ms-sending-email</code></p>

<h2>Run this rabbitmq container</h2>
<ol>
 <li><p>Start Docker</p></li>

 <li><p>In a terminal go to the project folder and start the rabbitmq container with the code: 

docker-compose up -d</p></li>

 <li><p>After the container starts,
go to your browser and enter the following url: 

localhost:15672</li></p>

 <li><p>To authenticate in rabbitmq use: <br> user: admin <br> password: 123456</p></li>

<p>In the file
application.properties has two environment variables that must be set correctly for smooth functioning of smtp for sending emails.
In the field
spring.mail.username, enter your email , and in the spring.mail.password field enter the 16-digit app password that is generated by google, if you try to use your usual password the program will not work properly.
If you don't know how to generate this password, visit the <a href="https://support.google.com/accounts/answer/185833">link.</a></p>

</ol>
<h2>Run the project</h2>
<p>./mvnw spring-boot:run</p>

<p>To test the endpoints, just use postman or access the swagger documentation with the url: localhost:(your port)/swagger-ui/index.html</p>

<h1>Author</h1>
<p>Suelyton Thiago de Lima souza <a href="https://www.linkedin.com/in/suelyton-souza-0baaa127a/">/linkedin</a></p>



