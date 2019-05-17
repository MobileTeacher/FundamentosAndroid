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

Mensagem ao sistema que esp
	
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTkzMjA0NTY1N119
-->