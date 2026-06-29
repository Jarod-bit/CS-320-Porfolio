CS 320 Software Testing Portfolio 
====================== 
About This Project 
------------------ 

This repository houses my portfolio artifacts for CS 320 software testing class. It demonstrates my ability to code Java classes based on provided software requirements, as well as develop unit tests to confirm software works properly. The main emphasis for this course was software testing, automation, and quality assurance.

Included files illustrate my implementation of unit testing to confirm proper functionality, validate user input and reject invalid data entry, and verify the program enforced required constraints. Files included are from my Contact Service project, however I worked with similar service files for Task and Appointment services throughout the course.


Included Files 
------------------ 

List of main Contact Service files included in portfolio:
* Contact.java 
* ContactService.java 
* ContactTest.java 
* ContactServiceTest.java 


List of additional service files worked with during class:
* Task.java 
* TaskService.java 
* TaskTest.java 
* TaskServiceTest.java 
* Appointment.java 
* AppointmentService.java 
* AppointmentTest.java 
* AppointmentServiceTest.java 


Project Summary 
------------------ 

Description of Contacts Service project: 
For the Contacts Service project, I was responsible for creating an object named Contact that included four fields. Contact included an ID, first name, last name, phone number, and address. Each field had requirements. Contact ID could not be null or exceed 10 characters, phone number could not be any length other than 10 numbers, and Address could not exceed 30 characters.

Contact Service class included four methods that allowed the user to add, delete, update, and retrieve contact objects. Each unit test confirms valid contacts can be created and added successfully, while invalid contacts are rejected. Tests also confirm that contact cannot be added with a duplicate ID, and that updating existing contacts works correctly.

Task Service project mirrored the Contact Service project. Task included an ID, name, and description. Tests confirm that tasks can be created, added, updated, deleted, and prevented from being added if they contain invalid data.


Reflection 
---------- 

How can I ensure that my code, program, or software is functional and secure? 

I can ensure my code functions correctly by writing tests. These tests should include normal use cases but should also focus on error cases. In this project, I wrote unit tests to confirm that valid objects are created while invalid inputs are rejected. I included test to failed when Contact fields were too long, fields were left blank, duplicate IDs were provided, and invalid phone numbers were used. If my tests pass, I can be reasonably sure that my code is functioning properly and that it meets the software requirements.

I learned that one of the best ways to ensure my code is secure is to validate everything. If I don't check the data my program is handling, it will accept incorrect, duplicate, or malicious data. Testing helped me confirm that my validation checks were working properly.


How do I interpret user needs and incorporate them into a program? 

To interpret user needs, I read the project requirements and translate them into my code and tests. If a requirement tells me something specific about the software, such as contact ID length must be under 10 characters, I make sure my Contact class enforces this. Then I write a unit test to confirm my code is following this requirement.

Taking the time to translate requirements into my code and tests ensures that my software does what the user/client wants. I no longer have to guess the functionality of the software. Instead, I break the requirements down into smaller components and develop my software around those specific needs. Then I test each component to verify it works correctly.


How do I approach designing software? 

I like to start with requirements. Once I know what the software should do, I identify the main objects the software needs, the fields those objects should have, and what actions can be performed on those objects. For this project, I created a class for the object itself, such as Contact or Task. Then I created a service class that managed those objects. Keeping these separated made the software easier to design, test, and maintain.

I also try to keep my software design simple. Every class should have a distinct purpose. My object classes are only responsible for storing information and validating data. The service classes handle the adding, deleting, and updating of those objects. Structuring my software this way made it easier for me to understand what each piece of code is supposed to do. It also allowed me to write more effective tests.

What I Learned 
-------------- 

I learned the importance of software testing. Unit tests allowed me to verify that my code did what was required and properly handled invalid inputs. I also learned that tests can be used to break my software. Finding and fixing problems during development is better than having someone else find them after my software is finished.

Completing this project has expanded my knowledge of software quality assurance. I now have a better understanding of how the software should behave in both successful and unsuccessful situations. I learned how to test for successful creates, updates, deletes, actions with duplicate data, null values, and incorrect inputs.
