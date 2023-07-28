# ClienteServidor-Usando-Thread
Uma aplicação Cliente/Servidor que utiliza Threads
- Servidor tem que atender múltiplos clientes (100 clientes)
- O Cliente envia "Olá" para o servidor
- O Servidor aguarda 1 segundo (Sleep)
- O Servidor envia "Oi" para o cliente

A aplicação deve executar em menos de 100 segundos.

>Projeto criado para uma tarefa na disciplina de Sistemas Distribuidos.

# Requisitos
- JDK 17

# Como testar
**- Clone o repo**

```git clone https://github.com/Michel172002/ClienteServidor-Usando-Thread.git```

**- Entre na pasta do projeto**

```cd ClienteServidor-Usando-Thread/```

**- Compile os arquivos Servidor.java e Cliente.java**

Ex: ```javac Servidor.java``` e ```javac Cliente.java```

**- Rode os arquivos passando o host para o Cliente e a porta para o Cliente e Servidor**

Ex: ```time java Servidor 6868``` e ```time java Cliente localhost 6868```
