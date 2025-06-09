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
        script {
          // githubNotify context: 'gradle test', status: 'PENDING'
          echo "buildを実行します"
          echo ">> PullRequestの情報を表示します。"
          echo "PR作成者： ${env.CHANGE_AUTHOR}"
          echo "Forkリポジトリ： ${env.CHANGE_FORK}"
          echo "PRブランチ： ${env.CHANGE_BRANCH}"
          echo "ターゲットブランチ： ${env.CHANGE_TARGET}" 
          echo "環境変数： ${env.GRADLE_TEST_OPTION}" 
          try {
            sh "gradle clean"
            def targetBranch = "${env.CHANGE_TARGET}"
            if ("${targetBranch}" == 'master') {
              sh "export SPRING_PROFILES_ACTIVE=ci"
            } else {
              sh "export SPRING_PROFILES_ACTIVE=ci"
            }
            def gradleTestOption = "${env.GRADLE_TEST_OPTION}"
            sh "gradle ${gradleTestOption} test"
            junit "build/test-results/test/*.xml"
            archiveArtifacts "build/test-results/test/*.xml"
            // githubNotify context: 'gradle test', status: 'SUCCESS', description: 'Gradle tests passed!'
          } catch (e) {
            // githubNotify context: 'gradle test', status: 'FAILURE', description: 'Gradle tests failed.'
          }
        }
      }
    }
  }
}
