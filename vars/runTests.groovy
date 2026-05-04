def call()
{
  echo "Running basic tests..."

  sh '''
        # Check required files
        test -f index.html
        test -f dashboard.html
        test -f script.js
        test -f style.css

        # Check docker image exists
        docker images | grep cloud-native-todo-app-cicd

        # Remove old test container if exists
        docker rm -f test-container || true

        # Run container on different port (safe)
        docker run -d -p 8081:80 --name test-container avindock/cloud-native-todo-app-cicd:latest

        sleep 5

        # Check app response
        curl -f http://localhost:8081 || exit 1

        # Cleanup always
        docker rm -f test-container
        '''

        echo "All tests passed ✅"
}
