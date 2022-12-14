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

def Testing(jobnames)
{
  sh "java -jar /root/.jenkins/workspace/${jobnames}/testing.jar"
}

def mail(body,subject,emailID)
{ 
  mail bcc: '', body: "${body}", cc: '', from: '', replyTo: '', subject: "${subject}", to: "${emailID}"
}


