pipelineJob('SPRING Application Builder') {
    logRotator {
        numToKeep(3)
    }
    triggers {
        scm('H/2 * * * *')
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
pipelineJob('Load Test') {
    logRotator {
        numToKeep(3)
    }
    properties {
        githubProjectUrl('https://github.com/PioPaEY/SimplePerfTest/')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/PioPaEY/SimplePerfTest.git')
                    }
                    branch('*/main')
                }
            }
            lightweight()
        }
    }
}