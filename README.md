# NetworkChecker

`NetworkChecker` is a plugin for Minecraft servers. This plugin sends player ping data to a Python bot at regular intervals and checks if the bot is running. It also provides various configuration settings and customizable messages.

## Features

- **Ping Data Sending**: Sends player ping data at regular intervals to a specified IP address and port.
- **Reload Command**: `/networkchecker reload` command to reload configuration settings without restarting the server.
- **Message Customization**: Support for customizable messages via the `messages.yml` file.

## Installation

1. Download the `NetworkChecker` plugin [here](https://github.com/Reyretee/NetworkChecker/releases/tag/NEW).
2. Upload the downloaded `.jar` file to the `plugins` directory of your Minecraft server.
3. Start or restart your server.

## Configuration

### `config.yml`

The following settings can be configured in the `config.yml` file:

```yaml
bot:
  ip: "127.0.0.1"         # IP address of the bot
  port: 25567             # Port of the bot
  interval: 300           # Interval for sending ping data (in seconds)
   ```

### `messages.yml`
The following messages can be configured in the `messages.yml` file:
```yaml
messages:
  reload_success: "&aSettings successfully reloaded!"
  reload_fail: "&cAn error occurred while reloading settings!"
   ```

## Komutlar

`/networkchecker reload`

This command reloads the `config.yml` and `messages.yml` files and updates the plugin's configuration.

## Örnek Kullanım
1. After starting the server, edit your configuration files `(config.yml and messages.yml)`.
2. Update the interval value in the `config.yml` file to change how frequently ping data is sent.
3. Use the `/networkchecker` reload command to apply your changes.

## Sorun Giderme
1. Connection Issues: If you can't connect to the bot, ensure that the IP address and port settings are correct. Also, make sure the bot is running and listening on the correct port.
2. Configuration Errors: Ensure your configuration files are formatted correctly. Errors can be checked with log messages printed to the console.