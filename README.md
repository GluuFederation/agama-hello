<p align="center">
  <img width="600" height="400" src="https://github.com/GluuFederation/agama-hello/assets/20867846/5158d850-dc31-4e09-a952-f8d89294dd89">
</p>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache License][license-shield]][license-url]

# Agama-Hellō

**Agama-Hello** is an Inbound OpenID based Agama project for social logins. This project is a successful collaboration between [Janssen Server](https://docs.jans.io) and [hello.coop](https://hello.coop) SaaS service on the Agama journey ahead. Hellō is a SaaS service which suppports a big number of social platform to login using Single-sign-on. So, With the deoployment of this agama project into the Janssen server we can enable social logins for a big number of social platform for Jans users.

# Overview

In Inbound OpenID, users can login to the Janssen server using external OpenID Connect Provider (OP) using the authorization code flow. In this agama project, we are using hello.coop SaaS service. So, When the **agama-hello** main flow launched user's browser is redirected to hello.coop authorize URL (https://wallet.hello.coop/authorize) to login using supported social platform. After successfull authentication, an access token is obtained to grab user profile data and send data back to the Janssen Authorize URL. If the user prebiously logged with this flow, then it will create a session for the user in local jans server and redirect to back to the RP. Otherwise, A new user will be inserted into the janssen server and creates a session for the user to redirect back to the RP.


# Deploy and Test

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
4. Restart `jans-auth` server with this command: 
    ```
    systemctl restart jans-auth.service
    ```

## Deployment

Download the latest [agama-hello.gama](https://github.com/GluuFederation/agama-hello/releases/latest/download/agama-hello.gama) file and deploy it in your Janssen server. You can follow this [guideline](https://agama-lab.gluu.org/agama-101/deploying-an-agama-project-to-jans-server/) to deploy it on your Janssen server if you don't know how to deploy agama projects on Janssen server.

## Configuration

After deploying the `agama-hello` project into the Janssen server you can extract the sample configuration of this project by following these steps:
1. Move to the top of the agama-project using `jans-tui` then press `c` It will popup with the below options:
    ![Screenshot 2023-11-08 at 11 32 48 AM](https://github.com/GluuFederation/agama-hello/assets/20867846/8ccc6bd2-6dc2-4c79-920a-db5cc687c8b5)

3. You can select `export sample config` to extract sample configuration into a file. 
    ![Screenshot 2023-11-08 at 11 29 48 AM](https://github.com/GluuFederation/agama-hello/assets/20867846/53178b8d-5d5d-45b6-9017-fa7bc4f54fe0)
4. You can take another tab and login your janssen server to modify the sample configuration file. The sample configuration file should be look like this:
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
        "uidPrefix": ""
      }
    }
    ```
5. Please grab the `ClientId` and `ClientSecret` for your own application by visiting [hello console page](https://console.hello.coop) of the Hello SaasS service and place them in **clientId** and **clientSecret** section.
6. Import the modified configuration file using **`Import Configuration`** option. It will show successful result like below picture:
    ![import success](https://github.com/GluuFederation/agama-hello/assets/20867846/141cb8b8-4e8f-46f9-ada6-1d2228956197)

So, Setup is done successfully. Now, We can test our deployment.

## Test Deployment

Either you can try [jans-tarp](https://github.com/JanssenProject/jans/tree/main/demos/jans-tarp) or [jans-tent](https://github.com/JanssenProject/jans/tree/main/demos/jans-tent) to test the `agama-hello` deployment. An animitaed video is shown below how this authentication works where jans-tarp has been used as a relying party.

![ezgif com-video-to-gif](https://github.com/GluuFederation/agama-hello/assets/20867846/2158f064-ff8b-430f-a382-32e5e360a3cf)


# Contributors

<table>
<tr>
    <td align="center" style="word-wrap: break-word; width: 150.0; height: 150.0">
        <a href=https://github.com/imShakil>
            <img src=https://avatars.githubusercontent.com/u/20867846?v=4 width="100;"  style="border-radius:50%;align-items:center;justify-content:center;overflow:hidden;padding-top:10px" alt=Mobarak Hosen Shakil/>
            <br />
            <sub style="font-size:14px"><b>Mobarak Hosen Shakil</b></sub>
        </a>
    </td>
    <td align="center" style="word-wrap: break-word; width: 150.0; height: 150.0">
        <a href=https://github.com/nynymike>
            <img src=https://avatars.githubusercontent.com/u/3717101?v=4 width="100;"  style="border-radius:50%;align-items:center;justify-content:center;overflow:hidden;padding-top:10px" alt=Michael Schwartz/>
            <br />
            <sub style="font-size:14px"><b>Michael Schwartz</b></sub>
        </a>
    </td>
</tr>
</table>


# License

This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for details.

# Acknowledgments

This project is truly based on [agama-openid](https://github.com/GluuFederation/agama-openid). You can go with this agama project if you need to use any other external OpenID Connect Provider (OP) instead of hello.coop SaaS service.


[contributors-shield]: https://img.shields.io/github/contributors/GluuFederation/agama-hello.svg?style=for-the-badge
[contributors-url]: https://github.com/GluuFederation/agama-hello/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/GluuFederation/agama-hello.svg?style=for-the-badge
[forks-url]: https://github.com/GluuFederation/agama-hello/network/members
[stars-shield]: https://img.shields.io/github/stars/GluuFederation/agama-hello?style=for-the-badge
[stars-url]: https://github.com/GluuFederation/agama-hello/stargazers
[issues-shield]: https://img.shields.io/github/issues/GluuFederation/agama-hello.svg?style=for-the-badge
[issues-url]: https://github.com/GluuFederation/agama-hello/issues
[license-shield]: https://img.shields.io/github/license/GluuFederation/agama-hello.svg?style=for-the-badge
[license-url]: https://github.com/GluuFederation/agama-hello/blob/master/LICENSE.txt
