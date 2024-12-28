pipeline{
  agent any
  tools{
    maven 'sonarmaven'
  }
  environment{
    SONAR_TOKEN=credentials('sonarQub-token')
  }
  stages{
    stage('checkout'){
      steps{
        checkout scm
      }
    }

    stage('build'){
      step{
        bat 'mnv clean package'
      }
    }

    stage('sonarQube Analysis'){
      steps{
        withSonarQubeEnv('sonarqube-server'){
          bat '''
          mvn clean verify sonar:sonar \
          -Dsonar.projectKey=Maven-2 \
          -Dsonar.projectName=Maven-2 \
          -Dsonar.sources=src/test/resources \
          -Dsonar.host.url=http://localhost:9000 \
          -Dsonar.token=%SONAR_TOKEN%
          '''
        }
      }
    }
  }

  post{
    success{
      echo "All GOOD"
    }
    failure{
      echo "Someting went wrong"
    }
  }
}
