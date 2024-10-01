pipeline {
    agent any

    environment {
        // Set GCP project ID and GCR region
        GCP_PROJECT = 'your-gcp-project-id'
        GCR_REGION = 'us'  // Set the appropriate region (e.g., 'us', 'eu', 'asia')
        IMAGE_NAME = 'spring-boot-demo'
        IMAGE_TAG = "gcr.io/${GCP_PROJECT}/${IMAGE_NAME}:${env.BUILD_ID}"
    }
    parameters {
            string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to checkout')
        }
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git url: 'https://github.com/chall6753/spring-boot-demo', branch: "${params.BRANCH_NAME}"
            }
        }

        stage('Load and Execute Script') {
            steps {
                script {
                    // Load the external Groovy script
                    def servicePipeline = load './servicePipeline.groovy'
                    servicePipeline()
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    sh "docker build -t ${IMAGE_TAG} ."
                }
            }
        }

//         stage('Authenticate with GCR') {
//             steps {
//                 withCredentials([file(credentialsId: 'gcr-json-key', variable: 'GCR_KEYFILE')]) {
//                     // Authenticate Docker to GCR using the service account key
//                     sh '''
//                         gcloud auth activate-service-account --key-file=${GCR_KEYFILE}
//                         gcloud auth configure-docker --quiet
//                     '''
//                 }
//             }
//         }
//
//         stage('Push Docker Image to GCR') {
//             steps {
//                 script {
//                     // Push the Docker image to Google Container Registry
//                     sh "docker push ${IMAGE_TAG}"
//                 }
//             }
//         }
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
