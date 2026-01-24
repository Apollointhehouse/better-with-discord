# Better With Discord

A Discord integration mod for **[Better Than Adventure](https://www.betterthanadventure.net/) 7.3** running on [Babric](https://github.com/Turnip-Labs/bta-fabric-instance-repo) mod loader.

## Features

- **Bidirectional Chat** - Messages sync between Minecraft and Discord
- **Join/Leave Notifications** - Know when players connect or disconnect
- **Death Messages** - Death announcements posted to Discord
- **Sleep Notifications** - See when players go to bed
- **Server Status** - Server start/stop messages
- **Player Avatars** - Messages show player skins via webhooks

## Installation

1. Download `better_with_discord-1.0.0.jar` from releases
2. Place the JAR in your server's `mods/` folder
3. Start the server once to generate the config file
4. Configure the mod (see below)
5. Restart the server

## Configuration

Edit `config/better_with_discord.json`:

```json
{
  "enable": true,
  "token": "YOUR_BOT_TOKEN",
  "channel": "CHANNEL_ID",
  "serverpfp_url": "https://i.imgur.com/dJUId0O.png",
  "servername": "Server"
}
```

| Option | Description |
|--------|-------------|
| `enable` | Enable/disable the Discord integration |
| `token` | Your Discord bot token |
| `channel` | The Discord channel ID for chat messages |
| `serverpfp_url` | Avatar URL for server messages (start/stop, deaths, etc.) |
| `servername` | Display name for server messages |

## Discord Bot Setup

1. Go to [Discord Developer Portal](https://discord.com/developers/applications)
2. Create a new application
3. Go to **Bot** tab and create a bot
4. Enable these **Privileged Gateway Intents**:
   - Message Content Intent
5. Copy the bot token to your config
6. Go to **OAuth2 > URL Generator**
7. Select scopes: `bot`
8. Select permissions: `Send Messages`, `Manage Webhooks`, `Read Message History`
9. Use the generated URL to invite the bot to your server
10. Copy the channel ID (right-click channel > Copy ID) to your config

## Building from Source

```bash
./gradlew build
```

The output JAR will be in `build/libs/`.

## License

Mozilla Public License Version 2.0 License - see [LICENSE](LICENSE) for details.
