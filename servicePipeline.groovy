
def call(){




                    sh 'chmod +x ./gradlew'
                    // Run Gradle build
                    sh './gradlew build'





    }


return this