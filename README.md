# Agama-Hello

**Agama-Hello** is an Inbound OpenID based Agama project for social logins. This project is a successful collaboration between [Janssen Server](https://docs.jans.io) and [hello.coop](https://hello.coop) SaaS service on the Agama journey ahead.


## Requirements
1. Janssen Installation

## Dependency resolved
1. Download this [jar-with-dependencies file](https://maven.jans.io/maven/io/jans/agama-inbound/) according to your jans server version.
2. Put this file inside `/opt/jans/jetty/jans-auth/custom/libs/` directory of your Jans server
3. Edit `/opt/jans/jetty/jans-auth/webapps/jans-auth.xml` and append below line between `<set name="extractClasspath">...</Set>` and save the file:
   ```
   /opt/jans/jetty/jans-auth/custom/libs/agama-inbound-1.0.19-jar-with-dependencies.jar,/opt/jans/jetty/jans-auth/custom/
   ```   
   after editing it should look like this:
   ```
   <Configure class="org.eclipse.jetty.webapp.WebAppContext">

    <Set name="contextPath">/jans-auth</Set>
    <Set name="war">
        <Property name="jetty.webapps" default="." />/jans-auth.war
    </Set>
    <Set name="extractWAR">true</Set>

    <Set name="extraClasspath">/opt/jans/jetty/jans-auth/custom/libs/agama-inbound-1.0.19-jar-with-dependencies.jar,/opt/jans/jetty/jans-auth/custom/libs/jans-fido2-client.jar,/opt/jans/jetty/jans-auth/custom/libs/twilio.jar</Set></Configure>
   ```
4. Restart `jans-auth` server with this command: `systemctl restart jans-auth.service`

## Deployment

Download the latest [agama-hello.gama](https://github.com/GluuFederation/agama-hello/releases/latest/download/agama-hello.gama) file and deploy in your Jans server. Follow this [guideline](https://agama-lab.gluu.org/agama-101/deploying-an-agama-project-to-jans-server/) to deploy it on your Janssen server.

## Configuration

After deploying the `agama-hello` project into the Janssen server you can extract the config by following these steps:
1. Move to the top of the agama-project using `jans-tui` then press `c` It will pop with below option:
   ![Screenshot 2023-10-31 at 1 10 53 PM](https://github.com/imShakil/hello-agama/assets/20867846/205cfaf8-7923-428c-bffe-c83212cec0c1)
2. You can choose `export sample config` to view the config file supported by this project
3. Then, modify it and `import config`.

Here is what the config file should look like:

```
{
  "hello.agama.inbound.hello": {},
  "hello.agama.inbound.hello_user": {},
  "hello.agama.inbound.main": {
    "hello": {
      "authzEndpoint": "https://wallet.hello.coop/authorize",
      "tokenEndpoint": "https://wallet.hello.coop/oauth/token",
      "userInfoEndpoint": "https://wallet.hello.coop/oauth/userinfo",
      "clientId": "CLIENT_IDENTIFIER",
      "clientSecret": "CLIENT_SECRET",
      "scopes": [
        "openid"
      ],
      "clientCredsInRequestBody": true,
      "custParamsAuthReq": {},
      "custParamsTokenReq": {},
      "redirectUri": null
    },
    "uidPrefix": "hello-"
  }
}
```

Please grab the `ClientId` and `ClientSecret` for your own application by visiting [console page](https://console.hello.coop)

## Test Authentication Flow

Either you can try [jans-tarp](https://github.com/JanssenProject/jans/tree/main/demos/jans-tarp) or [jans-tent](https://github.com/JanssenProject/jans/tree/main/demos/jans-tent) to test the `hello-agama` inbound identity flow to apply hello.coop social logins.
