def call(string projectName , string projectTag , string DockerHubUser)
{
  echo "This is building the code"
  sh "docker build -t ${DockerHubUser}/${projectName}:${projectTag} ."
}
