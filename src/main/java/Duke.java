public class Duke {
    private String commandType = "";
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /** Generates a response for the user's chat message. */
    public String getResponse(String input) {
        commandType = getCommandType(input);
        return "Duke heard: " + input;
    }

    /** Returns the command category used for a response's visual treatment. */
    public String getCommandType() {
        return commandType;
    }

    private String getCommandType(String input) {
        String command = input.strip().toLowerCase();
        if (command.startsWith("todo") || command.startsWith("deadline") || command.startsWith("event")) {
            return "add";
        }
        if (command.startsWith("mark")) {
            return "marked";
        }
        if (command.startsWith("delete")) {
            return "delete";
        }
        return "";
    }
}
