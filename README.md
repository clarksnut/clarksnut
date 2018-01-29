# Clarksnut
Clarksnut allows you to centralize all your XML-UBL Documents on one site.

# Quick Start
Clone the repository:
```
git clone https://github.com/clarksnut/clarksnut.git
```

Inside project root folder execute:
```
mvn wildfly-swarm:run -pl app -DskipTests
```

Wait until the server starts, and then go to: <http://localhost:8080>

# Production
For production purposes:
```
export SWARM_PROJECT_STAGE=production
```

# Securing Clarksnut using Keycloak
In development environments you can use [docker to start a new Keycloak Server](https://hub.docker.com/r/jboss/keycloak/):
```
docker run -p 8081:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
```

* Go to: <http://localhost:8081/auth> and login with admin/admin.
* Create a realm and configure Google Identity Providers. You can use a realm base called **clarksnut-realm.json** that is located on the project root.
* From Keycloak, download keycloak.json and save it on a folder.


For start the application using Keycloak, you can point keycloak.json file:
```
mvn wildfly-swarm:run -pl app -DskipTests -Dswarm.keycloak.json.path=/my_folder/keycloak.json
```

Wait until the server starts, and then go to: <http://localhost:8080>

# Advanced Configuration

## Configure database creation strategy (Optional):

Database strategy can be configured using environment variables:
```
export CN_HIBERNATE_FORMAT_SQL=[true|false]
```

Default values:
```
CN_HIBERNATE_STRATEGY=update
CN_HIBERNATE_FORMAT_SQL=false
```

## Configure database search strategy (Optional):

Database search strategy can be configured using environment variables:
```
export HIBERNATE_INDEX_MANAGER=[directory-based|near-real-time|elasticsearch]
```
Default values:
```
HIBERNATE_INDEX_MANAGER=directory-based
```

### Elasticsearch (Optional - Production)
This configuration should be considered in production environments.

In case elasticsearch was selected as index manager, then you need to configure additional environment variables:
```
export CN_ELASTICSEARCH_HOST=[my_elasticsearch_host]
export CN_ELASTICSEARCH_USER=[my_elasticsearch_username]
export CN_ELASTICSEARCH_PASSWORD=[my_elasticsearch_password]
export CN_ELASTICSEARCH_INDEX_SCHEMA_MANAGEMENT_STRATEGY=[none|validate|update|create|drop-and-create|drop-and-create-and-drop]
export CN_ELASTICSEARCH_REQUIRED_INDEX_STATUS=[green|yellow]
```
Default values:
```
ES_INDEX_SCHEMA_MANAGEMENT_STRATEGY=update
ES_REQUIRED_INDEX_STATUS=green
```

### Elasticsearch AWS (Optional - Production)
In case your elasticsearch cluster is provided by AWS you need to follow previous step and additionally:

```
export CN_ELASTICSEARCH_AWS_ENABLED=[true|false]
export CN_ELASTICSEARCH_AWS_ACCESS_KEY=[my_aws_access_key]
export CN_ELASTICSEARCH_AWS_SECRET_KEY=[my_aws_secret_key]
export CN_ELASTICSEARCH_AWS_REGION=[my_aws_region]
```

Default values:
```
CN_ELASTICSEARCH_AWS_ENABLED=false
```      

# Configure Clarksnut
Clarksnut has its own configuration and you can override it using a yaml file:

clarksnut.yml:

```
swarm:
  datasources:
    data-sources:
      ClarksnutDS:
        jndi-name: java:jboss/datasources/ClarksnutDS
        driver-name: [h2|mysql|postgresql]
        connection-url: [database_url]
        user-name: [database_username]
        password: [database_password]
clarksnut:
  fileStorage:
    provider: [jpa|filesystem]
  report:
    default: clarksnut
    cacheReports: false
    cacheTemplates: false
    folder:
      dir: "/reports"
  theme:
    default: clarksnut
    staticMaxAge: 2592000
    cacheThemes: false
    cacheTemplates: false
    folder:
      dir: "/themes"
  mail:
    vendor:
      gmail:
        applicationName: "Clarksnut"
    smtp:
      host: [smtp_host]
      port: [smtp_port]
      auth: [true|false]
      ssl: [true|false]
      starttls: [true|false]      
      from: [smtp_from]
      fromDisplayName: [smtp_from_display_name]
      replyTo: [smtp_reply_to]
      replyToDisplayName: [smtp_reply_to_display_name]
      envelopeFrom: [smtp_envelope_from]
      user: [smtp_user]
      password: [smtp_password]
  truststore:
    file:
      file: [my_file]
      password: [my_password]
      hostname-verification-policy: [policy],
      disabled: [true|false]
``` 

After that you can start the project with the command:

```
mvn wildfly-swarm:run -pl app -DskipTests -Dswarm.project.stage.file=file:///../../..../clarksnut.yml
```

Using keycloak.json.

```
mvn wildfly-swarm:run -pl app -DskipTests -Dswarm.project.stage.file=file:///app/config/clarksnut.yml -Dswarm.keycloak.json.path=/my_folder/keycloak.json
```

# Deploy to Openshift
If you are using Openshift you can use [this tutorial for Openshift](https://github.com/clarksnut/clarksnut/blob/master/docs/openshift.md).

