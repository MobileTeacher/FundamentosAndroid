## Aplicativos com mais de uma tela

### Intents explícitas

Mensagem ao sistema que especifica explicitamente qual componente deve ser acionado.

	```kotlin
	//(...)
	val minhaIntent = Intent(this, MinhaNovaActivity::class.java)
	minhaIntent.putExtra("chave", "valor")
	startActivity(minhaIntent)
	```


### Intents implícitas

Mensagem ao sistema que especifica qual ação deseja ser realizada. O sistema Android apresenta ao usuário uma lista de aplicativos candidatos a realizar a ação.

[Verifique a lista de intents comuns aqui.](https://developer.android.com/guide/components/intents-common?hl=pt-BR)
	

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTYxNzczNzMwNl19
-->