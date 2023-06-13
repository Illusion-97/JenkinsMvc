pipeline {
    agent { docker { image 'eclipse-temurin:17-jdk-jammy' } }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                //git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Build Docker') {
            steps {
                docker.build("JenkinsMvc:${env.BUILD_NUMBER}")
            }
        }
        stage('Deploy Docker') {
            steps{
                sh "docker stop JenkinsMvc || true && docker rm JenkinsMvc || true"
                sh "docker run --name JenkinsMvc -d -p 8075:8080 JenkinsMvc:${env.BUILD_NUMBER}"
            }
        }
    }
}
