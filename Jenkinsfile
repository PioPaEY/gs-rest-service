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
                sh 'cd gs-rest-service && mvn clean compile'
            }
        }
        stage('Unitary tests'){
            steps {
                echo 'Doing all necessary unit tests.'
                sh 'cd gs-rest-service && mvn test'
            }
        }
        stage('Quality check'){
            steps {
                echo 'Quality checks of built application.'
                sh 'cd gs-rest-service && mvn verify'
            }
        }
        stage('Package'){
            steps {
                echo 'Putting application into WAR file.'
                sh 'cd gs-rest-service && mvn clean package'
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
                echo 'Load test'
                build job: 'Load Test'
            }
        }
    }
}