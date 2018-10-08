带token验证的注册登陆系统
### jks生成方式和公钥导出
```
keytool -genkeypair -alias luotaishuai -keyalg RSA -keypass luotaishuai -keystore luotaishuai.jks -storepass luotaishuai
keytool -list -rfc --keystore luotaishuai.jks | openssl x509 -inform pem -pubkey
