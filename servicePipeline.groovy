
def call(){

            stage('Build') {
                steps {
                    sh 'chmod +x ./gradlew'
                    // Run Gradle build
                    sh './gradlew build'
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

return this