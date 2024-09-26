
def call(){
    pipeline {
        agent any

        environment {
            // Set environment variables if needed
            GRADLE_USER_HOME = "${WORKSPACE}/.gradle" // Optional
        }

        stages {
            stage('Checkout') {
                steps {
                    // Checkout the code from the repository
                    git url: 'https://github.com/chall6753/spring-boot-demo', branch: 'main'
                }
            }

            stage('Build') {
                steps {
                    sh 'chmod +x ./gradlew'
                    // Run Gradle build
                    sh './gradlew build'
                }
            }

        }

        post {
            success {
                echo 'Pipeline completed successfully!'
            }
            failure {
                echo 'Pipeline failed!'
            }
        }
    }
}