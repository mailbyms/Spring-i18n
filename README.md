
# Spring-i18n
Spring boot 的国际化

## 项目说明
使用 `LocaleContextHolder` 获得当前的 locale，对应从 messages_xx.properties 里读出对应的值  
默认 locale 是运行环境的 locale，在容器内运行要设置环境变量 `LANG zh_CN.UTF-8` （在Dockerfile 或 容器运行时设置）  
也可以在 HTTP 头部指定 `Accept-Language`，例如：
```shell
$ curl 'http://localhost:8080/test'
登录
$ curl 'http://localhost:8080/test' --header 'Accept-Language: en'
Login
MS@DESKTOP-V32QMAF MINGW64 ~/Documents/workspace/github/Spring-i18n
$ curl 'http://localhost:8080/test' --header 'Accept-Language: ch'
登录
```