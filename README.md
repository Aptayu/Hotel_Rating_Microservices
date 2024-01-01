# Hotel_Rating_Microservices
This project fetches the hotel ratings for a user using microservices based architecture
OpenBoard

Db: User/Hotel Service: SQL
Rating: Mongo

actuator health
<!-- http://localhost:8081/actuator/health -->
get user
<!-- localhost:8081/users/16019b5b-dbb3-4828-bf1c-f2ba6092aec8 -->

get rating for user
<!-- http://localhost:8083/ratings/users/16019b5b-dbb3-4828-bf1c-f2ba6092aec8 -->

get hotel
<!-- localhost:8082/hotels/1494dfd8-aeeb-4c49-94b4-88f28901351f -->