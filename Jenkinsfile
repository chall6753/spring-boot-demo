 pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    // Checkout the code from the repository
                    git url: 'https://github.com/chall6753/spring-boot-demo', branch: 'main'
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

          post{
          success {
                                         echo 'Pipeline completed successfully!'
                                     }
                                     failure {
                                         echo 'Pipeline failed!'
                                     }
          }

    }

}


