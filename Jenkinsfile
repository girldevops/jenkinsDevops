pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                git credentialsId: '3b03b4d0-fcde-4df0-8b0b-5d58d10649c9', url: 'https://github.com/girldevops/ansible.git'
            }
        }
    }
   
}

