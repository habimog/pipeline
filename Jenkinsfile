pipeline {
    agent any
    stages {
        stage('Deploy to Dev') {
            steps {
                echo 'Deploying to Dev ...'
            }
        }
        stage('Deploy Test') {
            when { tag "test-*" }
            steps {
                echo 'Deploying to Test ...'
            }
        }
       stage('Deploy Prod') {
           when { tag "prod-*" }
            steps {
                echo 'Deploying to Prod ...'
            }
        }
    }
}
