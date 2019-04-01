pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master'], [name: '*/develop'], [name: '**/tags/**']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'LocalBranch']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cbc48a47-d39d-4f27-8f34-b32d09985fc2', refspec: '+refs/tags/*:refs/remotes/origin/tags/*', url: 'https://github.com/habimog/pipeline.git']]])
                //checkout([$class: 'GitSCM', branches: [[name: 'refs/tags/testing']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'LocalBranch']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'BYMIKT_GITHUB', url: 'https://github.com/habimog/pipeline.git']]])  
            }
        }
        stage('Master') {
            when {
                expression {
                    GIT_MASTER_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    echo GIT_MASTER_BRANCH
                    return GIT_MASTER_BRANCH == 'heads/master'
                }
            }
            steps {
                echo 'Deploying Master ...'
                
            }
        }
        stage('Deploy Dev') {
            when {
                expression {
                    GIT_DEVELOP_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    echo GIT_DEVELOP_BRANCH
                    return GIT_DEVELOP_BRANCH == 'heads/develop'
                }
            }
            steps {
                echo 'Deploying to Dev ...'
                
            }
        }
        stage('Deploy Test') {
            when {
                expression {
                    GIT_TESTING_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    echo GIT_TESTING_BRANCH
                    return GIT_TESTING_BRANCH == 'heads/tags/testing'
                }
            }
            steps {
                echo 'Deploying to Test ...'
            }
        }
        stage('Deploy Prod') {
            when {
                expression {
                    GIT_PRODUCTION_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    echo GIT_PRODUCTION_BRANCH
                    return GIT_PRODUCTION_BRANCH == 'heads/tags/production'
                }
            }
            steps {
                echo 'Deploying to Prod ...'
            }
	}
    }
}
