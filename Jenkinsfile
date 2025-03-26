pipeline {
    agent any  // Runs on any available agent

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-21" // Set Java path (modify as needed)
        MAVEN_HOME = "C:\\Users\\sathy\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9"  // Set Maven path
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Sathya8995/Testpractise'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh '${MAVEN_HOME}/bin/mvn clean package'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh '${MAVEN_HOME}/bin/mvn test'
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Deploy') {
            when {
                branch 'main' // Deploy only if the branch is 'main'
            }
            steps {
                echo "Deploying application..."
                // Add deployment script here (e.g., copy to Tomcat, Docker, etc.)
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}
