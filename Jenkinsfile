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
        }
      }
    }
  }
}
