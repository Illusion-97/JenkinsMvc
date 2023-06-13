pipeline {
    agent any

    tools {
        maven "Maven 3.9.2"
    }

    stages {
        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                // Build Docker Image
                    dockerImage = docker.build('jenkins-mvc:latest')
                }
            }
        }
        stage('Deploy Docker Image') {
            steps {
                script {
                    try {
                        bat "docker stop jenkins-mvc:latest"
                        bat "docker rm jenkins-mvc:latest"
                    } catch (Exception e) {
                        echo '404 Not Found : jenkins-mvc:latest'
                    }
                    bat "docker run --name jenkins-mvc -d -p 8075:8080 jenkins-mvc:${env.BUILD_NUMBER}"
                }
            }
        }
    }
}
