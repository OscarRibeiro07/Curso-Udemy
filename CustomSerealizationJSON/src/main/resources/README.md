
<p>

## Descrição:

*Customização de JSON*
## Conteudo de uso(comando)
--------------------------------------------------------------------

***@JsonPropertyOrder({"id", "last_name", "sobrenome", "endereco", "genero"})***
Define ordem de retorno

***@JsonProperty("last_name")***
Modifica nome do retorno

***@JsonIgnore***
Variavel ocm esta notação é ignorada no retorno


--------------------------------------------------------------------

*PARTICULARIDADES:*

Jackson foi necessario para reconhecimento da classe ValueSerialize e JsonSerializer

JsonSerializer<String> para conversão atualizou nesta versão para ValueSerialize, para que possa utilizar a notação do
@JsonSerialize(using = SerializeGenero.class)

envio:

{
"last_name":"Lucas",
"sobrenome":"Jackson",
"endereco":"USA - LOS ANGELES",
"genero":"MALE"

}

retono:
{
"id": 6,
"last_name": "Mandela",
"sobrenome": "Nelson",
"endereco": "Mvezo - South Africa",
"genero": "M",
"dataNascimento": "30/10/2026"
}



</p>