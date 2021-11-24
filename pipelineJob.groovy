//pipeline {
//    agent {
//        label 'testslave'
//    }
//    stages {
//
//        stage('SCM') {
//            steps {
//                sh "git clone https://github.com/PioPaEY/gs-rest-service.git"
//            }
//        }
//
//        stage('Build') {
//            steps {
//                sh 'cd gs-rest-service/complete && mvn spring-boot:run'
//            }
//        }
//        stage('Test'){
//            steps {
//                echo 'Test'
//            }
//        }
//    }
//}
pipelineJob('job-dsl-plugin') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/PioPaEY/gs-rest-service.git')
                    }
                    branch('*/main')
                }
            }
            lightweight()
        }
    }
}