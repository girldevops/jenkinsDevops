pipeline {
    agent any
    stages {
       
        stage('Parallel Stage') {
           
            failFast true
            parallel {
                stage('Branch A') {
                   
                    steps {
                        echo "On Branch A"
                    }
                }
                stage('Branch B') {
                    
                    steps {
                        echo "On Branch B"
                    }
                }
                stage('Branch C') {
                            steps {
                                echo "In stage Nested 2 within Branch C"
                            }
                        
                    }
                }
            }
      
        }
    }

