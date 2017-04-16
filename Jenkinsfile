node {
    deleteDir() //clean up the local workspace

    properties ([
        buildDiscarder(logRotator(numTokeepStr: '5')),
        disableConcurrentBuilds()
    ])

    def isPr = env.BRANCH_NAME.startsWith("PR-")

    stage("Configure") {
        notifyStart()
        checkout scm
    }

    stage("Clean Up") {
        deleteDir()
    }
}

def notifyStart() {
    slackSend (color: '#FFFF00', message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
}

def notifyComplete() {
    slackSend (color: '#00FF00', message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
}

def notifyFailed() {
    slackSend (color: '#FF0000', message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
}