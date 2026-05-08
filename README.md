# TutlaClient
**TutlaClient** is a fully featured Minecraft client featuring many utility keybinds, rendering utilities & pvp tools!

---

## ⚙️ Features & Usage

- ⚡ Easy to use
- 🌀 Amazing and Modern UI
- 🛠️ Many modules

### 🕹️ Features

<details>
<summary>🖲️ <b>Modules</b></summary>

<br>

| ⚙️ Category   | 💻 Module                              | 📖 Description                                                       |
|---------------|----------------------------------------|----------------------------------------------------------------------|
| ⚔️ PvP        | LeaveThisGoBack!                       | Add a speedrunner                                                    |
| 󰹑  Rendering | `/manhunt speedrunner remove <player>` | Remove a speedrunner                                                 |
| 󰹑  Rendering | `/manhunt hunter add <player>`         | Add a hunter                                                         |
| 󰹑  Rendering | `/manhunt hunter remove <player>`      | Remove a hunter                                                      |
| 󰹑  Rendering | `/manhunt start`                       | Start the manhunt                                                    |

</details>

<details>
<summary> 🧪 Extras </summary>

| 💻 Command | 📖 Description |
|-----------|----------------|
|`/manhunt prepare` | Waits for a speedrunner to hit a hunter to start
| `/surround <speedrunner>` | Surrounds the speedrunner with all hunters
</details>

<details>
<summary>⚙️ <b>Settings</b></summary>

<br>

| 💻 Command | 📖 Description |
|-----------|----------------|
| `/manhunt countdown <minutes>` | Set a max time limit ⏱️ (**0 to disable**) |
| `/manhunt twist <twist>` | Apply a twist (default: `DEFAULT`) |
| `/manhunt help` | Open the help menu 📖 |

</details>

<details>
<summary>🌀 <b>Custom Twist Creator</b></summary>

<br>

| 💻 Command | 📖 Description |
|-----------|----------------|
| `/twist create <name:one_word>` | Create a new twist |
| `/twist help` | Show help for twist commands |
| `/twist list` | List all twists |
| `/twist effect <twist_name> <effect>` | Set twist output action |
| `/twist trigger <twist_name> <trigger>` | Set twist trigger |
| `/twist triggerentity <entity>` | Set trigger entity |
| `/twist triggerblock <block>` | Set trigger block |
| `/twist appliesto <group>` | Set who can trigger the twist |
| `/twist lootpool <twist_name> <lootpool_name>` | Assign a lootpool |
| `/twist description <twist_name> <description>` | Set twist description |

</details>

<details>
<summary>📦 <b>LootPool Commands</b></summary>

<br>

| 💻 Command | 📖 Description |
|-----------|----------------|
| `/lootpool create <name:one_word>` | Create a new lootpool |
| `/lootpool pool add <item> <number> <weight>` | Add item to pool |
| `/lootpool pool remove <index>` | Remove item by index |
| `/lootpool pool list` | List pool items |
| `/lootpool tier create <name>` | Start a new lootpool tier |
| `/lootpool tier cancel` | Cancel tier creation |
| `/lootpool tier complete` | Finish and save tier |
| `/lootpool tier add <item>` | Add item to current tier |
| `/lootpool tier remove <index>` | Remove item from tier |
| `/lootpool delete <name>` | Delete a lootpool |
| `/lootpool difficultymultiplier <decimal>` | Set difficulty multiplier |
| `/lootpool complete` | Complete lootpool |
| `/lootpool list` | List all lootpools |
| `/lootpool cancel` | Cancel lootpool creation |
| `/lootpool help` | Show help for lootpool commands |

</details>

---

### 🌀 Default Twists
- `DEFAULT` – Standard manhunt rules
- `PIG_OP_LOOT` – Pigs drop OP loot (only for the speedrunner 🐷💎)
- **More twists coming soon! 🔧**

---

## 🛠️ Configuration

🗂️ Navigate to your server folder → `plugins/ManhuntPlus/config.yml`

- Calibration
    - `auto-calibration`: Enable/Disable auto compass calibration
    - `auto-calibration-interval` - Set the interval on which the compass updates. Recommended to increase this if used on larger servers or even completely disable it, restart server to apply changes
- Broadcasting
    - `broadcast-time`: true
    - `broadcast-time-every` - Broadcast time interval(in seconds)
- `surround-radius: DECIMAL` – Distance between speedrunner and hunters when using `/surround`. Default: `3`
- `name-tracking-compass`: Name the compass to which player its tracking
---

## 🚧 Coming Soon
- 🌀 Many more twists
- 📊 Leaderboards?
- 🛠️ More customizability

---

## 💬 Support, Tracking & More

- 💬 Join our [**Discord**](https://discord.tutla.net) for sneak peeks & community support
- ⭐ Star us on [**GitHub**](https://github.com/TutlaMC/manhunt-plus)
- 🌐 Visit our [**Website**](https://tutla.net) for updates
- 💙 Contribute by [**donating**](https://donatr.ee/tutlamc?utm_source=copy&utm_medium=share)

Think we’re missing something? **Contribute on [GitHub](https://github.com/TutlaMC/manhunt-plus)**

---

## 🧪 Other Tutla Studio Projects

- ⚔️ [**PvP+**](https://modrinth.com/plugin/pvp+plugin) – A Comprehensive PvP Plugin for Paper servers
- 🛡️ [**LeaveBind!**](https://modrinth.com/mod/leavebind) – Leave the server with a click of a button
- 🧾 [**Leave This, GoBack!**](https://modrinth.com/mod/leave-this-go-back) – Pressing on a slot twice returns you back to the previous slot. Useful for attribute swapping / quick tool swapping / mace pvp 
