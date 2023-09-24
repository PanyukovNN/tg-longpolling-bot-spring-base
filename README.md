# tg-longpolling-bot-spring-base

Base project, from which you can easily start to create your own longpolling telegram bot

### Run bot
Take a name and a token from <a href="https://t.me/BotFather">Link to BotFather</a>

and set them to properties:
```yaml
bot:
  name: 
  token: 
```

### Examples:
- **StartCommand.class** - how to create your own commands
- **TgBotListener.class** - reading non-command messages from user
- **TgBotListener.class** - sending messages to user
