public enum MessageUtils {
    PREFIX("&7[&#c6bd4bᴘ&#b9b94dᴄ&#acb550ɴ&#9fb152ᴘ&#92ac55ᴀ&#85a857ʀ&#78a45aᴛ&#6ba05cʏ&7] &7"),

    TITLE_LINE("&6&l[&r&#c6bd4b&lᴘ&#b9b94d&lᴄ&#acb550&lɴ&#9fb152&lᴘ&#92ac55&lᴀ&#85a857&lʀ&#78a45a&lᴛ&#6ba05c&lʏ&6&l]&m                          "),

    GAME_TITLE("&7&l|&r &e&l%game%"),

    GAME_DESC("   &8%desc%"),

    BREAK_LINE("&6&l&m                                                       "),

    INVALID_PERM("&7[&#c6bd4bᴘ&#b9b94dᴄ&#acb550ɴ&#9fb152ᴘ&#92ac55ᴀ&#85a857ʀ&#78a45aᴛ&#6ba05cʏ&7] &cInsufficient permissions!"),

    JOIN_MSG(
            "&6&lWELCOME TO &#c6bd4bᴘ&#b9b94dᴄ&#acb550ɴ&#9fb152ᴘ&#92ac55ᴀ&#85a857ʀ&#78a45aᴛ&#6ba05cʏ&r\n" +
            "&7&l| Recommended Volumes:\n" +
            "  &7Master: 100%\n" +
            "  &7Blocks: 50%\n" +
            "  &7Jukebox/Note Blocks: 75%\n" +
            "  &7Hostile Creatures: OFF\n" +
            "&7&l| Other Recommended Settings:\n" +
            "  &7Render Distance: 7 Chunks\n" +
            "  &7Weather : ON\n" +
            "&6Please make sure to follow PCN's \nrules and have fun! :D"
    );

    private String msg;

    MessageUtils(String msg) {
        this.msg = msg;
    }

    private Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");

    private String translate(String input) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String color = input.substring(matcher.start(), matcher.end());
            input = input.replace(color, ChatColor.of(color.replace("&", "")) + "");
            matcher = pattern.matcher(input);
        }
        return input;
    }

    public void sendToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', translate(msg)));
        }
    }

    public void sendToAllWithParam(String placeHolder, String param) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', translate(msg.replace(placeHolder, param))));
        }
    }

    public void send(Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', translate(msg)));
    }

    public void sendWithParam(Player player, String placeHolder, String param) { player.sendMessage(ChatColor.translateAlternateColorCodes('&', translate(msg.replace(placeHolder, param)))); }
}
