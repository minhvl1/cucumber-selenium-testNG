# cucumber-selenium-testNG
- Cucumber + POM pattern
- Allure report, cucumber report, extent report
- Send mail after run test


## Run Test

- default run: all features, config in POM.xml file

`mvn clean verify`

- Run by profiles, 2 profiles config in POM
  + run-all-features
  + run-each-features
  
`mvn clean install -P run-each-features`

`mvn clean install -P run-all-features`