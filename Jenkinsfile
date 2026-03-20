pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'jdk-21'
    }

    environment {
        PATH = "/usr/local/bin:${env.PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        // Updated to your new repo from the screenshot
        DOCKERHUB_REPO = 'saileshk1103/localization_calculator_app'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pointing to your current calculator repository
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // This generates the CalculatorApp.jar and runs tests
                sh 'mvn clean package'
            }
        }

        stage('Reports') {
            steps {
                // Generate Jacoco report
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    jacoco()
                }
            }
        }

        stage('Build and Push Multi-Arch Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        // Login to Docker Hub
                        sh "docker login -u ${USER} -p ${PASS}"

                        // Build for both Intel (amd64) and Apple/Raspberry Pi (arm64)
                        // This uses the Dockerfile you created earlier
                        sh "docker buildx build --platform linux/amd64,linux/arm64 -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} . --push"
                    }
                }
            }
        }
    }
}