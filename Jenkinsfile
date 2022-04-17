pipeline {
    environment {
        imagename = "parthikdocker/mini-project"
        image = ''
    }

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
                    image = docker.build imagename
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
        stage('Remove Garbage docker image') {
          steps {
             sh "docker rmi $imagename:latest"
          }
        }
        stage('Ansible depoly to diff machine') {
            steps {
                ansiblePlaybook colorized: true, installation: 'Ansible', inventory: 'inventory', playbook: 'Playbook.yml'
            }
        }
    }
}