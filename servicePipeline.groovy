
def call(){


                    sh 'chmod +x ./gradlew'
                    // Run Gradle build
                    sh './gradlew build'

    }

def tagging(){
    return {
        stages {
            stage('Authenticate with GCR') {
                steps {
                    withCredentials([file(credentialsId: 'gcr-json-key', variable: 'GCR_KEYFILE')]) {
                        sh '''
                        gcloud auth activate-service-account --key-file=${GCR_KEYFILE}
                        gcloud auth configure-docker --quiet
                    '''
                    }
                }
            }

            stage('Manage Image Tags in GCR') {
                steps {
                    script {
                        if (params.ACTION == 'ADD') {
                            // Add a new tag to the image
                            sh """
                            gcloud container images add-tag ${GCR_IMAGE}@${params.IMAGE_DIGEST} ${GCR_IMAGE}:${params.NEW_TAG} --quiet
                        """
                            echo "Tag ${params.NEW_TAG} added to image with digest ${params.IMAGE_DIGEST}"
                        } else if (params.ACTION == 'REMOVE') {
                            // Remove a tag from the image
                            sh """
                            gcloud container images untag ${GCR_IMAGE}:${params.NEW_TAG} --quiet
                        """
                            echo "Tag ${params.NEW_TAG} removed from image."
                        }
                    }
                }
            }
            stage('Update bitbucket tags') {
                steps {
                    script {
                        if (params.ACTION == 'ADD') {
                            sh '''
                            git tag ${params.NEW_TAG}
                            git push origin ${params.NEW_TAG}
                        '''
                            echo "Tag ${params.NEW_TAG} added and pushed to Bitbucket."
                        } else if (params.ACTION == 'REMOVE') {
                            sh '''
                            git tag -d ${params.NEW_TAG}
                            git push origin :refs/tags/${params.NEW_TAG}
                        '''
                            echo "Tag ${params.NEW_TAG} removed from Bitbucket."
                        }
                    }
                }

            }
        }
    }
}

return this