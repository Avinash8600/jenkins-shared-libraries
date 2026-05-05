def call()
{
    echo "Running basic tests..."

    sh '''
    set -e

    # Check required files
    test -f index.html
    test -f dashboard.html
    test -f script.js
    test -f style.css

    # Check docker image exists
    docker images | grep cloud-native-todo-app-cicd || exit 1

    # Remove old container if exists
    docker rm -f test-container || true

    # Run container
    docker run -d -p 8081:80 --name test-container avindock/cloud-native-todo-app-cicd:latest

    # Wait and test
    for i in {1..10}; do
      curl -f http://localhost:8081 && break
      sleep 2
    done

    # Final check
    curl -f http://localhost:8081

    # Cleanup
    docker rm -f test-container
    '''

    echo "All tests passed ✅"
}
