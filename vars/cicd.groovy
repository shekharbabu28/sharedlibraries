def Git(repo)
{
  git "${repo}"
}

def Maven()
{
  sh 'mvn package'
}
