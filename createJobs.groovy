//pipelineJob('pipelineJob') {
//    definition {
//        cps {
//            script(readFileFromWorkspace('pipelineJob.groovy'))
//            sandbox()
//        }
//    }
//}
pipelineJob('SPRING Application Builder') {
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
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}