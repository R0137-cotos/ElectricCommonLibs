pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        script {
          echo ">> PullRequestの情報を表示します。"
          echo "PR作成者： ${env.CHANGE_AUTHOR}"
          echo "Forkリポジトリ： ${env.CHANGE_FORK}"
          echo "PRブランチ： ${env.CHANGE_BRANCH}"
          echo "ターゲットブランチ： ${env.CHANGE_TARGET}" 
          sh "gradle clean"
          def targetBranch = "${env.CHANGE_TARGET}"
          if ("${targetBranch}" == 'master') {
            echo "targetBranchがmaster"
            sh "export SPRING_PROFILES_ACTIVE=ci"
          } else {
            echo "targetBranchがmaster以外"
            sh "export SPRING_PROFILES_ACTIVE=ci"
          }
          sh "gradle -Dtest.maxHeapSize=8G test"
          junit "build/test-results/test/*.xml"
          archiveArtifacts "build/test-results/test/*.xml"
        }
      }
    }
  }
}
