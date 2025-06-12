pipeline {
  agent any
  stages {
    stage("build") {
      when {
        expression {
          def isJobNameMatch = "${env.JOB_NAME}".contains("PullRequestBuild")
          def isTargetBranchMatch = "${env.CHANGE_TARGET}" == "verify/eosl"
          return isJobNameMatch && isTargetBranchMatch
        }
      }
      steps {
        // withCredentials([string(credentialsId: 'jenkins-github-likner', variable: 'GITHUB_TOKEN')]){
          script {
            def GITHUB_TOKEN="7bb109e2c08f82c0ba2f49f0dce3158baed759ee"
            echo "${GITHUB_TOKEN}"
            notifyStatus('pending', 'starting gradle test.', ${GITHUB_TOKEN})
            echo "buildを実行します"
            echo ">> PullRequestの情報を表示します。"
            echo "PR作成者： ${env.CHANGE_AUTHOR}"
            echo "Forkリポジトリ： ${env.CHANGE_FORK}"
            echo "PRブランチ： ${env.CHANGE_BRANCH}"
            echo "ターゲットブランチ： ${env.CHANGE_TARGET}" 
            try {
              sh "gradle clean"
              if ("${env.CHANGE_TARGET}" == 'master') {
                sh "export SPRING_PROFILES_ACTIVE=ci"
              } else {
                sh "export SPRING_PROFILES_ACTIVE=ci"
              }
              def gradleTestOption = "${env.GRADLE_TEST_OPTION}"
              sh "gradle ${gradleTestOption} test"
              junit "build/test-results/test/*.xml"
              archiveArtifacts "build/test-results/test/*.xml"
              notifyStatus('success', 'All tests passed.', ${GITHUB_TOKEN})
            } catch (e) {
              notifyStatus('failure', 'Some tests failed.', ${GITHUB_TOKEN})
            }
          }
        // }
      }
    }
  }
}
def notifyStatus(state, description, token) {
  echo "notifyStatusを実行します"
  // Jsonペイロード
  def payload = groovy.json.JsonOutput.toJson([
    state: ${state},
    context: 'gradle test',
    description: ${description},
    target_url: ${env.BUILD_URL},
  ])
  echo "${payload}"
  def revision = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
  echo "${revision}"
  // curl で POST
  sh '''
    curl -s -X POST https://api.github.com/repos/cotos/ElectricCommonLibs/statuses/${revision} \\
      -H "Authorization: token ${env.GITHUB_TOKEN}" \\
      -H "Content-Type: application/json" \\
      -H '${payload}'
  '''
}
