# Prueba Tecnica – Desarrollador Backend Java
-------------

## Descripcion

El BackEnd debe tener 1 controlador: gatos e imagenes. Se debe crear un servicio por
cada controlador y los modelos necesarios para el intercambio de datos a trav«s de
REST, ademøs de implementar pruebas unitarias y buenas prøcticas de desarrollo
(SOLID, Clean Architecture)

---------

## Funcionamiento


### GET /breeds:

Retornara una lista de **todas** las razas de gatos. con la siguiente forma de cada una de las razas:

    [
        {
            "name": "Abyssinian",
            "breed": "abys"
        }
        ...
    ]

donde **name** es el nombre de la raza y **breed** es un id que nos servira para filtrar nuestras peticiones mas adelate

### GET /breeds/breed_id | | /breeds/breed_id_1,breed_id_2

Retonara todos los registros (Max 100) de una o mas razas de gato segun se solicite con los breed Ids, quiere decir que
si envia **/breeds/breed_id** retornada un maximo de 100 registros de esa sola raza, si hace **/breeds/breed_id_1,breed_id_2** retornada un maximo de 100 registros de esas 2 razas y asi sucecivamente.

+ ejemplo:

  ### /breeds/aege

  retornara 5 registros de la raza aege, con las siguientes caracteristicas


        [
            {
            "breeds": [
                {
                    "name": "Aegean",
                    "breed": null
                }
            ],
            "categories": null,
            "id": "ozEvzdVM-",
            "url": "https://cdn2.thecatapi.com/images/ozEvzdVM-.jpg",
            "width": 1200,
            "height": 800
        }
        ...

        ]

### GET /breeds/search

retornara la informacion asociada a la consulta teniendo en cuenta la los filtros de limitados por  https://thecatapi.com/

+ ejemplo:

  ### /breeds/search?limit=20
  retornara un maximo de 20 imagenes sin importar la raza

        [
            {
                "breeds": [],
                "categories": null,
                "id": "27l",
                "url": "https://cdn2.thecatapi.com/images/27l.jpg",
                "width": 680,
                "height": 455
            }
            ...
        ]


## Dockerizacion

Actualmente esta creado el dockerfile correspondiente para la dockerizacion del API.

### crear image

    docker build -t xpertgroupapp .   

### crear y ejecutar container (consola)

    docker run -d -p 8080:8080 xpertgroupapp

*si es de su preferencia tambien puede hacerlo mediante docker desktop*



