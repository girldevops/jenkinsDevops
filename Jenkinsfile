pipeline {
    agent any
    environment { 
        VAR = 'pipeline'
    }
    stages {
        stage('1') {
            environment { 
                VARR = 'stage1'
            }
            steps {
                echo 'Hello 1'
                echo "PIPELINE VAR: ${VAR}"
                echo "STAGE VAR : ${VARR}"
            }
        }
        stage('2') {
            steps {
                echo 'Hello 2'
            }
        }
    }
    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}
