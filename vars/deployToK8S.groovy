def call()
{
  echo "Deploying on Kubernetes..."

  sh """
  kubectl apply -f k8s-deploy/namespace.yml
  kubectl apply -f k8s-deploy/

  kubectl rollout restart deployment.apps/todo-app-deployment -n todo-ns
  kubectl rollout status deployment.apps/todo-app-deployment -n todo-ns
  echo "App deployed successfully 🚀"
  """
                
          
              
}
