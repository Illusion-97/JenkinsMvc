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
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
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
                        bat "docker stop jenkins-mvc"
                        bat "docker rm jenkins-mvc"
                    } catch (Exception e) {
                        echo '404 Not Found : jenkins-mvc'
                    }
                    bat "docker run --name jenkins-mvc -d -p 8075:8080 jenkins-mvc:latest JenkinsMvc.jar"
                }
            }
        }
    }
}
