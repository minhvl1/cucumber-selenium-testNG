# cucumber-selenium-testNG
- Cucumber + POM pattern
- Allure report, cucumber report, extent report
![image](https://user-images.githubusercontent.com/67543695/203460077-3160568b-8d47-47c4-a375-264188da2dd5.png)

![image](https://user-images.githubusercontent.com/67543695/203227269-e3e38b0a-b72a-4961-8a10-f6da7de9ff24.png)

![image](https://user-images.githubusercontent.com/67543695/203227298-16684251-c790-4736-b1d2-9eb299d2e937.png)

- Send mail after run test
- API testing
![image](https://user-images.githubusercontent.com/67543695/203759144-b3e63180-a440-4d70-85d0-eb74074c2b46.png)

![image](https://user-images.githubusercontent.com/67543695/203759215-4fcbea70-f154-45d7-b620-46f6867a58ba.png)

- Screenshot on failure
![image](https://user-images.githubusercontent.com/67543695/203460455-d8cf11ee-054d-4a78-8dac-0cd9537fce47.png)

![extent](https://user-images.githubusercontent.com/67543695/203220726-30195183-c23d-4e09-a739-6bd5d40dc89c.png)

![cucumber](https://user-images.githubusercontent.com/67543695/203220841-2ef7cc50-8d5b-468e-ade3-1eb3590cb9ff.png)

- Public Allure report into github page with url: https://minhvl1.github.io/cucumber-selenium-testNG
![image](https://user-images.githubusercontent.com/67543695/203460253-58278ba7-1fc8-4afd-af66-8e690e8902d5.png)

![image](https://user-images.githubusercontent.com/67543695/203460322-01b0edaa-5e71-4c96-97ca-324074de5e4d.png)

- Enable/Disable send mail in 'src/main/java/constants/FrameworkConstants.java'

![image](https://user-images.githubusercontent.com/67543695/203460367-699a668c-4ad4-4e64-9455-a578158c3a25.png)

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
