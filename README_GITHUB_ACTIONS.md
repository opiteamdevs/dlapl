# Doce de Leite — build Android no GitHub Actions

## Como gerar o APK de instalação
1. Envie todos os arquivos do projeto para um repositório GitHub.
2. Confirme que `.github/workflows/android.yml` está na raiz do repositório.
3. Abra **Actions** e execute **Android CI** (ou faça push/PR).
4. Quando terminar, abra a execução e baixe o artefato **DoceDeLeite-debug-apk**.
5. Extraia o ZIP do artefato e instale o APK no Android para testar.

## R8 e ofuscação
A variante `release` ativa `minifyEnabled true` e `shrinkResources true`. O R8 faz otimização, remoção de código não usado e ofuscação. O artefato `DoceDeLeite-release-apk-R8` é minificado.

O APK/AAB de release gerado pelo workflow **não está assinado para distribuição**. Para publicar na Play Store, configure assinatura segura no GitHub Actions usando secrets (`ANDROID_KEYSTORE_BASE64`, `ANDROID_KEYSTORE_PASSWORD`, `ANDROID_KEY_ALIAS`, `ANDROID_KEY_PASSWORD`) e assine o AAB. Nunca envie keystore ou senhas para o repositório.

## Observações
- O workflow instala Gradle 8.13 e usa Java 17, compatíveis com Android Gradle Plugin 8.12.
- O build debug é destinado a testes; o AAB de release é um artefato de compilação, não um pacote pronto para publicação sem assinatura.
- As telas `CriarpostActivity` e `PerfilActivity` foram adicionadas como entradas mínimas porque estavam referenciadas no Manifest e em outras telas, mas ausentes do código-fonte recebido. As ações de publicar/salvar ainda precisam ser conectadas à API real antes de lançar em produção.
