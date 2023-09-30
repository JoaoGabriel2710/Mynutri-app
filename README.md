# Mynutri-app

## Guia projeto:
- Na pasta main especificamente a `composables`, está sendo criando uma pasta para cada tela aonde ela contém os seus respectivos composables

## a paleta de cores já está definida
- caso precisem utilizar uma das cores do app chamem através de uma variavel que está definida na pasta ui/color:
- `PrimaryColor`
- `SecondaryColor`
- `TerciaryColor`
- `GradientColor`

## padrões a seguir
- escrever os codigos em inglês e os arquivos também.
- caso um arquivo contenha espaço separe com hifen -, no caso do XML separe com underline _.
- as funções, classes e os `@Composables` devem ser nomeadas como padrão `camelCase` :

```kotlin
@Composables
fun MyFunction(){}
// ao inves de dar um espaço ou por _ para cada espaço continuem utilizando o padrão `camelCase`.
```

```kotlin
class UserModel
```

```kotlin
dataclass CardList 
```

```kotlin
fun myFunction(){}
```
