package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void tryExecute(String command) {
        int attempt = 0;
        boolean success = false;
        Exception cause = null;

        while (!success && attempt < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                success = true;
            } catch (RuntimeException e) {
                cause = e;
                attempt++;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (!success) {
            throw new ConnectionException(cause);

        }
    }
}
