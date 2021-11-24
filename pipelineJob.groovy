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
                sh 'cd complete && mvn spring-boot:run'
            }
        }
        stage('Test'){
            steps {
                echo 'Test'
            }
        }
    }
}