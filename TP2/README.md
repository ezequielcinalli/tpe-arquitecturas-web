## Segunda entrega

### Instrucciones para ejecutar
Alternan en el main el parametro el metodo `initialize()`entre `Factory.MYSQL` y `Factory.DERBY`

### Instrucciones para ejecutar MySql

- Crear base de datos "integrator2DB" dentro de MySql
- Aunque de un error en consola la primera vez, esperar que termine de correr
el servicio3 en casi todas las máquinas funciona perfecto, excepto en una donde retorna BigInt en vez de Integer y causa un error en tiempo de ejecución

Las credenciales para MySql son:
Usuario: root
Password: (vacio)
Puerto: 3306

### Instrucciones para ejecutar Derby
Al ejecutar el main la base se crea, junto a las relaciones y la mock data de las tablas. 
Pero al intentar insertar un estudiante da error de ID repetido. Entendemos que es un error en la implementacion hibernate de JPA ya que el codigo deberia ser el mismo. A pesar de esto, consideramos que el patron factory method esta bien implementado.

### Diagrama entidad - relacion
![image](https://github.com/ezequielcinalli/tpe-arquitecturas-web/blob/main/docs/EntityRelationshipDiagram_Integrador2.png)

### Diagrama de clases
![image](https://user-images.githubusercontent.com/70036411/193145029-77341783-a810-439c-a61e-9450687e3d7b.png)
