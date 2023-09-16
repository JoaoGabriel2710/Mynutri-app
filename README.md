# Mynutri-app

## criem os componentes separadamente na pasta composables e ponham o componente dentro da pasta necessaria:
- composables/common: Pasta que vai os componentes comuns do app por exemplo um botão.
- composables/screens: Pasta que vai as telas do app.
- composables/widgets: Pasta que vai os componentes gerais caso ele seja repetido mais vezes em outras telas, ponham na pasta common

## a paleta de cores já está definida
- caso precisem utilizar uma das cores do app chamem através de uma variavel que está definida na pasta ui/color:
`PrimaryColor`

## padrões a seguir
- escrever os codigos em inglês nomeem arquivos em inglês.
- caso um arquivo contenha espaço separe com hifen - .
- as funções e classes devem ser nomeadas como padrão `camelCase`, porém as funções de @Composables é da seguinte forma:

```kotlin
@Composables
fun MyFunction(){}
// ao inves de dar um espaço ou por _ para cada espaço continuem utilizando o padrão `camelCase`.
```

## por enquanto é isso se precisarem usar esse readme para anotações ou obeservações no projeto usem a vontade

