pipeline {
    agent { docker { image 'java-docker:latest' } }

    tools {
        maven "Maven 3.9.2"
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build('JenkinsMvc:latest')
                }
            }
        }
    }
}
