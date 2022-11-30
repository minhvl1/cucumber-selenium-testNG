pipeline {
    agent {
        any {
            image 'maven:3-openjdk-8'
            args '-v /root/.m2:/root/.m2'
             maven 'MAVEN_HOME' 
    }
    }
    stages {
      
        stage('Build') {
            steps {
                sh 'echo $MAVEN_HOME' 
                sh 'echo $JAVA_HOME' 
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
