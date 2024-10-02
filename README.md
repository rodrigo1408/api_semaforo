Api Semáforo Tránsito 🚦

API Java que visa simular o comportamento de um semáforo onde temos um semáforo com controle manual e logs de eventos.
O semáforo pode operar em modo automático, mas pode ser controlado manualmente quando necessário, 
e todas as mudanças de estado são registradas para auditoria ou depuração. Este sistema pode ser facilmente expandido ou adaptado para outras funcionalidades, como integração com sensores ou APIs externas.

Endpoints de exemplo:

o rodar a aplicação, o semáforo automaticamente mudará de estado com base nos tempos que definimos.

- O estado começará como **VERMELHO** e permanecerá por 10 segundos.
- Após 10 segundos, ele mudará para **VERDE** e permanecerá por 15 segundos.
- Depois disso, ele mudará para **AMARELO** por 5 segundos, e então voltará para **VERMELHO**, repetindo o ciclo.

![image](https://github.com/user-attachments/assets/1d2b9293-c7d6-47f4-846a-d89fe7cf643d)


usei o `Logger` do SLF4J, que já está integrado ao Spring Boot. O Spring Boot usa o `Logback` como a implementação padrão de log, então não é necessário adicionar dependências extras para o sistema de logs.

- Quando o semáforo muda de estado automaticamente, o log é registrado com o novo estado.
- Quando o controle manual é ativado/desativado, o log também é registrado.
- Toda vez que o estado do semáforo é alterado manualmente, isso é registrado no log.

![image](https://github.com/user-attachments/assets/b94f2a16-979f-4183-a908-f051e0bc9b03)

Os logs serão registrados no console ou arquivo (dependendo da configuração do log). Aqui está um exemplo de log:

![image](https://github.com/user-attachments/assets/74078cb8-65d0-48d4-ad21-43b5aa505dc7)


