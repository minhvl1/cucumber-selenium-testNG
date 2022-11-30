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
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
          
  
        }
    }
    post{
        success{
            office365ConnectorSend message:"pass in jenkins",
                status:"SUCESS"
        }
        failure{
            office365ConnectorSend message:"build failed in Jenkins",
                status:"FAILED"
        }
    }
}
