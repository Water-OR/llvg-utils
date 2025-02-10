package net.llvg.loliutils.exception;

@SuppressWarnings("unused")
public class UnknownTypeException extends IllegalArgumentException {
        public UnknownTypeException() {
                super();
        }
        
        public UnknownTypeException(String message) {
                super(message);
        }
        
        public UnknownTypeException(String message, Throwable cause) {
                super(message, cause);
        }
        
        public UnknownTypeException(Throwable cause) {
                super(cause);
        }
        
        private static final long serialVersionUID = -1L;
}
