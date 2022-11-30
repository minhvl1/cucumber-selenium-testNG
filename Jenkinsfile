pipeline {
    agent {
        docker {
            image 'maven:3-openjdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
         stage ('Clone') {
            steps {
                git branch: 'jenkins', url: "https://github.com/minhvl1/cucumber-selenium-testNG.git"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
          
  
        }
    }
}
