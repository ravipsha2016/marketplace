# marketplace

Endpoints :

"/book"
Sample input 
  0: male , 1: female
 
Book Passenger 1 
 {
"name":"Rahul",
"gender": 0 
}

sample respose :
{
    "status": "Success",
    "fellow_travellers": [],
    "registrationNumber": "KA01 AB 1233",
    "waitingForMorePassengers": true,
    "lastPassenger": false
}


Book Passenger#2
 {
"name":"Ravi",
"gender": 0 
}

sample respose :
{
    "status": "Success",
    "fellow_travellers": ["Rahul"],
    "registrationNumber": "KA01 AB 1233",
    "waitingForMorePassengers": true,
    "lastPassenger": false
}


Book Passenger#3
 {
"name":"Alex",
"gender": 0 
}

sample respose :
{
    "status": "Success",
    "fellow_travellers": ["Rahul", "Ravi"],
    "registrationNumber": "KA01 AB 1233",
    "waitingForMorePassengers": true,
    "lastPassenger": false
}

Book Passenger#4
 {
"name":"Maria",
"gender": 1
}

sample respose :
{
    "status": "Success",
    "fellow_travellers": ["Rahul", "Ravi" , "Alex"],
    "registrationNumber": "KA01 AB 1233",
    "waitingForMorePassengers": false,
    "lastPassenger": true
}

waitingForMorePassengers is false now , cab will move.

Now on a new cab will be alloted from availability pool.



*******************************************************************
Endpoint : "/register/cab",
input : {
"registrationNumber":"KA01 AB 1236"
}


sample output 
{
    "registrationNumber": "KA01 AB 1236",
    "status": "Cab registered with aggregated successfully "
}


*******************************************************************

Endpoint : "/register/availability"
input : {
"registrationNumber":"KA01 AB 1236"
}

/*Only registerd cabs can register availability*/

sample output 
{
    "registrationNumber": "KA01 AB 1236",
    "status": "Availability registered Successfully "
}


********************************************************************




