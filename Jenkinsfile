pipeline {
    agent any
    environment {
        GIT_TAG = sh(returnStdout: true, script: 'git describe --always').trim()
    }
    parameters {
        choice(choices: 'test\ndev\nproduction', description: 'Which environment?', name: 'ENVIRONMENT')
    }
    stages {
        stage("Checkout") {
            steps {
                checkout scm
            }
        }
        stage("Deploy Test") {
	    when {
		buildingTag()
	    }
	    environment {
		ENVIRONMENT = 'test'
	    }
            steps {
                echo 'Deploying to Test ...'
	    }
        }
	stage("Deploy to Dev") {
	    when {
		buildingTag()
	    }
	    environment {
		ENVIRONMENT = 'dev'
	    }
	    steps {
                echo 'Deploying to Dev ...'
	    }
	}
	stage("Deploy to Production") {
	    when {
	        buildingTag()
            }
            environment {
	        ENVIRONMENT = 'production'
            }
            steps {
                echo 'Deploying to Production ...'
	    }
        }
    }
}
