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

Para essa primeira amostra, você apresentou todas as informações apenas com o visual padrão de cada _composable_, ou seja, um resultado simples e pouco atrativo visualmente.

Dessa forma, **o objetivo do desafio de hoje será a personalização de cada elemento**! Para implementar essa tela, você deve combinar elementos _composable_ de layout.

Conforme a amostra, existem outros elementos _composable_ para auxiliar no layout, como por exemplo o `Box`, que permite o empilhamento de vários composables; ou então o `Row`, que tem a mesma característica do `Column`, mas é usado para o agrupamento horizontal.

Além dos _composables_ de layout, agora você vai utilizar o `Modifier`. A partir dele é possível personalizar _composables_, como, por exemplo, aplicar cores, modificar a forma, aplicar bordas, etc.

Cada _composable_ possui propriedades próprias. Os _composables_ de layout, por exemplo, possuem propriedades para ajustar seus filhos (um filho é um _composable_ dentro de outro, como, por exemplo, um `Text` dentro de um Column); já o _composable_ `Text` é capaz de modificar o seu conteúdo, como tamanho de fonte, alinhamento, etc.

Em resumo, a sua tarefa é implementar um visual mais atraente para apresentar as informações públicas de um perfil do GitHub.

### Dica

Antes de começar a implementação, pense em como você pode dividir o layout para facilitar a decisão dos composables que vai utilizar.

Observe que, nessa amostra, existe um _composable_ exclusivo para o fundo escuro do topo e outro exclusivo para as informações abaixo. Além disso, a imagem foi deslocada, ou seja, ficou entre o composable com fundo escuro do topo e o outro abaixo que mantém as informações gerais.

Também, as informações de nome e usuário estão dentro de um _composable_ exclusivo que as mantém juntas e alinhadas no centro.

É válido ressaltar que essa é apenas uma das possíveis implementações, ou seja, você pode chegar no mesmo resultado visual com estratégias diferentes!

### Extra

Além de chegar no resultado visual, também, você pode aplicar algumas técnicas, como por exemplo, uma altura e deslocamento mais dinâmico para a imagem e fundo escuro.

## Dia 03

Pois bem, o seu App agora é capaz de apresentar as informações básicas de um usuário do GitHub estaticamente. O seu objetivo final será obter esses dados dinamicamente a partir da API do GitHub, mas vamos ir em passos pequenos por enquanto.

Você já pode visualizar os dados públicos de qualquer usuário do Git Hub através do link:

https://api.github.com/users/NOME_DO_USUARIO

Onde você pode substituir "NOME_DO_USUARIO" por qualquer usuário do GitHub, inclusive o seu próprio!

Observe que você pode acessar a minha (ou sua) foto do perfil a partir do campo "`avatar_url`". Dessa forma, em vez de usar uma imagem estática, **agora você pode fazer uma requisição para baixar essa imagem a partir dessa URL e apresentá-la na tela**!

Para fazer essa implementação há diferentes maneiras. Dentre elas, você pode optar por uma requisição mais de baixo nível, que irá lidar com input e output streams, baixar os bytes que representem a imagem e convertê-los para um tipo suportado.

Considerando que essa ação é bastante comum em Apps Android, existem bibliotecas que fazem isso para você, como, por exemplo, a **Coil** para o Compose. Esta biblioteca já possui uma integração com o Jetpack Compose, sendo assim, recomendo que considere o seu uso para o desafio de hoje.

Em resumo, você deve fazer o seguinte:

- Importar a biblioteca Coil ao projeto;
- Substituir o _composable_ de imagem (estático) para o de imagem do Coil (dinâmico);
- Tentar carregar a imagem do seu perfil do GitHub a partir da URL vinda do campo `avatar_url`.

Esse desafio não é tão complexo, porém, vai exigir alguns conhecimentos no projeto Android, como adicionar dependências no Gradle, identificar possíveis problemas por falta de permissão de acesso à internet e, também, a leitura e acompanhamento do passo-a-passo da documentação da biblioteca.

### Dica

Ao ajustar o código, muito provavelmente, você chegará no _composable_ `AsyncImage()`:

```kotlin
AsyncImage(
   model = "https://avatars.githubusercontent.com/u/8989346?v=4",
   contentDescription = null
)
```

