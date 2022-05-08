pipeline {
    environment {
        imagename = "parthikdocker/mini-project"
        registryCredential = "parthikdocker-dockerhub"
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
                    docker.withRegistry( '', registryCredential) {
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
            steps{
                  ansiblePlaybook(
                  	credentialsId: "container_access_key",
                    inventory: "inventory",
                    installation: "ansible",
                    limit: "",
                    playbook: "Playbook.yml",
                    extras: ""
                  )
            }
        }
    }
}

