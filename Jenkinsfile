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
                // Run Gradle build
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                // Run Gradle tests
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (this could vary based on your setup)
                echo 'Deploying the application...'
                // Add deployment steps here
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
