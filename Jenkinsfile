pipeline {
    agent any
stages {
        stage('git repo & clean') {
            steps {
               // bat "rmdir  /s /q SeleniumEasyDemoJenkins"
               bat "rmdir  /s /q SeleniumEasyDemoJenkins"
                bat "git clone https://github.com/Revatiyele/SeleniumEasyDemoJenkins.git"
                bat "mvn clean -f SeleniumEasyDemoJenkins"
            }
        }
       stage('install') {
           steps {
                bat "mvn install -f SeleniumEasyDemoJenkins"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f SeleniumEasyDemoJenkins" 
            }
        }
         stage('package') {
             steps {
                 bat "mvn package -f SeleniumEasyDemoJenkins"
             }
       }
    }
}
