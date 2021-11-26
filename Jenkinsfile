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
                echo 'Performing build of application. Compiling stuff and etc...'
                sh 'cd gs-rest-service/complete && mvn clean compile'
            }
        }
        stage('Unitary tests'){
            steps {
                echo 'Doing all necessary unit tests.'
                sh 'cd gs-rest-service/complete && mvn test'
            }
        }
        stage('Quality check'){
            steps {
                echo 'Quality checks of built application.'
                sh 'cd gs-rest-service/complete && mvn verify'
            }
        }
        stage('Package'){
            steps {
                echo 'Putting application into WAR file.'
                sh 'cd gs-rest-service/complete && mvn package'
            }
        }
        stage('Deploy'){
            steps {
                echo 'Deploy Application to TOMCAT folder'
                sh 'cp gs-rest-service/complete/target/*.war /deploy'
            }
        }
        stage('Run Tests'){
            parallel {
                   stage('Integration tests') {
                       steps {
                           echo 'Some Integration tests happening here.'
                       }
                   }
                   stage('Functional tests'){
                       steps {
                           echo 'Some Functional tests happening here.'
                       }
                   }

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