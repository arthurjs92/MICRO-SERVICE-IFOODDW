## MICRO-SERVICE-IFOODDW

#Contexto da aplicação

Este projeto é um trabalho para exercitar os conhecimentos adquiridos nas aulas de Microserviços e MongoDB. Nele, simulamos um serviço muito famoso de delivery de comida só que provinda das partes mais escuras da web, onde suas lojas oferecem o mais peculiar dos produtos. Com 4 micro serviços, utilizando o melhor framework com as melhores tecnologias, nosso cliente realiza seu cadastro, visualiza as lojas disponíveis, seleciona uma loja, visualiza seus produtos e realiza um order. Este order, chega para a Store que atualiza seu status para "Recebido!". Com uma herança bem simples, a Store também pode se cadastrar, e cadastrar seus produtos. Quando o order ficar pronto, a loja atualiza o status do order e o manda para o DeliveryMan que irá realizar a entrega. Quando a order estiver feita o deliveryMan atualiza novamente seu status. E temos o log que vai registrar todas essas movimentações.

Implementamos os seguintes micro serviços: Log, Client, Store e DeliveryMan. E neles utilizamos o Netflix Eureka Discovery Client, RabbitMQ para que um possa enviar dados para o outro e assim ninguem se sinta sozinho, utilizamos também o OpenFeign para acessar endpoints de outro micro serviço, além das bibliotecas mais connhecidas como JPA e Lombok. Para a persistência de dados utilizamos o MongoDB e como SGBD utilizamos o MongoDBCompass e Mongo Shell. 

Portanto utilizamos o docker, um projeto para o Eureka Discovey Server, um projeto para o Config Server para centralizarmos todas as configurações e outro para o Gateway que vai fazer o papel de loadbalancer e direcionar as requisições para o micro serviço correto.

Segue o diagrama de micro serviço.

![image](https://user-images.githubusercontent.com/88942381/205765667-2596f72a-c2f7-46bb-bd66-7b66e1712bb4.png)
