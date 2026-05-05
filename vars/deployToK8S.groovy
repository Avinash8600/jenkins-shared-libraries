def call()
{
  echo "Deploying on Kubernetes..."

  sh """
  kubectl apply -f k8s-deploy/namespace.yml
  kubectl apply -f k8s-deploy/deployment.yml
  kubectl apply -f k8s-deploy/service.yml

  kubectl rollout restart deployment/todo-app -n todo-ns
  kubectl rollout status deployment/todo-app -n todo-ns
  echo "App deployed successfully 🚀"
  """
                
          
              
}
