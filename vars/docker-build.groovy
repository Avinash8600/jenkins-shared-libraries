def call(String projectName , String projectTag , String DockerHubUser)
{
  echo "This is building the code"
  sh "docker build -t ${DockerHubUser}/${projectName}:${projectTag} ."
}
