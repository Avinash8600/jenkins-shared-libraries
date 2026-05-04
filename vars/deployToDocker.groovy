def call()
{
  echo "This is deploying the code"

  sh """
                docker stop todo-app-container || true
                docker rm todo-app-container || true
                docker run -d -p 80:80 --name todo-app-container avindock/cloud-native-todo-app-cicd:latest
                """
                echo "App is live 🚀"
}
