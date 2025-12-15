class QueueException extends RuntimeException {
    public QueueException(String msg) {
        super(msg);
    }
}

class QueueUnderflowException extends QueueException {
    public QueueUnderflowException() {
        super("Queue Underflow");
    }

    public QueueUnderflowException(String msg) {
        super(msg);
    }
}