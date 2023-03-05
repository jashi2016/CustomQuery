# CustomQuery

StudentController
-It has all the methods responsible for saving student data
-getting data based on firstname,lastname, age
-updates student data

List of methods implemented:

1. Saving Student data
Method: private Student saveStudent(@RequestBody Student student)
Function: Saves Student data passed as requestbody
APi: localhost:8080/student/add


2. Get Student data
Method: private ResponseEntity<String> getAllStudents()
Custom name method:
    List<Student> findAll();
Query method:
    @Query(value = "SELECT * FROM student_table s", nativeQuery = true )
    List<Student> getAll();
Function: Gets all Student data from database
APi: localhost:8080/student/getAllStudents

3. Update Student data
Method: private ResponseEntity<String> updateStudent(@RequestBody Student student, @RequestParam Integer studentId)
Function: Updates all Student data in database with provided id
APi: localhost:8080/student/updateStudent

4.find Students based on firstname and lastname
Methods:
Custom name method:
    Student findByLastNameAndFirstName(String lastName, String firstName);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.last_name = ?1 AND s.first_name = ?2", nativeQuery = true )
    Student getByLastNameAndLastName(String lastName, String firstName);
    
5.find Students based on firstname or lastname
Methods:
Custom name method:
    Student findByLastNameOrFirstName(String lastName, String firstName);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.last_name = ?1 OR s.first_name = ?2", nativeQuery = true )
    Student getByLastNameOrLastName(String lastName, String firstName);
    
    
6.find Students based on whether he/she is active or not
Methods:
Custom name method:
    List<Student> findByActiveTrue();
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.active = true", nativeQuery = true )
    List<Student> getActiveStudent();
    
    
7.find Students based on firstname
Methods:
Custom name method:
    List<Student> findByFirstNameEquals(String firstName);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.first_name = ?1", nativeQuery = true )
    List<Student> getByFirstNameEquals(String firstName);
    
   
   
   
8.find Students based on age beetween a range
Methods:
Custom name method:
    List<Student> findByAgeBetween(int lowerLimit ,int upperLimit);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.age BETWEEN ?1 AND ?2", nativeQuery = true )
    List<Student> getByAgeBetween(int lowerLimit ,int upperLimit);
   
   
9.find Students who contains provided first name
Methods:
Custom name method:
    List<Student> findByFirstNameContaining(String firstName);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.first_name like %?%", nativeQuery = true )
    List<Student> getByFirstNameContaining(String firstName);
    
    
10.find Students who contains first name ending with letter/word provided
Methods:
Custom name method:
    List<Student> findByFirstNameEndingWith(String firstName);
Query method:
    @Query(value = "SELECT * FROM student_table s WHERE s.first_name like %?", nativeQuery = true )
    List<Student> getByFirstNameEndingWith(String firstName);
    
    
    
*Similarly other SQL keywords are implemented by using Custom name methods and query annotated methods
  
  
 ->Data Structures used are List from java.util library.
 -> We have used JSONObject to store the response and later format it as per oue needs.
 
 Technologies Used:
 ->JAVA
 -> SpringBoot
 ->SpringJPA
 
 Database used:
 ->H2 database

Flow:

Once the api is hit with respective data.
Controller will contact service class and executes respective methods.
From service method, it contacts respective repository and performs necessary action and returns the resukt to the controller
    
