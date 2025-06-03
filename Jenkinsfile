pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        script {
          def url = scm.getUserRemoteConfigs()[0].getUrl()
          echo "Git repository URL: ${url}"
          sh "git branch --contains"
          sh "gradle clean"
          sh "export SPRING_PROFILES_ACTIVE=ci"
          sh "gradle -Dtest.maxHeapSize=8G test"
          junit "build/test-results/test/*.xml"
          archiveArtifacts "build/test-results/test/*.xml"
        }
      }
    }
  }
}
