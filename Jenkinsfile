pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Git clone') {
            steps {
                git 'https://github.com/parthik21/mini_calculator.git'
            }
        }
        stage('Maven Compile and test') {
            steps {
                sh 'mvn clean compile test'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    image = docker.build "parthikdocker/mini-project"
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry( '', 'Docker-Credentials') {
                        image.push('latest')
                    }
                }
            }
        }
    }
}