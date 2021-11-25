pipeline {
    agent {
        label 'testslave'
    }
    stages {

        stage('SCM') {
            steps {
                sh "git clone https://github.com/PioPaEY/gs-rest-service.git"
            }
        }

        stage('Build') {
            steps {
                sh 'cd gs-rest-service/complete && mvn clean compile'

            }
        }
        stage('Unitary tests'){
            steps {
                echo 'mvn test'
            }
        }
        stage('Quality check'){
            steps {
                echo 'Placeholder for Quality check'
                sh 'mvn verify'
            }
        }
         stage('Package'){
                    steps {
                        echo 'Placeholder for Package'
                        sh 'mvn package'
                    }
                }
          stage('Deploy'){
                     steps {
                         echo 'Placeholder for Deploy'
                         sh 'cd target && nohup java -jar rest-service-complete-0.0.1-SNAPSHOT.jar &'
                     }
                 }
                  stage('Integration tests'){
                             steps {
                                 echo 'Placeholder for Integration tests'
                             }
                         }
                            stage('Functional tests'){
                                                      steps {
                                                          echo 'Placeholder for Functional tests'
                                                      }
                                                  }
                                                     stage('Load tests'){
                                                                               steps {
                                                                                   echo 'Placeholder for Load tests'
                                                                               }
                                                                           }
    }
}


// pipeline {
// 	agent none
//
// 	triggers {
// 		pollSCM 'H/10 * * * *'
// 	}
//
// 	options {
// 		disableConcurrentBuilds()
// 		buildDiscarder(logRotator(numToKeepStr: '14'))
// 	}
//
// 	stages {
// 		stage("test: baseline (jdk11)") {
// 			agent {
// 				label 'testslave'
// 			}
// 			options { timeout(time: 30, unit: 'MINUTES') }
// 			steps {
// 				sh 'test/run.sh'
// 			}
// 		}
//
// 	}
//
// 	post {
// 		changed {
// 			script {
// 				slackSend(
// 						color: (currentBuild.currentResult == 'SUCCESS') ? 'good' : 'danger',
// 						channel: '#sagan-content',
// 						message: "${currentBuild.fullDisplayName} - `${currentBuild.currentResult}`\n${env.BUILD_URL}")
// 				emailext(
// 						subject: "[${currentBuild.fullDisplayName}] ${currentBuild.currentResult}",
// 						mimeType: 'text/html',
// 						recipientProviders: [[$class: 'CulpritsRecipientProvider'], [$class: 'RequesterRecipientProvider']],
// 						body: "<a href=\"${env.BUILD_URL}\">${currentBuild.fullDisplayName} is reported as ${currentBuild.currentResult}</a>")
// 			}
// 		}
// 	}
// }