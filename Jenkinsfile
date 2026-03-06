pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('dockerhub-credentials-id')
        IMAGE_NAME = 'nikxdomain/scientific-calculator'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                //sh 'exit 4'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "echo \$DOCKER_HUB_CREDENTIALS_PSW | docker login -u \$DOCKER_HUB_CREDENTIALS_USR --password-stdin"
                sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }

	post {
        	failure {
	            mail to: 'niks2veg@gmail.com',
                    subject: "Build Failed: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: "Check the console output at: ${env.BUILD_URL}"
	        }
        	success {
         	   mail to: 'niks2veg@gmail.com',
                	 subject: "Build Succeeded: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
	                 body: "The pipeline has completed successfully. View details here: ${env.BUILD_URL}"
        }
	 }
}
	
