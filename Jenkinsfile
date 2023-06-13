pipeline {
    agent any

    tools {
        maven "Maven 3.9.2"
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                // Build Docker Image
                    dockerImage = docker.build('JenkinsMvc:latest')
                }
            }
        }
    }
}
