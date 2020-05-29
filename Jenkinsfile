pipeline{
    agent { label 'Dockerhost' }
    environment {
              wastemanagementbackend = ''
              registry = "tapskillassure/wastemanagementbackend"
              registryCredential = 'tapdockerhub'
       }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'gitlab', url: 'https://gitlab.Pratian.com/projects.skillassure/Waste-Management-backend.git']]])
            }
		}
		
		stage ( 'Build'){
			steps {
			 sh label: '', script: 'mvn clean package'
			 }
			}			
		stage( 'Build Docker image'){
			steps {
			 script {
              wastemanagementbackend = docker.build registry + ":$BUILD_NUMBER"
               }
			}
        }
		stage('Push Images to Docker Hub') {
          steps{
				script {
					docker.withRegistry( '', registryCredential ) {
						wastemanagementbackend.push()
                       }
                 }
               }
           }
         stage('Remove Unused docker image') {
           steps{
               sh "docker rmi $registry:$BUILD_NUMBER"
                }
          }
    }
}
