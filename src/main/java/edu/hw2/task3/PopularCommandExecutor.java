package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void tryExecute(String command) {
        Connection connection = null;
        int attempt = 0;
        boolean success = false;
        Exception cause = null;

        while (!success && attempt < maxAttempts) {
            try {
                connection = manager.getConnection();
                connection.execute(command);
                success = true;
            } catch (ConnectionException e) {
                cause = e;
                attempt++;
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        // Обработка исключения при закрытии соединения
                    }
                }
            }
        }

        if (!success) {
            //throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts.", cause);
            throw new ConnectionException(cause);

        }
    }
}
