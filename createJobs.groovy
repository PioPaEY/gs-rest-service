//pipelineJob('pipelineJob') {
//    definition {
//        cps {
//            script(readFileFromWorkspace('pipelineJob.groovy'))
//            sandbox()
//        }
//    }
//}
pipelineJob('SPRING Application Builder') {
    logRotator {
        numToKeep(3)
    }
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