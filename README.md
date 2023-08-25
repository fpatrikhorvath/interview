<h1>Instructions</h1>

It was one of my previous interview task, I kept it, because I think it's a really good example for a basic test automation framework.

You can run it with the following command (Copy & paste it into the CLI)
```
 mvn test -D"cucumber.filter.tags=@smoke" -Dheadless="false" -DdefaultWaitSec="10"
```
Implemented technologies:
```
Java 8
Maven
Gherkin/Cucumber
Rest Assured
Selenium Chrome and Webdriver
Junit4
```

Please note that
```
It was implemented in Chromedriver v. 116, 
you may need to update the version of it.
```