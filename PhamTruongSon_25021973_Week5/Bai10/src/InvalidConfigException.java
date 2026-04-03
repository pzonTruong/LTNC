class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super("Invalid config: " + message);
    }
}