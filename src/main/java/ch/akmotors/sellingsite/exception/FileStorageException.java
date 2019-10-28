// https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/

package ch.akmotors.sellingsite.exception;

public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}