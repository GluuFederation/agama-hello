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

This Agama project uses [agama-openid](https://github.com/GluuFederation/agama-openid) for OpenID authentication to leverage the powerful
[hello.coop](https://hello.coop) platform for consumer authentication, which supports a variety of authenticators and social login options. 
Also, This is an example to show the reusability of agama flows from one project to another.

# Requirements
- Agama Dependency: [agama-openid](https://github.com/GluuFederation/agama-openid) deployment
- Credentials: [Hellō SaaS](https://hello.coop) client credentials

# Supported IDPs

| IDP | How to Install? |
|-------|---------------|
| Jans Auth Server | [https://docs.jans.io/stable/admin/install/](https://docs.jans.io/stable/admin/install/) |
| Gluu Flex | [https://docs.gluu.org/stable/install/](https://docs.gluu.org/stable/install/) |

# Flows

| Qualified Name | Description |
|----------------|-------------|
| `org.gluu.hello.coop`| Main agama flow of this project. It first collects the configuration details and triggers to `org.gluu.inbound.oauth2.AuthzCodeWithUserInfo` flow of agama-openid project. After successful authentication, redirect to this main flow for the user onboard. Kindly, check the [diagram](#sequence-diagram) for better understanding |

# Configurations

Sample JSON:
```
{
  "org.gluu.hello.coop": {
    "hello": {
      "oauth": {
        "authzEndpoint": "https://wallet.hello.coop/authorize",
        "tokenEndpoint": "https://wallet.hello.coop/oauth/token",
        "userInfoEndpoint": "https://wallet.hello.coop/oauth/userinfo",
        "clientId": "CLIENT_INDENTIFIER",
        "clientSecret": "CLIENT_SECRET",
        "scopes": [
          "openid"
        ]
      },
      "uidPrefix": "hello-"
    }
  }
}
```

| Flow | Property | Description |
| ---- | -------- | ----------- |
| `org.gluu.hello.coop` | `oauth` | These are OAuth parameters for OpenID authentication. To know more details on these (`oauthParams`), Kindly check [agama-openid](https://github.com/GluuFederation/agama-openid?tab=readme-ov-file#authzcodewithuserinfo-and-authzcode) section|
| `org.gluu.hello.coop` | `uidPrefix` | Prefix string value for user unique ID. By default, Each user those are onboarded through this flow  will use the prefix `hello-` with username |


# Sequence Diagram
A basic diagram to understand how the `agama-hello` works. 

![hello-agama-diagram](https://github.com/GluuFederation/agama-hello/assets/20867846/dd854a29-a507-4718-b366-89e4e07abfdf)
([Source Image](https://sequencediagram.org/index.html#initialData=C4S2BsFMAIEMHNYFtYFoAWlzgPbQMqQCOArpAHYDGMAIiAgE7IBQslwOD0ACpAwM45yzAA6wGoSiDHlg0AEYMcAd359R4ydNizoyyPP5hIGiSCky5AeW6mtluIhQYsuO+e26EyNDhEUQABN3Cx05TGwcZmZeASFUAD5FFTUGAC5oABkceBBhZNU+RP1DYwzmEqNgSESC1IyGSECQRvZoDmgbZjqihJsM2BJgdHJoRtJIfjlvFAB9ADNcZQBeTngAOnhwEhJ1iNx1yhw-ZhtEmbR9nAy8gDccAGsTC5dI86dff3IgjIAVBhA8HgfDSAB1yGtNttdnl5DgSORAuscINhgAmdYAQSG6AAXgBhHCBSAAdTA6AAqqkAJLkeZRF5+AKBWpKQrpMZNFqQNodK7dNmpRJXAY40bjMhTZhXYWua7QXC5UboWAiL78aVyxL9aCUWDYeRsB6nbjvHyoJnfQIZK66onPD4Wr5BM3OEXQfgkSjUfgal4yhKVMqdbh24nMIA))

# Demo

You'll need an OpenID Connect test RP. You can try [oidcdebugger](https://oidcdebugger.com/),
[jans-tarp](https://github.com/JanssenProject/jans/tree/main/demos/jans-tarp) or [jans-tent](https://github.com/JanssenProject/jans/tree/main/demos/jans-tent). 
Check out this video to see an example of **agama-hello** in action: 

![ezgif-1-1574bd2d5c](https://github.com/GluuFederation/agama-hello/assets/20867846/79c70c6c-b4fa-42d2-9ed6-00e5186b4f0d)

<!-- 
![ezgif com-video-to-gif](https://github.com/GluuFederation/agama-hello/assets/20867846/2158f064-ff8b-430f-a382-32e5e360a3cf)
-->

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

This project is based on [agama-openid](https://github.com/GluuFederation/agama-openid).

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
