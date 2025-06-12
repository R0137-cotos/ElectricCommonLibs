#!/bin/bash
GITHUB_TOKEN="7bb109e2c08f82c0ba2f49f0dce3158baed759ee"
revision="ccfb07b3b0aee7b58b546c49c95b99e8e3026860"
payload=$(cat << EOS
{
  "state": "failure",
  "context": "gradle test",
  "description": "starting gradle test."
}
EOS
)
curl -s -X POST https://mygithub.ritscm.xyz/api/v3/repos/cotos/ElectricCommonLibs/statuses/${revision} \
                -H "Authorization: token ${GITHUB_TOKEN}" \
                -H "Content-Type: application/json" \
                -d "${payload}"