Note que ele é bastante similar ao `Image()`. A grande diferença é que, agora, você enviará o endereço diretamente.

Caso o seu App não tenha funcionado como esperado, muito provavelmente ele não está com permissão para acessar a internet. Você pode liberar esse acesso a partir do arquivo `AndroidManifest.xml`.

Outro ponto importante é que a Coil não apresenta a imagem via URL no preview. Para isso, você deverá utilizar um placeholder com uma imagem do projeto. Algo como:

```kotlin
AsyncImage(
   model = ImageRequest.Builder(LocalContext.current)
      .data("ENDEREÇO_DA_IMAGEM")
       .crossfade(true)
       .build(),
   placeholder = painterResource(R.drawable.placeholder)
)
```

### Extra

[Explore a documentação](https://coil-kt.github.io/coil/compose/) para testar e aplicar mais detalhes da Coil.

Você pode verificar mais detalhes sobre [permissões de acesso à rede aqui](https://developer.android.com/training/basics/network-ops/connecting).

## Dia 04

O seu próximo desafio será **implementar um código capaz de fazer uma requisição HTTP e buscar as seguintes informações**:

- foto do perfil
- nome
- usuário
- bio

O desafio de hoje é, provavelmente, um dos mais trabalhosos, pois você vai precisar fazer o seguinte:

- Utilizar um cliente HTTP;
- Implementar o código que realiza a requisição com a API do GitHub a partir de um determinado usuário;
- Converter os dados recebidos em JSON para um objeto Kotlin;
- Apresentar as informações esperadas do usuário utilizado na requisição.

Existe mais de uma maneira de fazer requisições desse tipo para o Android. Dentre as possibilidades, o `HttpsURLConnection` é uma solução possível que já vem disponível no SDK por conta do Java, porém, a implementação com ela é mais verbosa, ou seja, você precisa escrever mais código para obter o resultado esperado.

Considerando outras possibilidades, a **Retrofit** é uma das bibliotecas mais atrativas como cliente HTTP, pois ela facilita alguns passos das requisições HTTP. Por exemplo, ela mantém uma configuração padrão para requisições que aceitam JSON, possui conversores automáticos de objeto para JSON (e vice-versa), tem suporte para _ _coroutines_ e é pouco verbosa na configuração e utilização. Dados esses pontos, recomendo o uso da **Retrofit** para este desafio!

Pensando em tornar esta implementação mais bem organizada, separe o código de requisição em diferentes classes, arquivos e pacotes. Você pode, por exemplo, criar o pacote `webclient`, que vai conter todo o código da Retrofit, desde a configuração de inicialização, modelo para obter os dados e os serviços da Retrofit (interfaces com as requisições). Em código, você vai ter um resultado similar a este:

- Classe para inicialização:

```kotlin
class RetrofitInit {
    private val retrofit = ...

    val gitHubService get() = ...
}
```

- Classe que representa o modelo:

```kotlin
data class GitHubProfileWeb(
   ...
)
```

- Interface que representa o serviço:

```kotlin
interface GitHubService {
   @GET("/users/{user}")
   suspend fun findProfileBy(@Path("user") user: String): GitHubProfileWeb
}
```

É importante destacar que a conversão de JSON para objeto não é automática, é necessário adicionar o conversor ao projeto e também à configuração de inicialização da **Retrofit**.

Após finalizar a implementação da requisição, no método `onCreate()` da `MainActivity`, faça a requisição e apresente o retorno da mesma em um log. Confira se todas as informações são apresentadas como esperado.

### Dica

É válido ressaltar que a API do GitHub possui um limite de requisições. Na última verificação, eram 60 requisições por hora. Isso significa que, durante o desenvolvimento e teste do código, você pode obter um resultado inesperado após um determinado tempo e pode assumir que o código está com problema, mas pode ser apenas a restrição de limite de requisições da API.

Ao criar um projeto com o Compose, já são adicionadas algumas bibliotecas por padrão. Dentre elas, temos a `androidx.lifecycle:lifecycle-runtime-ktx`, que dá acesso ao escopo de coroutines vinculado ao ciclo de vida da Activity. Você pode usar esse escopo para executar a função de suspensão.

### Extra

Caso seja a sua primeria vez utilizando a **Retrofit**, você pode dar uma olhada [neste artigo](https://medium.com/collabcode/consumindo-api-rest-no-android-com-retrofit-em-kotlin-parte-1-5e752ab8a877) que apresenta um tutorial.

A Retrofit possui diversas implementações de conversores que utilizam libs famosas em conversão de JSON para objeto. Você pode conferir as opções na [seção de configuração da documentação do Retrofit](https://square.github.io/retrofit/).

Para mais informações sobre implementação com _Coroutines_, você pode [consultar este artigo](https://www.alura.com.br/artigos/retrofit-com-coroutines-e-livedata-no-android).

Caso você precise de um material mais detalhado sobre _Coroutines_, você pode conferir a [Websérie de operações assíncronas](https://cursos.alura.com.br/extra/webseries-coroutines-kotlin/operacoes-assincronas-no-kotlin-1-apresentacao-w1225). Ou então, pode [conferir esta página da documentação com diversas orientações, dicas e casos de uso](https://developer.android.com/kotlin/coroutines).

## Dia 05

Agora que você tem acesso às informações e uma tela capaz de recebê-las, **o seu objetivo no desafio de hoje será integrar as informações recebidas com a tela**.

Considerando que a requisição HTTP é assíncrona e o código de tela não deve esperar pela resposta da requisição, você deve ajustar o seu código para que ele seja compatível com esse tipo de cenário. Para isso, você pode considerar algumas estratégias como, por exemplo, _callback_, ou então estruturas de publicação e inscrição, como é o caso do `Flow` de _Coroutines_.

Um grande destaque em relação ao `Flow` é que o **Jetpack Compose** oferece uma extensão compatível com o `State` (referência responsável por atualizar a tela do `Compose`).

Em resumo, você deve fazer as seguintes tarefas para no desafio de hoje:

- Ajustar o código para utilizar _callback_ ou Flow (dê preferência ao Flow);
- Integrar as informações recebidas da API e apresentá-las na tela.

Antes de realizar os ajustes, tente utilizar uma classe intermediária que será responsável por rodar a requisição com a Retrofit e, então, quando ela obtiver o resultado, o retornará para quem for consumi-la. Geralmente, essa classe pode ser considerada um _WebClient_, _ViewModel_, _Repository_, etc.

```kotlin
class GitHubWebClient(
   private val service: GitHubService = RetrofitInit().gitHubService
) {

   fun findProfileBy(user: String) = flow{
      ...
   }
}
```

Então, dentro do _composable_, você pode acessar essa classe e utilizar o método que vai dar acesso ao Flow. Por exemplo:

```kotlin
@Composable
fun ProfileScreen(
   user: String,
   webClient: GitHubWebClient = GitHubWebClient()
) {
   ...
}
```

Para fazer a coleta das informações do Flow, você pode utilizar a extensão `collectAsState()`. Essa função exige o argumento "`initial`", que representa o valor inicial após a primeira leitura. Você pode enviar `null` e aplicar uma lógica para apresentar o conteúdo visual do App apenas quando o valor for diferente de nulo:

```kotlin
val foundUser by webClient.findProfileBy(user)
      .collectAsState(initial = null)
   foundUser?.let { userProfile ->
      ...
   }
```

Lembre-se de modificar as informações de cada composable para que sejam apresentados os dados vindo da API. Nessa amostra de código acima, as informações estão vindo de `userProfile`.

Após aplicar os ajustes, rode o App e confira se as informações apresentadas são as mesmas do perfil que foi carregado. Para ter certeza que ele está funcionando, você pode modificar o usuário do perfil a ser buscado e carregar novamente.

### Dica

Ao utilizar a referência de `State`, existe mais de uma maneira para ler esse tipo de informação:

```kotlin
val mutableState = remember { mutableStateOf(default) }

var value by remember { mutableStateOf(default) }

val (value, setValue) = remember { mutableStateOf(default) }
```

Para usar o `by` via _**delegate**_, você precisa fazer o seguinte import:

```kotlin
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
```

### Extra

Você pode obter mais detalhes sobre **o uso do State** e gerenciamento de estado no Jetpack Compose [nessa página da documentação](https://developer.android.com/jetpack/compose/state).

Você também pode ler mais sobre a [teoria e implementação do Flow nesta página da documentação](https://developer.android.com/kotlin/flow).
