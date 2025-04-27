# Incident Management API
This is a Spring Boot project that provides a simple Incident Management REST API using MongoDB as the database.

## 🛠️ Tech Stack
Language: Java 17+

Framework: Spring Boot

Database: MongoDB

Build Tool: Maven

### 📦 How to Build and Run Locally
Clone the repository:


git clone <your-repository-link>
cd <your-project-folder>
Install dependencies and build the project:


mvn clean install
Run the project:


mvn spring-boot:run
🛠️ MongoDB Setup
Install and start MongoDB locally (default host and port are used):

Host: localhost

Port: 27017

#### Create a database:

MongoDB will automatically create the database incidents and the collection incidents when the first incident is inserted.

No manual schema setup is required.

##### ⚙️ Configuration
Configuration is done via the application.properties file:

properties

spring.application.name=Project
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=incidents
Make sure MongoDB is running locally, or update these properties accordingly.

###### 🔥 API Endpoints
All endpoints are under the base URL: /incidents


HTTP Method	Path	Description
GET	/incidents	Fetch all incidents
GET	/incidents/{id}	Fetch a single incident by ID
POST	/incidents	Create a new incident
DELETE	/incidents/{id}	Delete an incident by ID
####### 🧪 Example Usage
Create Incident (POST)


curl -X POST http://localhost:8080/incidents \
-H "Content-Type: application/json" \
-d '{
  "title": "Server Down",
  "description": "The production server is down.",
  "severity": "High"
}'
Get All Incidents (GET)


curl http://localhost:8080/incidents
Get Incident by ID (GET)


curl http://localhost:8080/incidents/{id}
Delete Incident (DELETE)


curl -X DELETE http://localhost:8080/incidents/{id}
######## 🧠 Design Decisions
Validation: Severity field only accepts "Low", "Medium", or "High". If not, returns 400 BAD REQUEST.

Error Handling: Returns 404 NOT FOUND if an incident is not found by ID.

Timestamping: Incident's reportedAt is automatically set to the current time when created.
