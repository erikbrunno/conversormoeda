# Sistema de conversão de moeda

### Esse sistema tem como objetivo converter um valor de uma moeda de origem para outro valor em uma moeda de destino, por exemplo, converter 500 EURO para DOLAR. A aplicação faz uma consulta na api de dados abertos do banco central para realizar a a conversão.

## Requisitos mínimos

### Antes de mais nada você precisará ter instalado em seu computador:

1. Maven, estamos usando a versão **3.6.3** nesse exemplo;
2. Node JS - versão **6.13.4 ou superior**;
3. Mysql -versão **5.7.30 ou superior**;
4. Docker, estamos usando a versão **19.03.13** nesse exemplo;

## RabbitMQ

### Esse sistema possui um tratamento de exception a nível de controller que captura todas as exception lançadas no controlador e envia para uma fila configurada no rabbitMq, essa fila é consumida por um outro serviço, vou deixar o link abaixo:

### https://github.com/erikbrunno/conversormoeda-registry

### Para baixar e executar o rabbitMQ usando o docker, execute a instrução abaixo

---------------------------------------------------------------------------------------
### docker run -d -p 5672:5672 -p 15672:15672 --name=rabbitmq rabbitmq:3.8.3-management 
---------------------------------------------------------------------------------------

### Em seguida acessa url http://localhost:15672/ para acessa a interface do rabbitMQ e digite "guest" para usuario e senha.
