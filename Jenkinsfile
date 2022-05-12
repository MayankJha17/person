pipeline {
    agent any
    /*environment{

       PATH = "/usr/local/maven3/bin:$PATH" 
    } */
    tools{
        maven 'maven3'
    }
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '1')
    }
    stages {
        stage('Pull') {
            steps {
                echo 'Cloning the project from git into jenkins workspace'
                git branch: 'main', credentialsId: 'MayankJha17', url: 'git@github.com:MayankJha17/person.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the project through maven'
                sh 'mvn clean install -Dmaven.test.skip=true'
            } 
        }    
        stage('Test') {
            steps {
                echo 'Testing the project'
                sh 'mvn test'             
            } 
        } 
        stage("SSH"){
           agent {
             node {
                 def remote = [:]
                 remote.name = 'nacon'
                 remote.host = '192.168.29.132'
                 remote.user = 'nacon'
                 remote.password = 'nacon'
                 remote.allowAnyHosts = true
                 stage('Remote SSH') {
                 sshCommand remote: remote, command: "ls -l"
                 }
             }
           }
        } 
    }
    post("Post build actions"){
        always{
            echo 'Publishing test reports'
            junit skipPublishingChecks: true, testResults: '**/personDetail/target/surefire-reports/TEST-*.xml'        }
        success{
            echo 'Pipeline is sucessfully executed'
        }
        failure{
            echo 'Pipeline is not sucessfully executed'
        }
    }
}
