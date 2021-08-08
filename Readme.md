## Requirements
- Java 13
- Gradle
- Lombok
- Serenity BDD

## Usage
```
gradle clean test
```

-Dtags='ui:login' - to run only UI tests  
-Dtags='api:users' - to run only API tests  
-Dchrome.switches=--headless - to run with headless browser

## Reports
After execution reports should be available from 

```
target/site/serenity/index.html
```

## Gitlab integration

```
.gitlab-ci.yml
```
## Test cases
Login and Users test cases were selected for automation because this is usually the most critical area of the product.  
Other cases can be foundd by [LINK](https://docs.google.com/spreadsheets/d/1w1YKJ3aP0s-7jvSDiK12pQ_2Q7ManjOvhIAKsnLXF-A/edit?usp=sharing)

