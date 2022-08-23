def Git(repo)
{
  git "${repo}"
}

def Maven()
{
  sh 'mvn package'
}

def Deploy(jobname,ip,appname)
{
  sh "scp /root/.jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
}

def Testing(jobname)
{
  sh "java -jar /root/.jenkins/workspace/${jobname}/testing.jar"
}

def Devilvery(name)
{
  input id: ${name}, message: 'Get approval from Delivery Manager' 
}
