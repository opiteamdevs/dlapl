# Doce de Leite — Projeto Android

Projeto Android Studio baseado no arquivo `603.zip`.

## Alterações nesta versão
- Removida a seta de voltar (`<-`) da barra superior nas telas de Feed, Login, Cadastro e Comentários. A navegação por botão/gesto do Android continua disponível.
- Removida a permissão global para tráfego HTTP sem criptografia; os endpoints encontrados no código usam HTTPS.
- Pacote: `com.docedleite`
- Versão atual: `1.0` (versionCode 1)

## Abrir e compilar
1. Extraia o ZIP.
2. Abra a pasta extraída no Android Studio como projeto Gradle.
3. Aguarde a sincronização do Gradle e instale os componentes do SDK solicitados.
4. Use **Build > Build APK(s)** para gerar um APK de teste.
5. Antes de publicar, teste login, cadastro, feed, comentários e perfil num dispositivo real.

## Publicação
O ZIP é o projeto-fonte, não um APK/AAB assinado para distribuição. Para Google Play, gere um Android App Bundle (`.aab`), configure uma chave de assinatura segura, complete a ficha do app, política de privacidade e classificação etária no Play Console. Não compartilhe a chave privada de assinatura.

## Limitações da verificação
Este ambiente não tem Gradle/Android SDK configurado, então a compilação e a integração com os serviços remotos não puderam ser executadas aqui. A remoção da seta e as alterações de manifesto foram verificadas no código-fonte.
