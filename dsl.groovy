pipelineJob("testing-tagging") {
	description()
	keepDependencies(false)
	definition {
		cpsScm {
"""pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([\$class: 'GitSCM', branches: [[name: '*/develop'], [name: 'refs/tags/production']], doGenerateSubmoduleConfigurations: false, extensions: [[\$class: 'LocalBranch']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cbc48a47-d39d-4f27-8f34-b32d09985fc2', refspec: '+refs/tags/*:refs/remotes/origin/tags/*', url: 'https://github.com/habimog/pipeline.git/']]])
            }
        }
        stage('Deploy to Dev') {
            when {
                expression {
                    GIT_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    echo GIT_BRANCH
                    return GIT_BRANCH == 'heads/production'
                }
            }
            steps {
                echo 'Deploying to Dev ...'
            }
        }
        stage('Deploy Test') {
            when {
                expression {
                    GIT_TAG = sh(returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
                    echo GIT_TAG
                    return GIT_TAG == 'production'
                }
            }
            steps {
                echo 'Deploying to test only because this commit is tagged with testing...'
            }
        }
    }
}"""		}
	}
	disabled(false)
	configure {
		it / 'properties' / 'com.coravy.hudson.plugins.github.GithubProjectProperty' {
			'projectUrl'('https://github.com/habimog/pipeline.git/')
			displayName()
		}
	}
}
