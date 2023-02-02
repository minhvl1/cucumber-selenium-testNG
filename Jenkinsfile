pipeline {

    agent {
        any {
            image 'maven:3-openjdk-8'
            args '-v /root/.m2:/root/.m2'
            maven 'MAVEN_HOME' 
    }
    }
    stages {
        stage('get_commit_msg') {
              steps {
                  script {
                      env.GIT_COMMIT_MSG = sh (script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
                  }
              }
          }

        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

         stage('Test') {
                     steps {
                            script {
                                try {
                                      sh 'mvn clean verify -DBROWSER=hfirefox'
                                } catch (err) {
                                    echo err.getMessage()
                                }
                            }
                            echo currentBuild.result
                        }
                }
         stage('Generate Report'){
                    steps {
                        archive (includes: 'pkg/*.gem')
                        publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: false,
                        reportDir: '/var/jenkins_home/workspace/test/extentReport/reports/',
                        reportFiles: 'extent-report.html',
                        reportName: 'Extend Report',
                        reportTitles: '',
                        useWrapperFileDirectly: true])
                    }
                }

         stage('MS team'){
                    steps {
                        office365ConnectorSend webhookUrl: 'https://cmcglobalcompany.webhook.office.com/webhookb2/d71b4385-2978-475a-849d-1f7fb4786638@f89c1178-4c5d-43b5-9f3b-d21c3bec61b5/IncomingWebhook/df5cace06cbe44b8a2db7619802ffe8b/0ef5503d-db25-40ca-bf9d-3c80b57ebfac',
                        message: 'See allure Report here [Allure](https://minhvl1.github.io/cucumber-selenium-testNG)',
                        status: 'Success',
                        color: "${currentBuild.currentResult} == 'SUCCESS' ? '#18d6a3' : '#ff9900'",
                        factDefinitions:[
                                [ name: "Extend report", template: "[Report](http://192.168.66.116:2111/job/test/Extend_20Report/)"],
                                [ name: "Commit Message", template: "${GIT_COMMIT_MSG}"],
                                [ name: "Pipeline Duration", template: "Maven Cucumber TestNG #${currentBuild.number}"]
                            ]
                    }
                }
    }

}
