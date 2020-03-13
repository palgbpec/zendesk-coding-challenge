# Zendesk Coding Challenge


## Requirements
* Java 8
* Apache Maven 3.6.0 

## Usage 
```
$ git clone https://github.com/palgbpec/zendesk-coding-challenge.git
$ cd zendesk-coding-challenge
$ mvn package
$ java -jar target/zendesk-coding-challenge-1.0-SNAPSHOT.jar 

```
Alternatively, open the project in an IDE and run `Main.java`

## Data

By default the application uses the files present in the `resources` folder as input files.
```
$ ls src/main/resources/*.json
users.json tickets.json organizations.json
```


## External Libraries
* [Google Gson](https://github.com/google/gson)
* [Apache Commons](https://commons.apache.org/proper/commons-io/)
* [Junit4](https://junit.org/junit4/)






