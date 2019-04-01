pipeline {

    agent any

    stages {

        stage('Checkout') {

            steps {

                checkout([$class: 'GitSCM', branches: [[name: 'refs/tags/testing']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'BYMIKT_GITHUB', url: 'https://github.com/habimog/pipeline.git']]])  

            }

        }

        stage('Deploy Test') {

            steps {

                echo 'Deploying to Test ...'

                deleteDir()

            }

        }

    }

}
