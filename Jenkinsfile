pipeline {
    options {
        office365ConnectorWebhooks([
            [name: "Office 365", url: "https://cmcglobalcompany.webhook.office.com/webhookb2/d71b4385-2978-475a-849d-1f7fb4786638@f89c1178-4c5d-43b5-9f3b-d21c3bec61b5/IncomingWebhook/df5cace06cbe44b8a2db7619802ffe8b/0ef5503d-db25-40ca-bf9d-3c80b57ebfac"
             , notifyBackToNormal: true, notifyFailure: true, notifyRepeatedFailure: true, notifySuccess: true, notifyAborted: true
            ,message: 'Allure report [deployed](http://192.168.66.116:2111/job/cucumber/24/allure/)',status: 'Success']
        ])
    }
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
}
