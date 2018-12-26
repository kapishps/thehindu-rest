##REST API's for The Hindu Archives

### Tech Stack
* Java
* Spring Boot
* Maven
* MongoDB (db credentials currently present in src code)

### Instructions
```sh
git clone https://github.com/kapishps/thehindu-rest.git
cd thehindu-rest
mvn spring-boot:run
```

### APIs
- Search available authors :- GET http://localhost:8080/getallauthors
- Search articles based on input author name :- GET http://localhost:8080/getarticlesbyauthor/{author}
- Search articles based on input article title and description :- GET http://localhost:8080/getarticlesbytitle/{title}
- Search articles based on date :- GET http://localhost:8080/getarticlesbydate/{date}
- Search author name based on date :- GET http://localhost:8080/getauthorsbydate/{date}
- Search articles based on tags associated with articles :- POST http://localhost:8080/getarticlesbytags
- Search articles based on city name :- GET http://localhost:8080/getarticlesbycity/{city}
- Search articles based on news categories:- POST http://localhost:8080/getarticlesbycategories

Both the POST requests accept a List of Strings





