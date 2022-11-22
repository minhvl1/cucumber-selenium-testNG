# cucumber-selenium-testNG
- Cucumber + POM pattern
- Allure report, cucumber report, extent report
![image](https://user-images.githubusercontent.com/67543695/203227269-e3e38b0a-b72a-4961-8a10-f6da7de9ff24.png)
![image](https://user-images.githubusercontent.com/67543695/203227298-16684251-c790-4736-b1d2-9eb299d2e937.png)

- Send mail after run test
- Screenshot on failure
![extent](https://user-images.githubusercontent.com/67543695/203220726-30195183-c23d-4e09-a739-6bd5d40dc89c.png)
![cucumber](https://user-images.githubusercontent.com/67543695/203220841-2ef7cc50-8d5b-468e-ade3-1eb3590cb9ff.png)



## Run Test

- default run: all features, config in POM.xml file

`mvn clean verify`

- Run by profiles, 2 profiles config in POM
  + run-all-features
  ![image](https://user-images.githubusercontent.com/67543695/203220991-c0f895b7-1fdb-4ba0-bd2e-241feae93055.png)

  + run-each-features
  ![image](https://user-images.githubusercontent.com/67543695/203220935-27d5cb6b-c50c-4620-b19b-db67062a032f.png)

  
`mvn clean install -P run-each-features`

`mvn clean install -P run-all-features`
