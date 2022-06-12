# alura-7daysofcode-android
Repositório da iniciativa #7DaysOfCode da Alura, tema Android.

Elaborado por Alex Felipe, Tech Lead e instrutor na Alura.

# Roteiro

## Dia 01

No desafio de hoje, você vai criar o projeto **DevHub**. A partir dele, você será capaz de visualizar diversas informações públicas do GitHub sobre determinada pessoa, como, por exemplo, o nome de usuário, nome real, bio, imagem, repositórios, etc.

Para criar o projeto, você irá utilizar o **Android Studio**. A grande diferença em relação a um projeto qualquer no Android é que, agora, você vai criar um projeto com o **Jetpack Compose**. Caso essa seja a sua primeira vez usando o Jetpack Compose, eu deixei alguns links de explicação na seção “Extra”.

Após criar o projeto, você provavelmente terá um código similar a este na `Activity` principal:

```kotlin
package br.com.alura.devhub

// imports

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHubTheme{
        Greeting("Android")
    }
}
```

O conteúdo inicial pode variar de acordo com a versão do Android Studio também! Sendo assim, apenas identifique se a estrutura da `Activity` principal foi mantida e, também, se existe uma estrutura mínima do **Compose**, como é o caso da chamada do `setContent`.

Após verificar essa estrutura mínima, rode o projeto e verifique se o conteúdo do App é apresentado para você.

Com o projeto rodando, o seu primeiro passo na escrita do código será criar a primeira tela do DevHub, a tela de perfil, apenas com dados estáticos por enquanto:

- Foto de perfil
- Nome
- Usuário do GitHub
- Bio

(Você pode colocar as suas informações nesta etapa! 😉)

Antes de começar a escrever o seu código, remova quaisquer códigos gerados pelo Android Studio na `Activity` e mantenha apenas a seguinte estrutura:

```kotlin
package br.com.alura.devhub

// imports

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}
```

Dentro do `Surface`, **você vai escrever o código que vai apresentar o conteúdo proposto pelo desafio!** Para fazer isso, você deverá utilizar alguns elementos composable (funções do `Compose` que desenham a tela) disponíveis, como os de layouts e texto.

Para esse primeiro exercício, faça tudo na própria `Activity` principal! Mais para frente, você irá focar em outras tarefas para evoluir e organizar melhor o código.

### Dica

Para desenhar um layout esperado, o **Compose** oferece alguns componentes básicos, como o `Column` e `Row`. Boa parte dos layouts podem ser desenhados usando esses componentes básicos.

Para apresentar uma imagem, você pode usar o *composable* `Image`. A partir dele, você tem algumas sobrecargas para inserir uma imagem, dentre elas, você pode usar a que recebe um `Painter` como primeiro argumento e pode implementá-lo a partir da função `painterResource()`, que recebe um Int esperando um id de `Drawable`. A imagem que você deseja adicionar deverá ser armazenada no diretório `app/res/drawable`.

### Extra

Caso seja a sua primeira com o **Jetpack Compose**, você pode seguir [essas instruções para criar um projeto Android com o Jetpack Compose](https://developer.android.com/jetpack/compose/setup). É válido ressaltar que, dependendo da versão que você estiver utilizando, pode ser que apareçam outras opções para criar um projeto com o Compose.

Para ver mais sobre componentes básicos do Compose, você pode conferir alguns [exemplos nesta página](https://developer.android.com/jetpack/compose/layouts/basics).

Se você quiser uma introdução maior ao Compose, você também pode conferir esse **Alura+** que explica o que é o [Jetpack Compose](https://www.youtube.com/watch?v=ln53tOr6RWM).

## Dia 02

Em breve.
