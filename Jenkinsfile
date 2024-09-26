 pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    // Checkout the code from the repository
                    git url: 'https://github.com/chall6753/spring-boot-demo', branch: 'main'
                }
            }
    }

node(){
    def servicePipeline = load './servicePipeline.groovy'
    servicePipeline()
}

