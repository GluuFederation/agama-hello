<p align="center">
  <img width="600" height="400" src="https://github.com/GluuFederation/agama-hello/assets/20867846/5158d850-dc31-4e09-a952-f8d89294dd89">
</p>

<!-- These are statistics for this repository-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache License][license-shield]][license-url]

# Agama-Hellō

This demo project shows how to use Agama to leverage the powerful
[hello.coop](https://hello.coop) platform for consumer authentication, which
supports a variety of authenticators and social login options.

# Overview

Agama has built-in support for developers to connect to an external OpenID
Connect Provider ("OP") using the authorization code flow. That's handy because
**hello.coop** provides an OpenID Connect interface for user authentication.
Using the Agama `RFAC` command, the main **agama-hello** flow redirects the
end-user to the **hello.coop** authorize endpoint: `https://wallet.hello.coop/authorize`.
If successful, the Agama flow calls the Userinfo endpoint to obtain user
claims.

# Deploy and Test

## Requirements

1. Running instance of Jans Auth Server or Gluu Flex

## Add Java dependencies
1. Download latest [agama-hello-custom.jar](https://github.com/GluuFederation/agama-hello/releases/latest/download/agama-hello-custom.jar) from [Releases](https://github.com/GluuFederation/agama-hello/releases).
2. `scp` the jar file to `/opt/jans/jetty/jans-auth/custom/libs/` on Auth Server
3. On Auth Server,  edit `/opt/jans/jetty/jans-auth/webapps/jans-auth.xml` and
add the jar file to the `<set name="extractClasspath">...</Set>` element. For example:
```
   <Configure class="org.eclipse.jetty.webapp.WebAppContext">
      <Set name="contextPath">/jans-auth</Set>
      <Set name="war">
          <Property name="jetty.webapps" default="." />/jans-auth.war
      </Set>
      <Set name="extractWAR">true</Set>
      <Set name="extraClasspath">
         ...
         /opt/jans/jetty/jans-auth/custom/libs/agama-hello-custom-{version}.jar,
         ...
      </Set>
    </Configure>
```

4. Restart Auth Server to load the new jar:
```
systemctl restart jans-auth.service
````

## Deployment

Download the latest [agama-hello.gama](https://github.com/GluuFederation/agama-hello/releases/latest/download/agama-hello.gama) file and deploy it in Auth Sever. You can follow this [guideline](https://agama-lab.gluu.org/agama-101/deploying-an-agama-project-to-jans-server/) if you don't know how to deploy an Agama Project.

## Configuration

After deploying the `agama-hello` project, extract the sample configuration:
1. Move to the top of the agama-project using `jans-tui` then press `c` It will popup with the below options:
    ![Screenshot 2023-11-08 at 11 32 48 AM](https://github.com/GluuFederation/agama-hello/assets/20867846/8ccc6bd2-6dc2-4c79-920a-db5cc687c8b5)
1. Select `export sample config` to extract sample configuration into a file.
    ![Screenshot 2023-11-08 at 11 29 48 AM](https://github.com/GluuFederation/agama-hello/assets/20867846/53178b8d-5d5d-45b6-9017-fa7bc4f54fe0)
1. Modify the configuration file with your **hello.coop** client credentials,
which you can find in the [console page](https://console.hello.coop) :
```
    {
      "hello.agama.inbound.hello": {},
      "hello.agama.inbound.hello_user": {},
      "hello.agama.inbound.main": {
        "hello": {
          "clientId": "CLIENT_IDENTIFIER",      <--- ADD YOUR CLIENT ID
          "clientSecret": "CLIENT_SECRET",      <--- ADD YOUR CLIENT SECRET
          "authzEndpoint": "https://wallet.hello.coop/authorize",
          "tokenEndpoint": "https://wallet.hello.coop/oauth/token",
          "userInfoEndpoint": "https://wallet.hello.coop/oauth/userinfo",
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
1. Import the modified configuration file using **`Import Configuration`** option.
It will show successful result like below picture:
    ![import success](https://github.com/GluuFederation/agama-hello/assets/20867846/141cb8b8-4e8f-46f9-ada6-1d2228956197)

Setup is done! Now, let's test our deployment!

## Test Deployment

You'll need an OpenID Connect test RP. You can try [oidcdebugger](https://oidcdebugger.com/),
[jans-tarp](https://github.com/JanssenProject/jans/tree/main/demos/jans-tarp) or [jans-tent](https://github.com/JanssenProject/jans/tree/main/demos/jans-tent). Check out this video to see
an example of **agama-hello** in action:
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
</tr>
</table>


# License

This project is licensed under the [Apache 2.0](https://github.com/GluuFederation/agama-hello/blob/main/LICENSE)

# Acknowledgments

This project based on [agama-openid](https://github.com/GluuFederation/agama-openid).

<!-- This are stats url reference for this repository -->
[contributors-shield]: https://img.shields.io/github/contributors/GluuFederation/agama-hello.svg?style=for-the-badge
[contributors-url]: https://github.com/GluuFederation/agama-hello/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/GluuFederation/agama-hello.svg?style=for-the-badge
[forks-url]: https://github.com/GluuFederation/agama-hello/network/members
[stars-shield]: https://img.shields.io/github/stars/GluuFederation/agama-hello?style=for-the-badge
[stars-url]: https://github.com/GluuFederation/agama-hello/stargazers
[issues-shield]: https://img.shields.io/github/issues/GluuFederation/agama-hello.svg?style=for-the-badge
[issues-url]: https://github.com/GluuFederation/agama-hello/issues
[license-shield]: https://img.shields.io/github/license/GluuFederation/agama-hello.svg?style=for-the-badge
[license-url]: https://github.com/GluuFederation/agama-hello/blob/master/LICENSE
