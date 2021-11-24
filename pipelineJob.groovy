pipeline {
    agent {
        label 'testslave'
    }
    stages {

        stage('SCM') {
            steps {
                checkout scm
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