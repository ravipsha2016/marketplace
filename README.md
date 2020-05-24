# marketplace

Swagger UI : http://localhost:8080/swagger-ui.html


Booking services for booking a car pool  or an individual cab with the cab aggregator.
For pooling , 4 passengers are needed and only the following combinations are permitted : 
All male
All Females 
2 Males , 2 Females
No other combinations are alllowed.

Multi threading synchronization has been  handled.

Primary Endpoints :

1. /book (POST)
   
   Input : {
  "destination": "string",
  "tripType": "SHARED",
  "user_uuid": "string"
}

Prerequisite : User must be registered, user_uuid will be obtained after registering the user.


2. /register/user (POST)

Input :
{
  "gender": "MALE",
  "name": "string",
  "user_UUId": "string"
}


3. /users (GET)
gets  all RegisteredUsers

4. /register/availability (POST)
for cabs.

