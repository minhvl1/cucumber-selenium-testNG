pipeline {
    agent {
        any {
            image 'maven:3-openjdk-8'
            args '-v /root/.m2:/root/.m2'
    }
                    tools { 
      maven 'MAVEN_HOME' 
      jdk 'JAVA_HOME' 
        }
    }
    stages {
      
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
