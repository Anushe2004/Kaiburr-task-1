# Task 1 - Kaiburr Task Manager

### Overview of the project

To Implement an application in Java which provides a REST API with endpoints for searching, creating, deleting and running “task” objects. Task objects represent shell commands that can be run in a kubernetes pod. Each “task” object should contain the following properties:

* id (task ID, String)
* name (task name, String)
* owner (task owner, String)
* command (shell command to be run, String)
* taskExecutions (List<TaskExecuton>)
  
TaskExecution:
* startTime (execution start date/time, Date)
* endTime (execution end date/time, Date)
* output (command output, String)

### Technologies Used 
Backend: Java, Spring Boot, Spring Web, Spring Data MongoDB

Frontend: HTML, Bootstrap 5, JavaScript

Database: MongoDB (local)

Build Tool: Maven

Other: REST APIs, JSON, CRUD operations

### Folder Structure
```bash
kaiburr-internship/
│
├── task1-taskmanager/                # Task 1: Kaiburr Task Manager (Partial)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kaiburr/taskapi/...  # Spring Boot backend code
│   │   │   └── resources/static/index.html   # Frontend HTML
│   │   └── test/...                          # Unit tests (optional)
│   ├── pom.xml                               # Maven configuration
```                          

##   Dependencies
  * spring-boot-starter-web
  * spring-boot-starter-data-mongodb
  * spring-boot-maven-plugin
 
    
### Current issues:
  - Adding a new task does not immediately show in the table (needs further debugging).
    
### Next steps:
  - Fix task persistence and auto-refresh on add/update.

### Screenshots
<img width="1337" height="370" alt="image" src="https://github.com/user-attachments/assets/5444721e-26f1-42b7-a7c6-8857a20f9e1e" />

⚠️ Note: This task is partially implemented. Some features (like auto-refresh after adding tasks) may not work as expected.

And this is my Task 5 github profile:https://github.com/Anushe2004/Kaiburr-task-5


