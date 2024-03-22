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
supports a variety of authenticators and social login options. Also, This is an example to show the reusability of agama flows from one project to another.

# Overview

A basic diagram to understand how the `agama-hello` works. 

![Agama-Hello](https://github-production-user-asset-6210df.s3.amazonaws.com/20867846/315200464-fd1e3d15-7d3d-4977-b11a-9e9bb20e5eb6.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240321%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240321T075653Z&X-Amz-Expires=300&X-Amz-Signature=49fb7f5bbec9b1468c1c387b7df6fbb7c76a6714f33056dd2597b4503fab56d6&X-Amz-SignedHeaders=host&actor_id=20867846&key_id=0&repo_id=706335441)

# Deploy and Test

## Requirements

1. Running instance of Jans Auth Server or Gluu Flex
2. [agama-openid](https://github.com/GluuFederation/agama-openid) deployment required 

## Deployment

Download the latest [agama-hello.gama](https://github.com/GluuFederation/agama-hello/releases/latest/download/agama-hello.gama) file and deploy it on Auth Server. You can follow this [guideline](https://gluu.org/quick-start-guide/) if you don't know how to deploy an Agama Project. Also, You can fork this project and open it in [Agama Lab](https://cloud.gluu.org/agama-lab) for better customizations.

## Configuration

Modify the configuration file with your **hello.coop** client credentials,
which you can find on the [console page](https://console.hello.coop) :
```
{
  "org.gluu.hello.coop": {
    "hello": {
      "clientId": "CLIENT_IDENTIFIER",      <--- ADD YOUR CLIENT ID
      "clientSecret": "CLIENT_SECRET",      <--- ADD YOUR CLIENT SECRET
      "authzEndpoint": "https://wallet.hello.coop/authorize",
      "tokenEndpoint": "https://wallet.hello.coop/oauth/token",
      "userInfoEndpoint": "https://wallet.hello.coop/oauth/userinfo",
      "scopes": [
        "openid"
      ]
    },
    "uidPrefix": ""
  }
}
```

### Additional Properties

- `redirectUri` 
- `clientCredsInRequestBody`
- `custParamsAuthReq`
- `custParamsTokenReq`

To know more details on these (`oauthParams`), Kindly checkout [agama-openid](https://github.com/GluuFederation/agama-openid?tab=readme-ov-file#authzcodewithuserinfo-and-authzcode)


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
